package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.ComponentType;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * component_type
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentTypePageVo {
    private Long id;
    /**
     * 构件代码
     */
    private String typeCode;
    /**
     * 构件类型
     */
    private String type;
    /**
     * 创建人id
     */
    private User creater;
    /**
     * 创建时间
     */
    private String createAt;

    public static ComponentTypePageVo of(ComponentType componentType, User creater){
        return ComponentTypePageVo.builder()
                .id(componentType.getId())
                .typeCode(componentType.getTypeCode())
                .type(componentType.getType())
                .creater(creater)
                .createAt(CommonUtil.dateToStr(componentType.getCreateAt()))
                .build();
    }

}