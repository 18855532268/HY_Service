package com.yajie.huayi.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yajie.huayi.constant.ConstantsForDomain;
import com.yajie.huayi.domain.Project;
import com.yajie.huayi.domain.ProjectRecord;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.mapper.ProjectMapper;
import com.yajie.huayi.mapper.ProjectRecordMapper;
import com.yajie.huayi.mapper.UserMapper;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.util.Page;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Project.ProjectPageVo;
import com.yajie.huayi.vo.Project.ProjectRecordPageVo;
import com.yajie.huayi.vo.Project.ProjectRecordVo;
import com.yajie.huayi.vo.Project.ProjectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Project)表服务实现类
 *
 * @author makejava
 * @since 2020-06-29 16:29:07
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectRecordMapper projectRecordMapper;
    @Autowired
    private UserMapper userMapper;

    public void addOrModifyProject(ProjectVo projectVo) {
        User customer = userMapper.selectByPrimaryKey(projectVo.getCustomerId());
        User signer = userMapper.selectByPrimaryKey(projectVo.getSignerId());
        if (projectVo.getId() == null){
            // 检查传入参数是否合法
            User handle = userMapper.selectByPrimaryKey(projectVo.getHandleId());
            CommonUtil.checkParameters(customer, signer, handle);
            Project project = new Project();
            project.setName(projectVo.getName());
            project.setAddress(projectVo.getAddress());
            project.setShortName(projectVo.getShortName());
            project.setCustomerId(customer.getId());
            project.setCustomerName(projectVo.getCustomerName());
            project.setCustomerCompany(projectVo.getCustomerCompany());
            project.setTelephone(projectVo.getTelephone());
            project.setContractAt(CommonUtil.stringToDate(projectVo.getContractAt()));
            project.setSignerId(projectVo.getSignerId());
            project.setSignerId(signer.getId());
            project.setSignerName(signer.getUsername());
            project.setContract(projectVo.getContract());
            project.setHandleId(handle.getId());
            project.setHandleName(handle.getUsername());
            project.setHandleAt(new Date());
            project.setNumber(projectVo.getNumber());
            project.setCreateAt(new Date());
            project.setUpdateAt(new Date());
            project.setStatus(ConstantsForDomain.PROJECT_CUSTOMER_UNAUDIT);

            projectMapper.insert(project);

            for (ProjectRecordVo projectRecordVo : projectVo.getProjectRecordVos()) {
                ProjectRecord record = new ProjectRecord();
                record.setProjectId(project.getId());
                record.setName(projectRecordVo.getName());
                record.setSpecificas(projectRecordVo.getSpecificas());
                record.setCount(projectRecordVo.getCount());
                record.setUnit(projectRecordVo.getUnit());
                record.setUnitPrice(String.valueOf(projectRecordVo.getUnitPrice()));
                record.setTotalPrice(String.valueOf(projectRecordVo.getUnitPrice() * projectRecordVo.getCount()));
                record.setCreateAt(new Date());
                record.setUpdateAt(new Date());
                projectRecordMapper.insert(record);
            }
        }else {
            // 检查传入参数是否合法
            Project project = projectMapper.selectByPrimaryKey(projectVo.getId());
            CommonUtil.checkParameters(project, customer, signer);

            project.setName(projectVo.getName());
            project.setShortName(projectVo.getShortName());
            project.setCustomerId(projectVo.getCustomerId());
            project.setCustomerCompany(projectVo.getCustomerCompany());
            project.setCustomerName(projectVo.getCustomerName());
            project.setTelephone(projectVo.getTelephone());
            project.setSignerId(projectVo.getSignerId());
            project.setSignerName(signer.getUsername());
            project.setContractAt(CommonUtil.stringToDate(projectVo.getContractAt()));
            project.setContract(projectVo.getContract());
            project.setUpdateAt(new Date());

            projectMapper.updateByPrimaryKey(project);

            for (ProjectRecordVo projectRecordVo : projectVo.getProjectRecordVos()) {
                ProjectRecord record = projectRecordMapper.selectByPrimaryKey(projectRecordVo.getId());
                record.setName(projectRecordVo.getName());
                record.setSpecificas(projectRecordVo.getSpecificas());
                record.setCount(projectRecordVo.getCount());
                record.setUnit(projectRecordVo.getUnit());
                record.setUnitPrice(String.valueOf(projectRecordVo.getUnitPrice()));
                record.setTotalPrice(String.valueOf(projectRecordVo.getUnitPrice() * projectRecordVo.getCount()));
                record.setUpdateAt(new Date());
                projectRecordMapper.updateByPrimaryKey(record);
            }
        }

    }

    public Page<ProjectPageVo> getProjectPage(String key, String signStartDate, String signEndDate, Integer status, PageRequest pageRequest) {
        Long count = projectMapper.findCount(key, signStartDate, signEndDate, status);
        List<ProjectPageVo> vos = new ArrayList<>();
        if (count > 0) {
            List<Project> page = projectMapper.findPage(key, signStartDate, signEndDate, status, pageRequest);
            for (Project project : page) {
                // 项目内容
                List<ProjectRecord> recordList = projectRecordMapper.selectList(Wrappers.<ProjectRecord>lambdaQuery().eq(ProjectRecord::getProjectId, project.getId()));
               log.info("返回：{}", JSONObject.toJSONString(recordList));
                vos.add(ProjectPageVo.of(project,  ProjectRecordPageVo.of(recordList)));
            }
        }
        return new Page<>(pageRequest, vos, count);
    }


    public void updateProjectStatus(Long id, Integer status) {

        CommonUtil.checkParameters(id, status);
        // 检查传入参数是否合法
        Project project = projectMapper.selectByPrimaryKey(id);
        CommonUtil.checkParameters(project);
        project.setStatus(status);
        project.setUpdateAt(new Date());
        projectMapper.updateByPrimaryKey(project);
    }
}