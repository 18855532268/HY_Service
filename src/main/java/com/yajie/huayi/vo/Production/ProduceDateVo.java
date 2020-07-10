package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.other.ProduceDateEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 15:55
 */
@Data
@Builder
public class ProduceDateVo {
    private String date;
    private List<ProduceDateEntity> produceDateEntities;

    public static ProduceDateVo of(String date, List<ProduceDateEntity> produceDateEntities){
        return ProduceDateVo.builder()
                .date(date)
                .produceDateEntities(produceDateEntities)
                .build();

    }
}
