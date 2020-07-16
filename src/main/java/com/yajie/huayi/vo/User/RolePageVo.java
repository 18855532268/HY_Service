package com.yajie.huayi.vo.User;

import com.yajie.huayi.domain.Role;
import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/14 15:48
 */
@Data
@Builder
public class RolePageVo {
    private Long id;

    /**
     * 角色
     */
    private String role;
    public static RolePageVo of(Role role){
        return RolePageVo.builder()
                .id(role.getId())
                .role(role.getRole())
                .build();
    }
}
