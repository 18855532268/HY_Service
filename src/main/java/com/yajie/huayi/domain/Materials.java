package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * materials
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Materials implements Serializable {
    private Long id;

    /**
     * 编号
     */
    private String number;

    /**
     * 材料名称
     */
    private String name;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 含钢量
     */
    private String steelContent;

    /**
     * 型号
     */
    private String model;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 单位
     */
    private String unit;

    /**
     * 材料类型
     */
    private Integer type;

    private Date createAt;

    private Date updateAt;

    private Integer status;

    private static final long serialVersionUID = 1L;
}