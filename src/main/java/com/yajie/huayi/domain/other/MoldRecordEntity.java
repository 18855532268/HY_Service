package com.yajie.huayi.domain.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/8 14:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoldRecordEntity {
    private String moldNum;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 构件名称
     */
    private String componentNum;
    /**
     * 楼号
     */
    private Integer buildingNo;

    /**
     * 层号
     */
    private Integer floorNo;
    /**
     * 创建时间
     */
    private Date createAt;
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
}
