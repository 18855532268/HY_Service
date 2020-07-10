package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * component
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Component implements Serializable {
    private Long id;

    /**
     * 构件编号
     */
    private String number;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 生产单id
     */
    private Long productionId;

    /**
     * 楼号
     */
    private Integer buildingNo;

    /**
     * 层号
     */
    private Integer floorNo;

    /**
     * 类型id
     */
    private Long typeId;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高度
     */
    private Double height;

    /**
     * 方量
     */
    private Double volume;

    /**
     * 实际方量
     */
    private Double actualVolume;

    /**
     * 扎钢筋日期
     */
    private Date steelBarBindingAt;

    /**
     * 钢筋区域
     */
    private String steelArea;

    /**
     * 钢筋质检员
     */
    private Long steelId;

    /**
     * 搭模时间
     */
    private Date moldieAt;

    /**
     * 模型id
     */
    private Long moldId;

    /**
     * 搭模质检
     */
    private Long molderId;

    /**
     * 浇筑日期
     */
    private Date pourAt;

    /**
     * 脱模日期
     */
    private Date demouldAt;

    /**
     * 脱模质检
     */
    private Long demouldId;

    /**
     * 成品质检
     */
    private Long finishedId;

    private Integer status;

    /**
     * 创建时间
     */
    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}