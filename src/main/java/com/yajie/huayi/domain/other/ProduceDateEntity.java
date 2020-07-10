package com.yajie.huayi.domain.other;

import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 17:33
 */
@Data
@Builder
public class ProduceDateEntity {
    private Integer type;
    private String number;
    private String date;
}
