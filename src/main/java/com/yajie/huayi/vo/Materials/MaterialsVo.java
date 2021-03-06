package com.yajie.huayi.vo.Materials;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * materials
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialsVo implements Serializable {
    private Long id;

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
    private String model;

    /**
     * 数量
     */
    private Integer count;
    private String unit;


    /**
     * 材料类型
     */
    private Integer type;


    private static final long serialVersionUID = 1L;
}