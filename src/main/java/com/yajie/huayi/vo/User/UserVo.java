package com.yajie.huayi.vo.User;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/2 13:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class UserVo {
    private Long createId;
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

    private List<Long> role;

}
