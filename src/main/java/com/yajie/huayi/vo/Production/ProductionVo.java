package com.yajie.huayi.vo.Production;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * production
 * @author 
 */
@Data
@Builder
public class ProductionVo implements Serializable{
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
    private Integer[] buildingNos;
    /**
     * 层号
     */
    private Integer[] floorNos;
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
     *缺口方量
     */
    private List<GapVo> gapVos;
    /**
     * 实际方量
     */
    private Double actualVolume;
    /**
     *钢筋
     */
    private List<MaterialsRecordVo> steels;
    /**
     * 预埋件
     */
    private List<MaterialsRecordVo> parts;
    /**
     * 模具
     */
    private List<MoldVo> molds;
    /**
     * 经办人id
     */
    private Long handleId;

}