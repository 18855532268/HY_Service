package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.ProjectRecord;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/6/29 16:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectRecordPageVo {
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 规格
     */
    private String specificas;

    /**
     * 数量
     */
    private Integer count;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单价
     */
    private float unitPrice;

    private float totalPrice;

    public static ProjectRecordPageVo of(ProjectRecord projectRecord){
        return ProjectRecordPageVo.builder()
                .id(projectRecord.getId())
                .name(projectRecord.getName())
                .specificas(projectRecord.getSpecificas())
                .count(projectRecord.getCount())
                .unit(projectRecord.getUnit())
                .unitPrice(Float.valueOf(projectRecord.getUnitPrice()))
                .totalPrice(Float.valueOf(projectRecord.getTotalPrice()))
                .build();
    }
    public static List<ProjectRecordPageVo> of(List<ProjectRecord> projectRecords){
        List<ProjectRecordPageVo> vos = new ArrayList<>();
        if (projectRecords != null){
            for (ProjectRecord projectRecord : projectRecords){
                vos.add(ProjectRecordPageVo.of(projectRecord));
            }
        }
        return vos;
    }

}
