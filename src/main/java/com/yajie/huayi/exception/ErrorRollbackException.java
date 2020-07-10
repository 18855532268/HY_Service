package com.yajie.huayi.exception;

/**
 * 程序错误信息
 *
 * @author
 */
public class ErrorRollbackException extends RuntimeException {
    public ErrorRollbackException(String message) {
        super(message);
    }
}
