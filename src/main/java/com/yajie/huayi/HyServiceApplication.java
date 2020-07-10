package com.yajie.huayi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yajie.huayi.mapper")
public class HyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyServiceApplication.class, args);
    }

}
