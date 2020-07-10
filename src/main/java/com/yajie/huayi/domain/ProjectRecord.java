package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project_record
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRecord implements Serializable {
    private Long id;

    private Long projectId;

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
    private String unitPrice;

    /**
     * 总价
     */
    private String totalPrice;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}