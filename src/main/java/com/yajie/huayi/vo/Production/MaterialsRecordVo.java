package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Materials;
import com.yajie.huayi.domain.MaterialsRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * materials
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialsRecordVo {
    /**
     * 材料id
     */
    private Long materialsId;
    /**
     * 数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;


}