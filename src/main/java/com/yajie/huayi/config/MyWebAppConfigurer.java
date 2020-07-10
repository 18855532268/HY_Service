package com.yajie.huayi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {



    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册JsonRequest的参数分解器
        argumentResolvers.add(new RequestJsonHandlerMethodArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/login/**",
                "/upload/audio",
                "/upload/video",
                "/upload/test/**",
                "/remote/**",
                "/error/**"
        };
        Collections.addAll(list, urls);
        return list;
    }
}