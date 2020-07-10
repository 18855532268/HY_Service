package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.ComponentProgressRecord;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 13:04
 */
@Data
@Builder
public class ComponentProgressRecordVo {
    /**
     * 进度内容
     */
    private String progressDetails;
    /**
     * 排期
     */
    private String rowsAt;
    /**
     * 状态1为未开始 2为已完成
     */
    private Integer status;
    /**
     * 操作工id
     */
    private String operator;
    private String remark;
    private String imgUrl;
    /**
     * 实际操作时间
     */
    private String operationAt;
    /**
     * 操作类型
     */
    private Integer type;

    public static ComponentProgressRecordVo of(ComponentProgressRecord componentProgressRecord, User operator){
        return ComponentProgressRecordVo.builder()
                .progressDetails(componentProgressRecord.getProgressDetails())
                .rowsAt(CommonUtil.dateToStr(componentProgressRecord.getRowsAt()))
                .status(componentProgressRecord.getStatus())
                .operator(operator== null ?"":operator.getUsername())
                .remark(componentProgressRecord.getRemark())
                .imgUrl(componentProgressRecord.getImgUrl())
                .operationAt(componentProgressRecord.getOperationAt() == null? "":CommonUtil.dateToStr(componentProgressRecord.getOperationAt()))
                .type(componentProgressRecord.getType())
                .build();
    }
}
