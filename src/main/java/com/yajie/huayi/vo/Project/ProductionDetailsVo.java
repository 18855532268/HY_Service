package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.Production;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.vo.Production.GapVo;
import com.yajie.huayi.vo.Production.MoldPageVo;
import com.yajie.huayi.vo.Production.MoldVo;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 11:17
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProductionDetailsVo {
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
     * 楼号
     */
    private String buildingNos;
    /**
     * 层号
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
    private List<MaterialsRecordDetailsVo> steels;
    /**
     * 预埋件
     */
    private List<MaterialsRecordDetailsVo> parts;
    /**
     * 模具
     */
    private List<MoldDetailsVo> moulds;
    /**
     * 经办人
     */
    private User handler;

    public static ProductionDetailsVo of(Production production,
                                         List<GapVo> gapVos,
                                         List<MaterialsRecordDetailsVo> steels,
                                         List<MaterialsRecordDetailsVo> parts,
                                         List<MoldDetailsVo> moulds,
                                         User handler){
        return ProductionDetailsVo.builder()
                .projectId(production.getProjectId())
                .productNum(production.getProductNum())
                .drawingsUrl(production.getDrawingsUrl())
                .buildingNos(production.getBuildingNos())
                .floorNos(production.getFloorNos())
                .length(production.getLength())
                .width(production.getWidth())
                .height(production.getHeight())
                .gapVos(gapVos)
                .actualVolume(production.getActualvolume())
                .steels(steels)
                .parts(parts)
                .moulds(moulds)
                .handler(handler)
                .build();
    }
}
