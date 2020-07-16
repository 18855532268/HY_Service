package com.yajie.huayi.vo.Production;

import com.yajie.huayi.util.Page;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/15 17:25
 */
@Data
@Builder
public class OperationTaskInfoVo {
    private Long operationTotal;
    private Long operationComplete;
    private Long uncomplete;
    private Page<OperationTaskVo> todayTaskVos;

    public static OperationTaskInfoVo of(Long operationTotal, Long operationComplete, Page<OperationTaskVo> todayTaskVos){
        return OperationTaskInfoVo.builder()
                .operationTotal(operationTotal)
                .operationComplete(operationComplete)
                .uncomplete(operationTotal - operationComplete)
                .todayTaskVos(todayTaskVos)
                .build();
    }
}
