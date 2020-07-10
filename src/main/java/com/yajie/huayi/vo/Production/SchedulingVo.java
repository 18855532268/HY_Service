package com.yajie.huayi.vo.Production;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 11:45
 */
@Data
@Builder
public class SchedulingVo {
    /**
     * 构件id
     */
    private Long[] componentIds;
    /**
     * 扎钢筋日期
     */
    private String steelBarBindingAt;
    /**
     * 钢筋区域
     */
    private String steelArea;
    /**
     * 搭模时间
     */
    private String moldieAt;
    /**
     * 模具
     */
    private Long moldId;
    /**
     * 浇筑日期
     */
    private String pourAt;
    /**
     * 脱模日期
     */
    private String demouldAt;
}
