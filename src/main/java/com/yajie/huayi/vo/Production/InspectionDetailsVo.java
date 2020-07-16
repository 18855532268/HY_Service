package com.yajie.huayi.vo.Production;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/14 11:48
 */
@Data
@Builder
public class InspectionDetailsVo {
    private Long Id;

    private String content;

    private Integer status;

    private Long inspectorId;

    private String remark;

    private String imgUrls;

}
