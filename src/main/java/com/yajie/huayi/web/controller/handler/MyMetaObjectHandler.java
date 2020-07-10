package com.yajie.huayi.web.controller.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * 填充器
 */
@Component
@Log4j2
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("createAt", LocalDateTime.now(), metaObject);
        this.setInsertFieldValByName("updateAt", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 第一个参数和实体字段一致，第二个参数保证和实体字段的类型一致，否则为null
        this.setUpdateFieldValByName("updateAt", LocalDateTime.now(), metaObject);
    }
}
