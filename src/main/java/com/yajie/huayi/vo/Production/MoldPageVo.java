package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Mold;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 16:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoldPageVo {
    /**
     * 模具id
     */
    private Long id;

    /**
     * 编号
     */
    private String number;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高
     */
    private Double height;

    /**
     * 状态
     */
    private Integer status;

    public static MoldPageVo of(Mold mold){
        return MoldPageVo.builder()
                .id(mold.getId())
                .number(mold.getNumber())
                .length(mold.getLength())
                .width(mold.getWidth())
                .height(mold.getHeight())
                .status(mold.getStatus())
                .build();
    }
    public static List<MoldPageVo> of(List<Mold> molds){
        List<MoldPageVo> vos = new ArrayList<>();
        if (molds != null){
            for (Mold mold : molds){
                vos.add(MoldPageVo.of(mold));
            }
        }
        return vos;
    }
}
