package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * component_progress_record
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentProgressRecord implements Serializable {
    /**
     * 构件历史进度
     */
    private Long id;

    /**
     * 构件id
     */
    private Long componentId;

    /**
     * 进度内容
     */
    private String progressDetails;

    /**
     * 排期
     */
    private Date rowsAt;

    /**
     * 状态1为未开始 2为已完成
     */
    private Integer status;

    /**
     * 操作工id
     */
    private Long operatorId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 实际操作时间
     */
    private Date operationAt;

    /**
     * 操作类型
     */
    private Integer type;

    private static final long serialVersionUID = 1L;
}