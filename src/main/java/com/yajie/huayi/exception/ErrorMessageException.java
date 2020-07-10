package com.yajie.huayi.exception;

/**
 * 程序错误信息
 *
 * @author
 */
public class ErrorMessageException extends RuntimeException {
    public ErrorMessageException(String message) {
        super(message);
    }
}
