package com.yajie.huayi.config;//package com.example.manage.config;
//
//import com.example.manage.vo.ReturnVO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * <p>
// *     登陆失败处理器
// * </p>
// * @Author: yaoby
// * @Date: 2019/3/21
// */
//@Slf4j
//public class LoginFailHandler implements AuthenticationFailureHandler {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//            AuthenticationException exception) throws IOException, ServletException {
////        log.info("前端请求：{}", JSONObject.toJSONString(request));
////        log.info("返回请求：{}",JSONObject.toJSONString(response));
////        log.info("返回：{}",JSONObject.toJSONString(exception));
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(ReturnVO.getFailedInfo("登陆失败区分：" + exception.getMessage())));
//    }
//
//}