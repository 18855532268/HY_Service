package com.yajie.huayi.domain.other;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/10 18:02
 */
@Data
@Builder
public class TodayTaskEntity {
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

}
