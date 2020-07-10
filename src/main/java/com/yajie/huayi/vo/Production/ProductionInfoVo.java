package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Component;
import com.yajie.huayi.vo.Project.MaterialsRecordDetailsVo;
import com.yajie.huayi.vo.Project.MoldDetailsVo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 12:52
 */
@Data
@Builder
public class ProductionInfoVo {
    private ComponentDetailsVo componentDetailsVo;
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
     * 历史进度明细
     */
    private List<ComponentProgressRecordVo> componentProgressRecordVos;
    /**
     * 质检明细
     */
    private List<ComponentInspectionRecordVo> componentInspectionRecordVos;
    public static ProductionInfoVo of(ComponentDetailsVo componentDetailsVo, List<MaterialsRecordDetailsVo> steels,
                                      List<MaterialsRecordDetailsVo> parts, List<MoldDetailsVo> moulds,
                                      List<ComponentProgressRecordVo> componentProgressRecordVos, List<ComponentInspectionRecordVo> componentInspectionRecordVos){
        return ProductionInfoVo.builder()
                .componentDetailsVo(componentDetailsVo)
                .steels(steels)
                .parts(parts)
                .moulds(moulds)
                .componentProgressRecordVos(componentProgressRecordVos)
                .componentInspectionRecordVos(componentInspectionRecordVos)
                .build();
    }
}
