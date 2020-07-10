package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.Project;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 10:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectDetailsVo {
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
    private String contractAt;
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
    private String handleAt;
    /**
     * 审核人id
     */
    private Long auditId;
    /**
     * 审核时间
     */
    private String auditAt;
    /**
     * 编号
     */
    private String number;

    private String createAt;

    private String updateAt;

    private Integer status;

    public static ProjectDetailsVo of(Project project){
        return ProjectDetailsVo.builder()
                .id(project.getId())
                .name(project.getName())
                .address(project.getAddress())
                .shortName(project.getShortName())
                .customerId(project.getCustomerId())
                .customerCompany(project.getCustomerCompany())
                .customerName(project.getCustomerName())
                .telephone(project.getTelephone())
                .contractAt(CommonUtil.dateToStr(project.getContractAt()))
                .signerId(project.getSignerId())
                .signerName(project.getSignerName())
                .contract(project.getContract())
                .handleId(project.getHandleId())
                .handleName(project.getHandleName())
                .handleAt(CommonUtil.dateToStr(project.getHandleAt()))
                .auditId(project.getAuditId())
                .auditAt(project.getAuditAt()== null ? "": CommonUtil.dateToStr(project.getAuditAt()))
                .number(project.getNumber())
                .createAt(CommonUtil.dateToStr(project.getCreateAt()))
                .updateAt(CommonUtil.dateToStr(project.getUpdateAt()))
                .status(project.getStatus())
                .build();
    }
}
