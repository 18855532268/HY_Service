package com.yajie.huayi.web.controller.handler;


import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.exception.ErrorNotLoginException;
import com.yajie.huayi.exception.ErrorRollbackException;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class SpringExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ReturnVO exceptionHandler(Exception ex) {
        log.error("抓取错误", ex);
        return ReturnVO.getFailedInfo("系统出错");
    }

    @ExceptionHandler(value = {ErrorMessageException.class})
    public ReturnVO exceptionHandler(ErrorMessageException ex) {
        return ReturnVO.getFailedInfo(ex.getMessage());
    }

    @ExceptionHandler(value = {ErrorRollbackException.class})
    public ReturnVO exceptionHandler(ErrorRollbackException ex) {
        return ReturnVO.getFailedInfo(ex.getMessage());
    }

    @ExceptionHandler(value = {ErrorNotLoginException.class})
    public ReturnVO exceptionHandler(ErrorNotLoginException ex) {
        return ReturnVO.getNotLogin();
    }
}
