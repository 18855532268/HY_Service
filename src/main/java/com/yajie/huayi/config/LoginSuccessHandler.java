package com.yajie.huayi.config;//package com.example.manage.config;
//
//import com.example.manage.util.JwtTokenUtils;
//import com.example.manage.vo.ReturnVO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <p>
// *     登陆失败处理器
// * </p>
// * @Author: wangzh
// * @Date: 2019/3/21
// */
//@Slf4j
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    @Qualifier("userDetailServiceImpl")
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//
//        response.setContentType("application/json;charset=UTF-8");
//        try {
//            User details = (User) userDetailsService.loadUserByUsername(authentication.getName());
//
//            String token = JwtTokenUtils.TOKEN_PREFIX  + JwtTokenUtils.createToken(details, false);
//            Map<String, String> map = new HashMap<>();
//            map.put("Token", token);
//            // 重定向
//            response.setHeader(JwtTokenUtils.TOKEN_HEADER, token);
//            response.getWriter().write(objectMapper.writeValueAsString(ReturnVO.getSuccess(map)));
//        } catch (Exception e) {
//            response.getWriter().write(objectMapper.writeValueAsString(ReturnVO.getFailedInfo("创建token失败，请与管理员联系")));
//        }
//
//    }
//
//}
