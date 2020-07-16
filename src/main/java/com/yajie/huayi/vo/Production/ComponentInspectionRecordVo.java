package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.ComponentInspectionRecord;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 13:10
 */
@Data
@Builder
public class ComponentInspectionRecordVo {
    /**
     * 进度内容
     */
    private String progressDetails;
    /*
     * 操作时间
     */
    private String inspectionAt;
    /**
     * 质检情况
     */
    private Integer status;
    /**
     * 质检员
     */
    private String inspector;
    /**
     * 备注
     */
    private String remark;

    private String imgUrl;

    public static ComponentInspectionRecordVo of(ComponentInspectionRecord componentInspectionRecord, User inspector) {
        return ComponentInspectionRecordVo.builder()
                .progressDetails(componentInspectionRecord.getProgressDetails())
                .inspectionAt(CommonUtil.dateToStr(componentInspectionRecord.getInspectionAt()))
                .status(componentInspectionRecord.getStatus())
                .inspector(inspector.getUsername())
                .remark(componentInspectionRecord.getRemark())
                .imgUrl(componentInspectionRecord.getImgUrl())
                .build();
    }

}
