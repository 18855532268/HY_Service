package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * quality_details
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualityDetails implements Serializable {
    private Long id;

    private Long componentInspectionRecordId;

    private Integer type;

    private String content;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}