package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * production
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Production implements Serializable {
    /**
     * 生产单id
     */
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 产品编号
     */
    private String productNum;

    /**
     * 上传图纸
     */
    private String drawingsUrl;

    /**
     * 构件类型id
     */
    private Long componentTypeId;

    /**
     * 楼号
     */
    private String buildingNos;

    /**
     * 楼层
     */
    private String floorNos;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高
     */
    private Double height;

    /**
     * 方量
     */
    private Double volume;

    /**
     * 实际方量
     */
    private Double actualvolume;

    /**
     * 经办人id
     */
    private Long handleId;

    /**
     * 经办人姓名
     */
    private String handleName;

    /**
     * 审核人id
     */
    private Long auditId;

    /**
     * 审核时间
     */
    private Date auditAt;

    /**
     * 生产单状态
     */
    private Integer status;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}