package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * component_inspection_record
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentInspectionRecord implements Serializable {
    /**
     * 构件质检记录id
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
     * 操作时间
     */
    private Date operationAt;

    /**
     * 质检情况
     */
    private Integer status;

    /**
     * 质检员id
     */
    private Long inspectorId;

    /**
     * 备注
     */
    private String remark;

    private String imgUrl;

    private static final long serialVersionUID = 1L;
}