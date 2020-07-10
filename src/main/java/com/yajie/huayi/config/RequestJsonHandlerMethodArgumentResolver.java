package com.yajie.huayi.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.yajie.huayi.config.myinterface.RequestJson;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 解析RequestJson注解的字段
 */
public class RequestJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String JSON_REQUEST_BODY = "JSON_REQUEST_BODY";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestJson.class);
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String body = getRequestBody(webRequest);
        String name = parameter.getParameterAnnotation(RequestJson.class).value();
        if (StringUtils.isBlank(name)) {
            name = parameter.getParameterName();
        }
        Object o = JSONPath.read(body, "$." + name);
        if (o == null) {
            return o;
        }
        Class c = parameter.getParameterType();
        if (Long.class.isAssignableFrom(c)) {
            o = Long.parseLong(o.toString());
        }
        if (Integer.class.isAssignableFrom(c)) {
            o = Integer.parseInt(o.toString());
        } else if (Double.class.isAssignableFrom(c)) {
            o = Double.parseDouble(o.toString());
        } else if (String.class.isAssignableFrom(c)) {
            if (!(o instanceof String)) {
                o = JSON.toJSONString(o);
            }
        } else if (List.class.isAssignableFrom(c)) {
            Type type = parameter.getGenericParameterType();
            o = JSON.parseObject(o.toString(), type);
        }
        return o;
    }

    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) servletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getInputStream());
                servletRequest.setAttribute(JSON_REQUEST_BODY, jsonBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonBody;

    }
}