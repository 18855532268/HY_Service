package com.yajie.huayi.vo.Project;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/6/29 16:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectRecordVo {
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String specificas;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价
     */
    private Long unitPrice;

}
