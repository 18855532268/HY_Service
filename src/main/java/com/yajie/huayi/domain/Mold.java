package com.yajie.huayi.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mold
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mold implements Serializable {
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

    private static final long serialVersionUID = 1L;
}