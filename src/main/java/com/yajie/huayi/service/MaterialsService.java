package com.yajie.huayi.service;

import com.alibaba.fastjson.JSONObject;
import com.yajie.huayi.constant.ConstantsForDomain;
import com.yajie.huayi.domain.Materials;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.mapper.MaterialsMapper;
import com.yajie.huayi.mapper.MoldMapper;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.util.Page;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Materials.MaterialsPageVo;
import com.yajie.huayi.vo.Materials.MaterialsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 17:55
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class MaterialsService {
    @Autowired
    private MoldMapper moldMapper;
    @Autowired
    private MaterialsMapper materialsMapper;


    public void addOrModifyMaterials(MaterialsVo materialsVo) {
        if (materialsVo.getId() == null) {
            CommonUtil.checkParameters(materialsVo);
            Materials materials = new Materials();
            materials.setNumber(materialsVo.getNumber());
            materials.setName(materialsVo.getName());
            materials.setCount(materialsVo.getCount());
            materials.setSpecifications(materialsVo.getSpecifications());
            materials.setSteelContent(materialsVo.getSteelContent());
            materials.setModel(materialsVo.getModel());
            materials.setType(materialsVo.getType());
            materials.setUnit(materialsVo.getUnit());
            materials.setStatus(ConstantsForDomain.MATERIALS_STATUS_NORMAL);
            materials.setCreateAt(new Date());
            materials.setUpdateAt(new Date());
            materialsMapper.insert(materials);
            log.info("添加原材料：{}", JSONObject.toJSONString(materials));
        }
        if (materialsVo.getId() != null) {
            Materials materials = materialsMapper.selectByPrimaryKey(materialsVo.getId());
            CommonUtil.checkParameters(materials);
            materials.setNumber(materialsVo.getNumber());
            materials.setName(materialsVo.getName());
            materials.setCount(materialsVo.getCount());
            materials.setSpecifications(materialsVo.getSpecifications());
            materials.setSteelContent(materialsVo.getSteelContent());
            materials.setModel(materialsVo.getModel());
            materials.setUnit(materialsVo.getUnit());
            materials.setType(materialsVo.getType());
            materials.setUpdateAt(new Date());
            materialsMapper.updateByPrimaryKey(materials);
            log.info("修改原材料：{}", JSONObject.toJSONString(materials));

        }

    }

    public void deleteMaterials(Long id) {
        CommonUtil.checkParameters(id);
        Materials materials = materialsMapper.selectByPrimaryKey(id);
        if (materials == null) {
            throw new ErrorMessageException("该原材料不存在");
        }
        materials.setStatus(ConstantsForDomain.MATERIALS_STATUS_DELETE);
        materialsMapper.updateByPrimaryKey(materials);

        log.info("删除原材料：{}", JSONObject.toJSONString(materials));
    }

    public Page<MaterialsPageVo> getMaterials(Long id, String name, String specifications, String unit,Integer countMin, Integer countMax, Integer type, PageRequest pageRequest) {
        Long count = materialsMapper.findCount(id, name, specifications, unit, countMin, countMax, type);
        List<Materials> page = new ArrayList<>();
        if (count > 0) {
            page = materialsMapper.findPage(id, name, specifications, unit, countMin, countMax, type, pageRequest);

        }
        return new Page<>(pageRequest, MaterialsPageVo.of(page), count);
    }
}
