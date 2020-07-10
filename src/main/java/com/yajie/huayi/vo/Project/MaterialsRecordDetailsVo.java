package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.MaterialsRecord;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 11:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class MaterialsRecordDetailsVo {
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

    public static MaterialsRecordDetailsVo of(MaterialsRecord materialsRecord) {
        return MaterialsRecordDetailsVo.builder()
                .name(materialsRecord.getName())
                .specifications(materialsRecord.getSpecifications())
                .count(materialsRecord.getCount())
                .remark(materialsRecord.getRemark())
                .build();
    }
    public static List<MaterialsRecordDetailsVo> of(List<MaterialsRecord> materialsRecords){
        List<MaterialsRecordDetailsVo> vos = new ArrayList<>();
        if (materialsRecords != null){
            for (MaterialsRecord materialsRecord: materialsRecords){
                vos.add(MaterialsRecordDetailsVo.of(materialsRecord));
            }
        }
        return vos;
    }
}
