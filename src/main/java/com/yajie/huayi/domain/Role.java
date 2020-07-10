package com.yajie.huayi.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * role
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private Long id;

    /**
     * 角色
     */
    private String role;

    private static final long serialVersionUID = 1L;
}