package com.yajie.huayi.service;

import com.yajie.huayi.constant.ConstantsForDomain;
import com.yajie.huayi.domain.ComponentInspectionRecord;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.exception.ErrorRollbackException;
import com.yajie.huayi.mapper.ComponentInspectionRecordMapper;
import com.yajie.huayi.mapper.UserMapper;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Production.InspectionDetailsVo;
import com.yajie.huayi.vo.Production.InspectionTaskInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/14 11:57
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class InspectionService {

    @Autowired
    private ComponentInspectionRecordMapper componentInspectionRecordMapper;
    @Autowired
    private UserMapper userMapper;

    public void addInspection(InspectionDetailsVo inspectionDetailsVo){
        ComponentInspectionRecord componentInspectionRecord = componentInspectionRecordMapper.selectByPrimaryKey(inspectionDetailsVo.getId());
        if (componentInspectionRecord == null){
            throw new ErrorRollbackException("该构件可能还未完成上一步操作");
        }
        User inspector = userMapper.selectByPrimaryKey(inspectionDetailsVo.getInspectorId());
        if (inspector == null){
            throw new ErrorRollbackException("该质检人员不存在");
        }
        if (!Arrays.asList(ConstantsForDomain.COMPONENT_INSPECTION_STATUS).contains(inspectionDetailsVo.getStatus())){
            throw new ErrorRollbackException("请输入正确的状态");
        }
        componentInspectionRecord.setProgressDetails(inspectionDetailsVo.getContent());
        componentInspectionRecord.setInspectionAt(new Date());
        componentInspectionRecord.setStatus(inspectionDetailsVo.getStatus());
        componentInspectionRecord.setInspectorId(inspectionDetailsVo.getInspectorId());
        componentInspectionRecord.setRemark(inspectionDetailsVo.getRemark());
        componentInspectionRecord.setImgUrl(inspectionDetailsVo.getImgUrls());
        componentInspectionRecordMapper.updateByPrimaryKey(componentInspectionRecord);
    }

    public InspectionTaskInfoVo getInspections(Long id, Long componentId, Integer status, Long inspectorId, String remark, Integer type, PageRequest pageRequest) {
        Long count = componentInspectionRecordMapper.findCount(id, componentId, status, inspectorId, remark, type);
        return null;
    }
}
