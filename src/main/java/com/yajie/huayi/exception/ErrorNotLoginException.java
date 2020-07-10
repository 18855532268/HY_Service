package com.yajie.huayi.exception;

/**
 * 程序错误信息
 *
 * @author
 */
public class ErrorNotLoginException extends RuntimeException {
    public ErrorNotLoginException(String message) {
        super(message);
    }
}
