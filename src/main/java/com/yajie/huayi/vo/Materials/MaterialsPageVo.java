package com.yajie.huayi.vo.Materials;

import com.yajie.huayi.domain.Materials;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/7 10:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialsPageVo {
    private Long id;

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

    /**
     * 数量
     */
    private Integer count;

    /**
     * 材料类型
     */
    private Integer type;

    public static MaterialsPageVo of(Materials materials){
       return MaterialsPageVo.builder()
               .id(materials.getId())
               .name(materials.getName())
               .specifications(materials.getSpecifications())
               .steelContent(materials.getSteelContent())
               .count(materials.getCount())
               .type(materials.getType())
               .build();
    }
    public static List<MaterialsPageVo> of(List<Materials> materialsList){
        List<MaterialsPageVo> vos = new ArrayList<>();
        if (materialsList != null){
            for (Materials materials: materialsList){
                vos.add(MaterialsPageVo.of(materials));
            }
        }
        return vos;
    }
}
