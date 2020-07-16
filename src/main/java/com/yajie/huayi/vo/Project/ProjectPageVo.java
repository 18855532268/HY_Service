package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.Project;
import com.yajie.huayi.domain.User;
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
 * @date 2020/7/2 16:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class ProjectPageVo {
    private Long id;
    /**
     * 编号
     */
    private String number;
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
     * 总件数
     */
    private Integer totalCount;
    /**
     * 已生产数量
     */
    private Integer productionCount;
    /**
     * 已发货数量
     */
    private Integer deliver;
    /**
     * 签订人id
     */
    private Long signerId;
    /**
     * 上传的合同地址
     */
    private String contract;
    /**
     * 经办人
     */
    private String handleName;
    private String handleAt;
    /**
     * 版型
     */
    private List<String> model;
    private Integer status;

    private List<ProjectRecordPageVo> projectRecordPageVos;

    public static ProjectPageVo of(Project project,  List<ProjectRecordPageVo> projectRecordPageVos){
        List<String> model = new ArrayList<>();
        for (ProjectRecordPageVo projectRecordPageVo : projectRecordPageVos){
            model.add(projectRecordPageVo.getName());
        }

        return ProjectPageVo.builder()
                .id(project.getId())
                .number(project.getNumber())
                .name(project.getName())
                .shortName(project.getShortName())
                .customerId(project.getCustomerId())
                .address(project.getAddress())
                .customerCompany(project.getCustomerCompany())
                .customerName(project.getCustomerName())
                .telephone(project.getTelephone())
                .contractAt(CommonUtil.dateToStr(project.getContractAt()))
                .signerId(project.getSignerId())
                .contract(project.getContract())
                .handleName(project.getHandleName())
                .handleAt(CommonUtil.dateToStr(project.getHandleAt()))
                .model(model)
                .status(project.getStatus())
                .projectRecordPageVos(projectRecordPageVos)
                .build();
    }
}
