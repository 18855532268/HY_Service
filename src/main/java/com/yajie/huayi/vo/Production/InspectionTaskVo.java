package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.other.InspectionTaskEntity;
import com.yajie.huayi.domain.other.TodayTaskEntity;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/16 11:12
 */
@Builder
@Data
public class InspectionTaskVo {
    private Long id;
    private String componentNum;
    private String componentType;
    private String projectShortName;
    private String projectName;
    private String telephone;
    // 质检人
    private String inspectionDate;
    private String inspectionName;
    private Integer inspectionStatus;
    private String content;
    private String remark;
    private String imgUrls;


    public static InspectionTaskVo of(InspectionTaskEntity taskEntity){
        return InspectionTaskVo.builder()
                .id(taskEntity.getId())
                .componentNum(taskEntity.getComponentNum())
                .componentType(taskEntity.getComponentType())
                .projectShortName(taskEntity.getProjectShortName())
                .projectName(taskEntity.getProjectName())
                .telephone(taskEntity.getTelephone())
                .inspectionDate(taskEntity.getInspectionDate())
                .inspectionName(taskEntity.getInspectionName())
                .inspectionStatus(taskEntity.getInspectionStatus())
                .content(taskEntity.getContent())
                .remark(taskEntity.getRemark())
                .imgUrls(taskEntity.getImgUrls())
                .build();
    }
    public static List<InspectionTaskVo> of(List<InspectionTaskEntity> inspectionTaskEntities){
        List<InspectionTaskVo> vos = new ArrayList<>();
        if (inspectionTaskEntities != null){
            for (InspectionTaskEntity todayTaskEntity : inspectionTaskEntities){
                vos.add(InspectionTaskVo.of(todayTaskEntity));
            }
        }
        return vos;
    }
}
