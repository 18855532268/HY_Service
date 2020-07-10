package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project implements Serializable {
    /**
     * 项目id
     */
    private Long id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目地址
     */
    private String address;
    /**
     * 项目简称
     */
    private String shortName;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 对方公司
     */
    private String customerCompany;
    /**
     * 项目联系人
     */
    private String customerName;
    /**
     * 联系人电话
     */
    private String telephone;
    /**
     * 合同签订时间
     */
    private Date contractAt;
    /**
     * 签订人id
     */
    private Long signerId;
    /**
     * 签订人
     */
    private String signerName;
    /**
     * 上传的合同地址
     */
    private String contract;
    /**
     * 经办人id
     */
    private Long handleId;
    /**
     * 经办人
     */
    private String handleName;
    /**
     * 经办时间
     */
    private Date handleAt;
    /**
     * 审核人id
     */
    private Long auditId;
    /**
     * 审核时间
     */
    private Date auditAt;
    /**
     * 编号
     */
    private String number;

    private Date createAt;

    private Date updateAt;

    private Integer status;

    private static final long serialVersionUID = 1L;
}