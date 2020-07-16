package com.yajie.huayi.vo.Production;

import com.yajie.huayi.util.Page;
import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/15 17:25
 */
@Data
@Builder
public class InspectionTaskInfoVo {
    private Long inspectionTotal;
    private Long inspectionComplete;
    private Long uncomplete;
    private Page<InspectionTaskVo> todayTaskVos;

    public static InspectionTaskInfoVo of(Long inspectionTotal, Long inspectionComplete, Page<InspectionTaskVo> todayTaskVos){
        return InspectionTaskInfoVo.builder()
                .inspectionTotal(inspectionTotal)
                .inspectionComplete(inspectionComplete)
                .uncomplete(inspectionTotal - inspectionComplete)
                .todayTaskVos(todayTaskVos)
                .build();
    }
}
