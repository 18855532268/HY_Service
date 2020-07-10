package com.yajie.huayi.constant;

/**
 * 返回内容的成功与否
 * 没添加一个FailedCode，如果返回结果用到了ReturnCodeVO，则需要在ReturnCodeVO.getFailed方法中增加对应处理
 *
 * @author yaoby
 */
public class ReturnConstant {
    public final static int SUCCESS_CODE = 0;
    public final static String SUCCESS_MESSAGE = "成功";

    public final static int FAILED_CODE = -1;
    public final static String FAILED_MESSAGE = "失败";


    public final static int FAILED_BY_NOT_LOGIN_CODE = -999;
    public final static String FAILED_BY_NOT_LOGIN_MESSAGE = "未登录";
}
