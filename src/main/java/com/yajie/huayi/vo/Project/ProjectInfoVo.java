package com.yajie.huayi.vo.Project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yajie.huayi.domain.Production;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 10:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectInfoVo {
    private ProjectDetailsVo projectDetailsVo;
    private List<ProductionDetailsVo> productionDetailsVos;

    public static ProjectInfoVo of(ProjectDetailsVo projectDetailsVo, List<ProductionDetailsVo> productionDetailsVos){
        return ProjectInfoVo.builder()
                .projectDetailsVo(projectDetailsVo)
                .productionDetailsVos(productionDetailsVos)
                .build();
    }
}
