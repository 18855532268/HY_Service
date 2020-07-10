package com.yajie.huayi.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yajie.huayi.constant.ReturnConstant;
import lombok.*;


/**
 * 查询接口的通用返回项
 *
 * @author yaoby
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnVO {
    private Integer code;
    private String message;
    private Object data;

    public static ReturnVO getSuccess(Object object) {
        return ReturnVO.builder()
                .code(ReturnConstant.SUCCESS_CODE)
                .message(ReturnConstant.SUCCESS_MESSAGE)
                .data(object)
                .build();
    }

    public static ReturnVO getSuccess() {
        return ReturnVO.builder()
                .code(ReturnConstant.SUCCESS_CODE)
                .message(ReturnConstant.SUCCESS_MESSAGE)
                .build();
    }

    public static ReturnVO getFailedInfo(String errorMessage) {
        return ReturnVO.builder()
                .code(ReturnConstant.FAILED_CODE)
                .message(errorMessage)
                .build();
    }

    public static ReturnVO getNotLogin() {
        return ReturnVO.builder()
                .code(ReturnConstant.FAILED_BY_NOT_LOGIN_CODE)
                .message(ReturnConstant.FAILED_BY_NOT_LOGIN_MESSAGE)
                .build();
    }
}
