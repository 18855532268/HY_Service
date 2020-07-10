package com.yajie.huayi.vo.Materials;

import com.yajie.huayi.domain.other.MoldRecordEntity;
import com.yajie.huayi.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/7 12:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoldRecordPageVo {
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
    private String createAt;
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

    public static MoldRecordPageVo of(MoldRecordEntity moldRecordEntity){
        return MoldRecordPageVo.builder()
                .moldNum(moldRecordEntity.getMoldNum())
                .status(moldRecordEntity.getStatus())
                .projectName(moldRecordEntity.getProjectName())
                .componentNum(moldRecordEntity.getComponentNum())
                .buildingNo(moldRecordEntity.getBuildingNo())
                .floorNo(moldRecordEntity.getFloorNo())
                .createAt(CommonUtil.dateToStr(moldRecordEntity.getCreateAt()))
                .length(moldRecordEntity.getLength())
                .width(moldRecordEntity.getWidth())
                .height(moldRecordEntity.getHeight())
                .build();
    }
    public static List<MoldRecordPageVo> of(List<MoldRecordEntity> moldRecordEntities){
        List<MoldRecordPageVo> vos = new ArrayList<>();
        if (moldRecordEntities != null){
            for (MoldRecordEntity moldRecordEntity : moldRecordEntities){
                vos.add(MoldRecordPageVo.of(moldRecordEntity));
            }
        }
        return vos;
    }

}
