package com.yajie.huayi.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * materials_record
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialsRecord implements Serializable {
    private Long id;

    /**
     * 生产id
     */
    private Long productionId;

    /**
     * 构件id
     */
    private Long componentId;

    private Long materialsId;

    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;

    /**
     * 含钢量
     */
    private String steelContent;

    private Integer type;

    /**
     * 建筑材料状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}