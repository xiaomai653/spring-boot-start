package com.springboot.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author xiaomai
 * @date: 2022/6/10
 * mybatis-plus自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdBy", () -> "system", String.class);
        this.strictInsertFill(metaObject, "updatedBy", () -> "system", String.class);
        this.strictInsertFill(metaObject, "createdTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);
        this.strictInsertFill(metaObject, "updatedTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedBy", () -> "system", String.class);
        this.strictInsertFill(metaObject, "updatedTime", () -> Date.from(ZonedDateTime.now().toInstant()), Date.class);

    }
}