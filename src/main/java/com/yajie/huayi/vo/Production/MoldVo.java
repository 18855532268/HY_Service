package com.yajie.huayi.vo.Production;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 16:29
 */
@Data
@Builder
public class MoldVo {
    /**
     * 模具id
     */
    private Long moldId;
    /**
     * 备注
     */
    private String remark;
}
