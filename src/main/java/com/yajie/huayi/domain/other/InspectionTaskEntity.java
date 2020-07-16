package com.yajie.huayi.domain.other;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/16 11:23
 */
@Builder
@Data
public class InspectionTaskEntity {
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
}
