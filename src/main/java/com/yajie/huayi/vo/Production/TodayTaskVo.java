package com.yajie.huayi.vo.Production;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/10 14:04
 */
@Data
@Builder
public class TodayTaskVo {
    private Long id;
    private Integer total;
    private Integer complete;
    private Integer uncomplete;
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

}
