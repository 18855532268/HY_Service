package com.yajie.huayi.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yajie.huayi.constant.ConstantsForDomain;
import com.yajie.huayi.domain.*;
import com.yajie.huayi.domain.other.ProduceDateEntity;
import com.yajie.huayi.domain.other.TodayTaskEntity;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.exception.ErrorRollbackException;
import com.yajie.huayi.mapper.*;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.util.Page;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Production.*;
import com.yajie.huayi.vo.Project.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/4 10:19
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class ProductionService {
    @Autowired
    private ProductionMapper productionMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ComponentMapper componentMapper;
    @Autowired
    private ComponentTypeMapper componentTypeMapper;
    @Autowired
    private VolumeGapMapper volumeGapMapper;
    @Autowired
    private MaterialsMapper materialsMapper;
    @Autowired
    private MaterialsRecordMapper materialsRecordMapper;
    @Autowired
    private MoldMapper moldMapper;
    @Autowired
    private MoldRecordMapper moldRecordMapper;
    @Autowired
    private ComponentProgressRecordMapper componentProgressRecordMapper;
    @Autowired
    private ComponentInspectionRecordMapper componentInspectionRecordMapper;
    // 还未进行批量添加处理
    public void addProduction(ProductionVo productionVo) {
        log.info("添加生产单：{}", JSONObject.toJSONString(productionVo));

        Project project = projectMapper.selectByPrimaryKey(productionVo.getProjectId());
        ComponentType componentType = componentTypeMapper.selectByPrimaryKey(productionVo.getComponentTypeId());
        User handle = userMapper.selectByPrimaryKey(productionVo.getHandleId());
        CommonUtil.checkParameters(project, componentType, handle);

        Double volumeGap = 0d;
        for (GapVo gapVo : productionVo.getGapVos()) {
            volumeGap += gapVo.getHeightGap() * gapVo.getLengthGap() * gapVo.getWidthGap();
        }
        // 添加生产单
        Production production = new Production();
        production.setProjectId(productionVo.getProjectId());
        production.setProductNum(productionVo.getProductNum());
        production.setDrawingsUrl(productionVo.getDrawingsUrl());
        production.setComponentTypeId(productionVo.getComponentTypeId());
        production.setBuildingNos(CommonUtil.arrayToString(productionVo.getBuildingNos()));
        production.setFloorNos(CommonUtil.arrayToString(productionVo.getFloorNos()));
        production.setLength(productionVo.getLength());
        production.setWidth(productionVo.getWidth());
        production.setHeight(productionVo.getHeight());
        production.setVolume(productionVo.getHeight() * productionVo.getWidth() * productionVo.getLength() - volumeGap);
        production.setActualvolume(productionVo.getActualVolume());
        production.setHandleId(productionVo.getHandleId());
        production.setHandleName(handle.getUsername());
        production.setStatus(ConstantsForDomain.PRODUCTION_UNAUDIT);
        production.setCreateAt(new Date());
        production.setUpdateAt(new Date());
        productionMapper.insert(production);
        log.info("添加生产单：{}", JSONObject.toJSONString(production));


        // 添加构件
        for (Integer buildingNo : productionVo.getBuildingNos()) {
            List<Component> components = new ArrayList<>();
            for (Integer floorNo : productionVo.getFloorNos()) {
                Component component = new Component();

                component.setNumber(project.getName()+ "-" + buildingNo +"#"+ floorNo + production.getProductNum());
                component.setProjectId(project.getId());
                component.setProductionId(production.getId());
                component.setBuildingNo(buildingNo);
                component.setFloorNo(floorNo);
                component.setTypeId(componentType.getId());
                component.setCreateId(handle.getId());
                component.setCreateName(handle.getUsername());
                component.setLength(productionVo.getLength());
                component.setWidth(productionVo.getWidth());
                component.setHeight(productionVo.getHeight());
                component.setVolume(productionVo.getHeight() * productionVo.getWidth() * productionVo.getLength() - volumeGap);
                component.setActualVolume(productionVo.getActualVolume());
                component.setStatus(ConstantsForDomain.COMPONENT_STATUS_NORMAL);
                component.setCreateAt(new Date());
                component.setUpdateAt(new Date());
                componentMapper.insert(component);

                for (GapVo gapVo : productionVo.getGapVos()) {
                    VolumeGap gap = new VolumeGap();
                    gap.setProductionId(production.getId());
                    gap.setComponentId(component.getId());
                    gap.setLengthGap(gapVo.getLengthGap());
                    gap.setHeightGap(gapVo.getHeightGap());
                    gap.setWidthGap(gapVo.getWidthGap());
                    gap.setVolume(gapVo.getHeightGap() * gapVo.getLengthGap() * gapVo.getWidthGap());
                    gap.setCreateAt(new Date());
                    gap.setUpdateAt(new Date());
                    volumeGapMapper.insert(gap);
                }
                log.info("添加生产单中的缺口方量：{}", JSONObject.toJSONString(productionVo.getGapVos()));
                for (MaterialsRecordVo steel : productionVo.getSteels()) {
                    Materials materials = materialsMapper.selectByPrimaryKey(steel.getMaterialsId());
                    if (materials == null){
                        throw new ErrorMessageException("该原材料不存在");
                    }
                    MaterialsRecord record = new MaterialsRecord();
                    record.setProductionId(component.getProductionId());
                    record.setComponentId(component.getId());
                    record.setMaterialsId(steel.getMaterialsId());
                    record.setCount(steel.getCount());
                    record.setName(materials.getName());
                    record.setSpecifications(materials.getSpecifications());
                    record.setSteelContent(materials.getSteelContent() == null ? "" : materials.getSteelContent());
                    record.setRemark(steel.getRemark());
                    record.setType(ConstantsForDomain.MATERIALS_TYPE_STEEL);
                    record.setStatus(ConstantsForDomain.MATERIALS_RECORD_STATUS_NORMAL);
                    materialsRecordMapper.insert(record);
                }
                log.info("添加生产单中的钢筋：{}", JSONObject.toJSONString(productionVo.getSteels()));
                for (MaterialsRecordVo parts : productionVo.getParts()) {
                    Materials materials = materialsMapper.selectByPrimaryKey(parts.getMaterialsId());
                    if (materials == null){
                        throw new ErrorMessageException("该原材料不存在");
                    }
                    MaterialsRecord record = new MaterialsRecord();
                    record.setProductionId(component.getProductionId());
                    record.setComponentId(component.getId());
                    record.setMaterialsId(parts.getMaterialsId());
                    record.setCount(parts.getCount());
                    record.setName(materials.getName());
                    record.setSpecifications(materials.getSpecifications());
                    record.setSteelContent(materials.getSteelContent() == null ? "" : materials.getSteelContent());
                    record.setRemark(parts.getRemark());
                    record.setType(ConstantsForDomain.MATERIALS_TYPE_PART);
                    record.setStatus(ConstantsForDomain.MATERIALS_RECORD_STATUS_NORMAL);
                    materialsRecordMapper.insert(record);
                }
                log.info("添加生产单中的预埋件：{}", JSONObject.toJSONString(productionVo.getParts()));
                for (MoldVo moldVo : productionVo.getMolds()) {
                    Mold mold = moldMapper.selectByPrimaryKey(moldVo.getMoldId());
                    if (mold == null){
                        throw new ErrorMessageException("该模具不存在或不可用");
                    }
                    MoldRecord moldRecord = new MoldRecord();
                    moldRecord.setMoldId(mold.getId());
                    moldRecord.setProductionId(production.getId());
                    moldRecord.setComponentId(component.getId());
                    moldRecord.setRemark(moldVo.getRemark());
                    moldRecord.setCreateAt(new Date());
                    moldRecord.setUpdateAt(new Date());
                    moldRecordMapper.insert(moldRecord);
                }
                log.info("添加生产单中的模具：{}", JSONObject.toJSONString(productionVo.getMolds()));
            }
            log.info("添加生产单中的构件：{}", JSONObject.toJSONString(productionVo.getFloorNos()));

        }

    }

    public Page<ComponentPageVo> getComponentPage(String number, Long projectId, Long componentTypeId, Integer buildingNo, Integer floorNoStart, Integer floorNoEnd, PageRequest pageRequest) {
        List<ComponentPageVo> vos = new ArrayList<>();
        Long count = componentMapper.findCount(number, projectId, componentTypeId, buildingNo, floorNoStart, floorNoEnd, null, null );
        if (count > 0) {
            List<Component> list = componentMapper.findPage(number, projectId, componentTypeId, buildingNo, floorNoStart, floorNoEnd, null, null, pageRequest);
            for (Component component : list) {
                Production production = productionMapper.selectOne(Wrappers.<Production>lambdaQuery().eq(Production::getId, component.getProductionId()).ne(Production::getStatus, ConstantsForDomain.DELETE));
                Project project = projectMapper.selectOne(Wrappers.<Project>lambdaQuery().eq(Project::getId, production.getProjectId()).ne(Project::getStatus, ConstantsForDomain.DELETE));
                ComponentType componentType = componentTypeMapper.selectOne(Wrappers.<ComponentType>lambdaQuery().eq(ComponentType::getId, component.getTypeId()));
                vos.add(ComponentPageVo.of(component, componentType, project));
            }
        }
        log.info("获取构件分页：{}", JSONObject.toJSONString(vos));

        return new Page<>(pageRequest, vos, count);
    }

    public Page<ComponentTypePageVo> getComponentTypePage(String key, PageRequest pageRequest) {
        List<ComponentTypePageVo> vos = new ArrayList<>();
        Long count = componentTypeMapper.findCount(key);
        if (count > 0) {
            List<ComponentType> list = componentTypeMapper.findPage(key, pageRequest);
            for (ComponentType componentType : list) {
                User user = userMapper.selectByPrimaryKey(componentType.getCreateId());
                vos.add(ComponentTypePageVo.of(componentType, user));
            }
        }
        return new Page<>(pageRequest, vos, count);
    }

    public ProjectInfoVo getProjectInfo(Long id) {
        List<ProductionDetailsVo> detailsVos = new ArrayList<>();
        Project project = projectMapper.selectByPrimaryKey(id);
        CommonUtil.checkParameters(project);
        Integer count = productionMapper.selectCount(Wrappers.<Production>lambdaQuery().eq(Production::getProjectId, project.getId()).ne(Production::getStatus, ConstantsForDomain.DELETE));
        if (count > 0){
            List<Production> productions = productionMapper.selectList(Wrappers.<Production>lambdaQuery().eq(Production::getProjectId, project.getId()).ne(Production::getStatus, ConstantsForDomain.DELETE));
            for (Production production : productions){
                List<MoldDetailsVo> vos = new ArrayList<>();
                List<Component> components = componentMapper.selectList(Wrappers.<Component>lambdaQuery().eq(Component::getProductionId, production.getId()));
                List<VolumeGap> gaps = volumeGapMapper.selectList(Wrappers.<VolumeGap>lambdaQuery().eq(VolumeGap::getProductionId, production.getId()));
                List<MaterialsRecord> steels = materialsRecordMapper.selectList(Wrappers.<MaterialsRecord>lambdaQuery().eq(MaterialsRecord::getProductionId, production.getId()).eq(MaterialsRecord::getType, ConstantsForDomain.MATERIALS_TYPE_STEEL));
                List<MaterialsRecord> parts = materialsRecordMapper.selectList(Wrappers.<MaterialsRecord>lambdaQuery().eq(MaterialsRecord::getProductionId, production.getId()).eq(MaterialsRecord::getType, ConstantsForDomain.MATERIALS_TYPE_PART));
                List<MoldRecord> molds = moldRecordMapper.selectList(Wrappers.<MoldRecord>lambdaQuery().eq(MoldRecord::getProductionId, production.getId()));
                for (MoldRecord moldRecord : molds){
                    Mold mold = moldMapper.selectByPrimaryKey(moldRecord.getMoldId());
                    vos.add(MoldDetailsVo.of(mold, moldRecord));
                }
                User hander = userMapper.selectByPrimaryKey(production.getHandleId());
                detailsVos.add(ProductionDetailsVo.of(production, GapVo.of(gaps), MaterialsRecordDetailsVo.of(steels),  MaterialsRecordDetailsVo.of(parts),  vos, hander));
            }
        }
        return ProjectInfoVo.of(ProjectDetailsVo.of(project), detailsVos);
    }

    public Page<ProducePageVo> getProductionPage(String productNum, String projectNum, Integer status, PageRequest pageRequest) {
        List<ProducePageVo> vos = new ArrayList<>();
        Long count = componentMapper.findCount(productNum, null, null, null, null, null, projectNum, status);
        if (count > 0){
            List<Component> list = componentMapper.findPage(productNum, null, null, null, null, null, projectNum, status, pageRequest);
            for (Component component : list){
                Project project = projectMapper.selectByPrimaryKey(component.getProjectId());
                User steeler = userMapper.selectByPrimaryKey(component.getSteelId());
                User molder = userMapper.selectByPrimaryKey(component.getMolderId());
                Mold mold = moldMapper.selectByPrimaryKey(component.getMoldId());
                User demouer = userMapper.selectByPrimaryKey(component.getDemouldId());
                User finisher = userMapper.selectByPrimaryKey(component.getFinishedId());

                vos.add(ProducePageVo.of(project, component, steeler, molder, mold, demouer, finisher));
            }
        }
        return new Page<>(pageRequest, vos, count);
    }

    public void Scheduling(SchedulingVo schedulingVo) {
        Mold mold = moldMapper.selectByPrimaryKey(schedulingVo.getMoldId());
        CommonUtil.checkParameters(mold);
        for (Long l: schedulingVo.getComponentIds()){
            Component component = componentMapper.selectByPrimaryKey(l);
            CommonUtil.checkParameters(component);

            if (component.getStatus().equals(ConstantsForDomain.COMPONENT_STATUS_PRODUCTION)){
                Date date = new Date();

                List<Date> dates = new ArrayList<>();
                dates.add(component.getSteelBarBindingAt());
                dates.add(component.getMoldieAt());
                dates.add(component.getPourAt());
                dates.add(component.getDemouldAt());
                Date max = Collections.max(dates);
                if (max.before(date)){
                    throw new ErrorRollbackException("构件"+component.getNumber()+"不可修改");
                }

            }
            component.setSteelBarBindingAt(CommonUtil.stringToDate(schedulingVo.getSteelBarBindingAt()));
            component.setSteelArea(schedulingVo.getSteelArea());
            component.setMoldieAt(CommonUtil.stringToDate(schedulingVo.getMoldieAt()));
            component.setMoldId(mold.getId());
            component.setPourAt(CommonUtil.stringToDate(schedulingVo.getPourAt()));
            component.setDemouldAt(CommonUtil.stringToDate(schedulingVo.getDemouldAt()));
            component.setUpdateAt(new Date());
            component.setStatus(ConstantsForDomain.COMPONENT_STATUS_PRODUCTION);
            componentMapper.updateByPrimaryKey(component);

            componentProgressRecordMapper.delete(Wrappers.<ComponentProgressRecord>lambdaQuery().eq(ComponentProgressRecord::getComponentId, component.getId()));
            log.info("删除之前的排单：{}",component);

            ComponentProgressRecord steelBarBindingRecord = new ComponentProgressRecord();
            steelBarBindingRecord.setComponentId(component.getId());
            steelBarBindingRecord.setRowsAt(CommonUtil.stringToDate(schedulingVo.getSteelBarBindingAt()));
            steelBarBindingRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL);
            steelBarBindingRecord.setProgressDetails(ConstantsForDomain.COMPONENT_PROGRESS_STEEL);
            steelBarBindingRecord.setType(ConstantsForDomain.COMPONENT_PROGRESS_STEEL_TYPE);
            componentProgressRecordMapper.insert(steelBarBindingRecord);

            ComponentProgressRecord moldieRecord = new ComponentProgressRecord();
            moldieRecord.setComponentId(component.getId());
            moldieRecord.setRowsAt(CommonUtil.stringToDate(schedulingVo.getMoldieAt()));
            moldieRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL);
            moldieRecord.setProgressDetails(ConstantsForDomain.COMPONENT_PROGRESS_MOLD);
            moldieRecord.setType(ConstantsForDomain.COMPONENT_PROGRESS_MOLD_TYPE);
            componentProgressRecordMapper.insert(moldieRecord);

            ComponentProgressRecord pourRecord = new ComponentProgressRecord();
            pourRecord.setComponentId(component.getId());
            pourRecord.setRowsAt(CommonUtil.stringToDate(schedulingVo.getPourAt()));
            pourRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL);
            pourRecord.setProgressDetails(ConstantsForDomain.COMPONENT_PROGRESS_POUR);
            pourRecord.setType(ConstantsForDomain.COMPONENT_PROGRESS_POUR_TYPE);
            componentProgressRecordMapper.insert(pourRecord);

            ComponentProgressRecord demouldRecord = new ComponentProgressRecord();
            demouldRecord.setComponentId(component.getId());
            demouldRecord.setRowsAt(CommonUtil.stringToDate(schedulingVo.getDemouldAt()));
            demouldRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL);
            demouldRecord.setProgressDetails(ConstantsForDomain.COMPONENT_PROGRESS_DEMOULD);
            demouldRecord.setType(ConstantsForDomain.COMPONENT_PROGRESS_DEMOULD_TYPE);
            componentProgressRecordMapper.insert(demouldRecord);
        }
        log.info("更新排单：{}",JSONObject.toJSONString(schedulingVo));
    }

    /**
     * 查看历史进度
     * @param id
     * @return
     */
    public ProductionInfoVo getProgressPage(Long id) {
        List<MoldDetailsVo> moldDetailsVos = new ArrayList<>();
        List<ComponentProgressRecordVo> componentProgressRecordVos = new ArrayList<>();
        List<ComponentInspectionRecordVo> componentInspectionRecordVos = new ArrayList<>();
        Component component = componentMapper.selectByPrimaryKey(id);
        CommonUtil.checkParameters(component);
        ComponentType componentType = componentTypeMapper.selectByPrimaryKey(component.getTypeId());
        List<MaterialsRecord> steels = materialsRecordMapper.selectList(Wrappers.<MaterialsRecord>lambdaQuery().eq(MaterialsRecord::getComponentId, component.getId()).eq(MaterialsRecord::getType, ConstantsForDomain.MATERIALS_TYPE_STEEL));
        List<MaterialsRecord> parts = materialsRecordMapper.selectList(Wrappers.<MaterialsRecord>lambdaQuery().eq(MaterialsRecord::getComponentId, component.getId()).eq(MaterialsRecord::getType, ConstantsForDomain.MATERIALS_TYPE_PART));
        List<MoldRecord> moldRecords = moldRecordMapper.selectList(Wrappers.<MoldRecord>lambdaQuery().eq(MoldRecord::getComponentId, component.getId()));
        for (MoldRecord moldRecord : moldRecords){
            Mold mold = moldMapper.selectByPrimaryKey(moldRecord.getMoldId());
            moldDetailsVos.add(MoldDetailsVo.of(mold, moldRecord));
        }
        List<ComponentProgressRecord> componentProgressRecords = componentProgressRecordMapper.selectList(Wrappers.<ComponentProgressRecord>lambdaQuery().eq(ComponentProgressRecord::getComponentId, component.getId()));
        for (ComponentProgressRecord componentProgressRecord : componentProgressRecords){
            User operator = userMapper.selectByPrimaryKey(componentProgressRecord.getOperatorId());
            componentProgressRecordVos.add(ComponentProgressRecordVo.of(componentProgressRecord, operator));
        }
        List<ComponentInspectionRecord> componentInspectionRecords = componentInspectionRecordMapper.selectList(Wrappers.<ComponentInspectionRecord>lambdaQuery().eq(ComponentInspectionRecord::getComponentId, component.getId()));
        for (ComponentInspectionRecord componentInspectionRecord : componentInspectionRecords){
            User inspector = userMapper.selectByPrimaryKey(componentInspectionRecord.getInspectorId());
            componentInspectionRecordVos.add(ComponentInspectionRecordVo.of(componentInspectionRecord, inspector));
        }
        return ProductionInfoVo.of(ComponentDetailsVo.of(component, componentType),
                MaterialsRecordDetailsVo.of(steels), MaterialsRecordDetailsVo.of(parts), moldDetailsVos, componentProgressRecordVos, componentInspectionRecordVos);
    }

    public List<ProduceDateVo> getProduceDate(String startDate, String endDate){
        CommonUtil.checkParameters(startDate, endDate);
        List<ProduceDateVo> vos = new ArrayList<>();
        List<ProduceDateEntity> produceDate = componentProgressRecordMapper.findProduceDate(startDate, endDate);
        List<String> dates = addDates(startDate, endDate);
        for (String date: dates){
            List<ProduceDateEntity> produceDateEntities = new ArrayList<>();

            // 将一天内的数据放在一起
            for (ProduceDateEntity produceDateEntity : produceDate){
                if (produceDateEntity.getDate().equals(date)){
                    produceDateEntities.add(produceDateEntity);
                }
            }
            vos.add(ProduceDateVo.of(date, produceDateEntities));
        }
        return vos;
    }

    public OperationTaskInfoVo getTodayTasks(Long operationId, Integer operationStatus, Integer operationType, PageRequest pageRequest){
        Long count = componentProgressRecordMapper.findCount(operationId, operationStatus,  operationType);
        List<TodayTaskEntity> page = new ArrayList<>();
        Integer operationComplete = 0;
        if (count > 0){
            page = componentProgressRecordMapper.findPage(operationId, operationStatus, operationType, pageRequest);
            operationComplete = componentProgressRecordMapper.selectCount(Wrappers.<ComponentProgressRecord>lambdaQuery().eq(ComponentProgressRecord::getStatus, ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL));

        }
        Page<OperationTaskVo> voPage = new Page<>(pageRequest, OperationTaskVo.of(page), count);

        return OperationTaskInfoVo.of(count, Long.valueOf(operationComplete), voPage);
    }
    public void operationTaskOver(Long id, Long operationId, String remark, String imgUrl) {
        ComponentProgressRecord componentProgressRecord = componentProgressRecordMapper.selectByPrimaryKey(id);
        User operationer = userMapper.selectByPrimaryKey(operationId);
        // 参数判断
        checkNum(componentProgressRecord, operationer);
        componentProgressRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_FINISHED);
        componentProgressRecord.setOperatorId(operationer.getId());
        componentProgressRecord.setRemark(remark);
        componentProgressRecord.setImgUrl(imgUrl);
        componentProgressRecord.setOperationAt(new Date());
        componentProgressRecordMapper.updateByPrimaryKey(componentProgressRecord);
        log.info("操作工提交完成：{}",JSONObject.toJSONString(componentProgressRecord));

        if (componentProgressRecord.getType() != ConstantsForDomain.COMPONENT_PROGRESS_POUR_TYPE){
            ComponentInspectionRecord componentInspectionRecord = new ComponentInspectionRecord();
            componentInspectionRecord.setComponentId(componentProgressRecord.getComponentId());
            componentInspectionRecord.setStatus(ConstantsForDomain.COMPONENT_PROGRESS_STATUS_NORMAL);
            componentInspectionRecord.setType(componentProgressRecord.getType());
            componentInspectionRecordMapper.insert(componentInspectionRecord);
        }
    }

    private void checkNum(ComponentProgressRecord componentProgressRecord, User operationer) {
        if (operationer == null){
            throw new ErrorRollbackException("该人员不存在");
        }
        if (componentProgressRecord == null || componentProgressRecord.getStatus() == ConstantsForDomain.COMPONENT_PROGRESS_STATUS_FINISHED){
            throw new ErrorRollbackException("该任务不存在或已完成");
        }
        // 判断是否进行了搭模质检
        if (componentProgressRecord.getType() == ConstantsForDomain.COMPONENT_PROGRESS_MOLD_TYPE){
            ComponentInspectionRecord componentInspectionRecord = componentInspectionRecordMapper.selectOne(Wrappers.<ComponentInspectionRecord>lambdaQuery().eq(ComponentInspectionRecord::getComponentId, componentProgressRecord.getComponentId()).eq(ComponentInspectionRecord::getType, ConstantsForDomain.COMPONENT_INSPECTION_MOLD_TYPE));
            if (componentInspectionRecord == null){
                throw new ErrorRollbackException("该构件还未进行搭模质检");
            }
        }
    }


    /**
     * 获得时间段内的天数
     * @param startDate
     * @param endDate
     * @return
     */
    private List<String> addDates(String startDate, String endDate) {
        List<String> list = new ArrayList<>();
        //拆分成数组
        String[] dateBegs = startDate.split("-");
        String[] dateEnds = endDate.split("-");
        //开始时间转换成时间戳
        Calendar start = Calendar.getInstance();
        start.set(Integer.valueOf(dateBegs[0]), Integer.valueOf(dateBegs[1]) - 1, Integer.valueOf(dateBegs[2]));
        Long startTIme = start.getTimeInMillis();
        //结束时间转换成时间戳
        Calendar end = Calendar.getInstance();
        end.set(Integer.valueOf(dateEnds[0]), Integer.valueOf(dateEnds[1]) - 1, Integer.valueOf(dateEnds[2]));
        Long endTime = end.getTimeInMillis();
        //定义一个一天的时间戳时长
        Long oneDay = 1000 * 60 * 60 * 24l;
        Long time = startTIme;
        //循环得出
        while (time <= endTime) {
            list.add(new SimpleDateFormat("yyyy-MM-dd").format(new Date(time)));
            time += oneDay;
        }
        return list;
    }
}
