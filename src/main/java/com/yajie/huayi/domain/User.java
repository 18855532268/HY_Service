package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long id;

    /**
     * 创建人id
     */
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

    private Date createAt;

    private Date updateAt;

    private Integer status;

    private static final long serialVersionUID = 1L;
}