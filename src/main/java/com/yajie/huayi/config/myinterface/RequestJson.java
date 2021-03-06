package com.yajie.huayi.config.myinterface;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJson {
    /**
     * 值
     */
    String value() default "";

    /**
     * 是否必须
     */
    boolean require() default true;
}