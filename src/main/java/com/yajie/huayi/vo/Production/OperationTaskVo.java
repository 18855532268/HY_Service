package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.other.TodayTaskEntity;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/10 14:04
 */
@Data
@Builder
public class OperationTaskVo {
    private Long id;
//    private Integer operationTotal;
//    private Integer operationComplete;
//    private Integer uncomplete;
    private String componentNum;
    private String componentType;
    private String projectShortName;
    private String projectName;
    private String taskDate;
    private Integer operationStatus;
    private String operationDate;
    private String operationName;
    private String telephone;
    // 质检人
    private String inspectionName;
    private Integer inspectionStatus;

    public static OperationTaskVo of(TodayTaskEntity todayTaskEntity){
        return OperationTaskVo.builder()
                .id(todayTaskEntity.getId())
//                .operationTotal(todayTaskEntity.getTotal())
//                .operationComplete(todayTaskEntity.getComplete())
//                .uncomplete()
                .componentNum(todayTaskEntity.getComponentNum())
                .componentType(todayTaskEntity.getComponentType())
                .projectShortName(todayTaskEntity.getProjectShortName())
                .projectName(todayTaskEntity.getProjectName())
                .taskDate(todayTaskEntity.getTaskDate())
                .operationStatus(todayTaskEntity.getOperationStatus())
                .operationDate(todayTaskEntity.getOperationDate())
                .operationName(todayTaskEntity.getOperationName())
                .telephone(todayTaskEntity.getTelephone())
                .build();
    }
    public static List<OperationTaskVo> of(List<TodayTaskEntity> todayTaskEntities){
        List<OperationTaskVo> vos = new ArrayList<>();
        if (todayTaskEntities != null){
            for (TodayTaskEntity todayTaskEntity : todayTaskEntities){
                vos.add(OperationTaskVo.of(todayTaskEntity));
            }
        }
        return vos;
    }
}
