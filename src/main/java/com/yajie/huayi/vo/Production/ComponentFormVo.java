package com.yajie.huayi.vo.Production;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 17:52
 */
@Data
@Builder
public class ComponentFormVo {
    private Integer type;
    private String number;
}
