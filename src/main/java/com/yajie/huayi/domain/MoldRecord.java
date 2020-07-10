package com.yajie.huayi.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mold_record
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoldRecord implements Serializable {
    private Long id;

    /**
     * 生产单id
     */
    private Long productionId;

    /**
     * 构件id
     */
    private Long componentId;

    /**
     * 模具id
     */
    private Long moldId;

    /**
     * 备注
     */
    private String remark;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;
}