package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.VolumeGap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/4 9:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapVo {
    /**
     * 缺口长度
     */
    private Double lengthGap;

    /**
     * 缺口宽度
     */
    private Double widthGap;

    /**
     * 缺口高度
     */
    private Double heightGap;

    public static GapVo of(VolumeGap volumeGap){
        return GapVo.builder()
                .lengthGap(volumeGap.getLengthGap())
                .widthGap(volumeGap.getWidthGap())
                .heightGap(volumeGap.getHeightGap())
                .build();
    }
    public static List<GapVo> of(List<VolumeGap> volumeGaps){
        List<GapVo> vos = new ArrayList<>();
        if (volumeGaps != null){
            for (VolumeGap volumeGap : volumeGaps){
                vos.add(GapVo.of(volumeGap));
            }
        }
        return vos;
    }
}
