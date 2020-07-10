package com.yajie.huayi.config;//package com.example.manage.config; /**
// * Project Name:auth2
// * File Name:WebSecurityConfig.java
// * Package Name:com.briup.apps.auth2.config
// * Date:2018年9月17日上午10:23:44
// * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
// *
// */
//
//
//import com.example.manage.web.filter.JwtAuthenticationTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
///**
// * ClassName:WebSecurityConfig <br/>
// * Function: security 配置类 <br/>
// * Date: 2018年9月17日 上午10:23:44 <br/>
// *
// * @author wangzh
// * @version
// * @since JDK 1.8
// * @see
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("userDetailServiceImpl")
//    private UserDetailsService userDetailService;
//
//    @Bean
//    public PasswordEncoder getPasswordEncoderBean() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public JwtAuthenticationTokenFilter getauthenticationTokenFilterBean() {
//        return new JwtAuthenticationTokenFilter();
//    }
//
//    @Bean
//    public LoginSuccessHandler getLoginSuccessHandler() {
//        return new LoginSuccessHandler();
//    }
//
//    @Bean
//    public LoginFailHandler getLoginFailHandler() {
//        return new LoginFailHandler();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/")
//                .loginProcessingUrl("/authentication/form")
//                .successHandler(getLoginSuccessHandler())
//                .failureHandler(getLoginFailHandler())
//                .and().cors()
//                .configurationSource(CorsConfigurationSource())
//                .and()// 跨域配置
//                .csrf().disable()
////                .antMatcher("/")//使用jwt，不需要csrf
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //基于token，不需要session
//                .and()
//                .authorizeRequests()
//                // 设置允许访问的资源
//                .antMatchers("/**/**").permitAll()
//                // 设置允许访问的资源
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers(
//                        "/v2/api-docs",
//                        "/swagger-resources",
//                        "/swagger-resources/**",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/swagger-ui.html/**",
//                        "/webjars/**"
//
//                ).permitAll()
//                .anyRequest().authenticated();
//
//        // 禁用缓存
//        http.headers().cacheControl();
//
//        // 添加JWT filter
//        http.addFilterBefore(getauthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//    }
//    private CorsConfigurationSource CorsConfigurationSource() {
//        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
//        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);//允许的请求方法，PSOT、GET等
//        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
//        return source;
//    }
//
//
//}
