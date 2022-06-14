package com.springboot;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;


import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import com.springboot.config.EnhanceFreemarkerTemplateEngine;
import com.springboot.entity.po.BasePo;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;


/**
 * @author xiaomai
 * @date 2022/6/9
 */
public class Generator {

    /**
     * 自定义模板
     */
    @Test
    public void testGenerator() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig());
        generator.template(templateConfig());
        generator.packageInfo(packageConfig());
        generator.global(globalConfig());
        generator.injection(injectionConfig());
        generator.execute(new EnhanceFreemarkerTemplateEngine());
    }


    /**
     * 执行初始化数据库脚本
     */
    @BeforeAll
    public static void before() throws SQLException {
        Connection conn = DATA_SOURCE_CONFIG.getConn();
        InputStream inputStream = Generator.class.getResourceAsStream("/sql/sys_user.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }


    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/xiaomai?characterEncoding=UTF-8&useUnicode=true&useSSL=false&serverTimezone=Asia/Shanghai","root","123456")
            .build();


    /**
     * 策略配置
     */
    private StrategyConfig strategyConfig() {
        // 设置需要生成的表名
        return new StrategyConfig.Builder()
//                .addInclude("sys_user")
                .addExclude("")

                // entity
                .entityBuilder()
                .superClass(BasePo.class)
                .enableLombok()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleted")
                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                .addTableFills(new Column("created_time", FieldFill.INSERT))
                .addTableFills(new Property("updatedTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.ASSIGN_ID)

                // controller
                .controllerBuilder()
                .enableRestStyle()

                // mapper
                .mapperBuilder()
                .enableMapperAnnotation()
                .formatMapperFileName("%sMapper")

                .build();
    }


    /**
     * 全局配置
     */
    private GlobalConfig globalConfig() {
        return new GlobalConfig.Builder()
                .fileOverride()
                .disableOpenDir()
//                .outputDir(System.getProperty("user.dir")+"\\src\\main\\java")
                .outputDir("D:\\Java Project\\shop\\system\\src\\main\\java")
                .author("xiaomai")
                .enableSwagger()
                .dateType(DateType.ONLY_DATE)
                .commentDate("yyyy/MM/dd")
                .build();
    }


    /**
     * 包配置
     */
    private PackageConfig packageConfig() {
        return new PackageConfig.Builder()
                .parent("com.springboot")
                .moduleName("sys")
                .entity("entity.po")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("dao")
                .xml("mapper.xml")
                .controller("rest")
                .other("other")
                .build();
    }


    /**
     * 模板配置
     */
    private TemplateConfig templateConfig() {
        return new TemplateConfig.Builder()
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .mapperXml(null)
                .controller("/templates/controller.java")
                .build();
    }


    /**
     * 注入配置
     */
    private InjectionConfig injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        HashMap<String, String> map = new HashMap<>(8);
        map.put("Form.java", "/templates/entityForm.ftl");
        map.put("QueryForm.java", "/templates/entityQueryForm.ftl");
        map.put("QueryParam.java", "/templates/entityQueryParam.ftl");
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        })
                .customFile(map)
                .build();

    }


}
