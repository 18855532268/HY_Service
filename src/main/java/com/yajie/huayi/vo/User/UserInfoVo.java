package com.yajie.huayi.vo.User;

import com.yajie.huayi.domain.Role;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.domain.UserRole;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/1 17:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class UserInfoVo {
    private Long id;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 用户名
     */
    private String username;
    private String password;
    /**
     * 联系人姓名
     */
    private String name;
    private String telephone;
    private String weChat;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 用户代码
     */
    private String userCode;
    /**
     * 备注
     */
    private String remark;
    private String createAt;
    private String updateAt;
    private List<Long> role;
    private Integer status;

    public static UserInfoVo of(User user, User creater) {
        return UserInfoVo.builder()
                .id(user.getId())
                .creater(creater.getUsername())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .telephone(user.getTelephone())
                .weChat(user.getWeChat())
                .company(user.getCompany())
                .companyAddress(user.getCompanyAddress())
                .userCode(user.getUserCode())
                .remark(user.getRemark())
                .createAt(CommonUtil.dateToStr(user.getCreateAt()))
                .updateAt(CommonUtil.dateToStr(user.getUpdateAt()))
                .status(user.getStatus())
                .build();
    }

    public static UserInfoVo of(User user, List<UserRole> roles) {
        List<Long> role = new ArrayList<>();
        for (UserRole r : roles) {
            role.add(r.getRoleId());
        }
        return UserInfoVo.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .telephone(user.getTelephone())
                .weChat(user.getWeChat())
                .company(user.getCompany())
                .companyAddress(user.getCompanyAddress())
                .userCode(user.getUserCode())
                .remark(user.getRemark())
                .createAt(CommonUtil.dateToStr(user.getCreateAt()))
                .updateAt(CommonUtil.dateToStr(user.getUpdateAt()))
                .role(role)
                .status(user.getStatus())
                .build();
    }

//    public static List<UserInfoVo> of(List<User> users) {
//        List<UserInfoVo> vos = new ArrayList<>();
//        if (users != null) {
//            for (User user : users) {
//                vos.add(UserInfoVo.of(user));
//            }
//        }
//        return vos;
//    }
}
