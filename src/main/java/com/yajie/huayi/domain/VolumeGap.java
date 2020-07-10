package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * volume_gap
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolumeGap implements Serializable {
    private Long id;

    /**
     * 生产单id
     */
    private Long productionId;

    /**
     * 构件id
     */
    private Long componentId;

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

    /**
     * 缺口方量
     */
    private Double volume;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}