package com.yajie.huayi.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user_role
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {
    private Long id;

    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}