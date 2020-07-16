package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/6/29 16:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectVo {
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
     * 项目编号
     */
    private String number;
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
    private String contractAt;
    /**
     * 签订人id
     */
    private Long signerId;

    /**
     * 上传的合同地址
     */
    private String contract;
    /**
     * 经办人id
     */
    private Long handleId;

    private List<ProjectRecordVo> projectRecordVos;

}
