package com.yajie.huayi.vo.Project;

import com.yajie.huayi.domain.Mold;
import com.yajie.huayi.domain.MoldRecord;
import com.yajie.huayi.util.CommonUtil;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 17:02
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class MoldDetailsVo {
    /**
     * 模具id
     */
    private Mold mold;

    /**
     * 备注
     */
    private String remark;

    private String createAt;

    private String updateAt;
    public static MoldDetailsVo of(Mold mold, MoldRecord moldRecord){
        return MoldDetailsVo.builder()
                .mold(mold)
                .remark(moldRecord.getRemark())
                .createAt(CommonUtil.dateToStr(moldRecord.getCreateAt()))
                .updateAt(CommonUtil.dateToStr(moldRecord.getUpdateAt()))
                .build();
    }
}
