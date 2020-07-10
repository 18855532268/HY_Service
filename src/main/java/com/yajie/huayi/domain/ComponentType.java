package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * component_type
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentType implements Serializable {
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
    private Long createId;

    /**
     * 创建时间
     */
    private Date createAt;

    private static final long serialVersionUID = 1L;
}