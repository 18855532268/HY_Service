package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Component;
import com.yajie.huayi.domain.ComponentType;
import com.yajie.huayi.domain.Project;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 12:55
 */
@Data
@Builder
public class ComponentDetailsVo {
    private Long id;
    /**
     * 构件编号
     */
    private String number;
    /**
     * 类型
     */
    private ComponentType type;
    /**
     * 长
     */
    private Double length;
    /**
     * 宽
     */
    private Double width;
    /**
     * 高度
     */
    private Double height;
    /**
     * 方量
     */
    private Double volume;

    /**
     * 实际方量
     */
    private Double actualVolume;
    /**
     * 创建时间
     */
    private String createAt;
    private Integer status;

    public static ComponentDetailsVo of(Component component, ComponentType type){
        return ComponentDetailsVo.builder()
                .id(component.getId())
                .number(component.getNumber())
                .type(type)
                .length(component.getLength())
                .width(component.getWidth())
                .height(component.getHeight())
                .volume(component.getVolume())
                .actualVolume(component.getActualVolume())
                .createAt(CommonUtil.dateToStr(component.getCreateAt()))
                .status(component.getStatus())
                .build();
    }
}
