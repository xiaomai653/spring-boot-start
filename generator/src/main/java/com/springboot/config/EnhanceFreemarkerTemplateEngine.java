package com.springboot.config;

import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Map;
import java.util.Set;


/**
 * @author xiaomai
 * @date: 2022/6/10
 */
public class EnhanceFreemarkerTemplateEngine extends FreemarkerTemplateEngine {
    /**
     * 自定义输出自定义模板文件
     *
     * @param customFile 自定义配置模板文件信息
     * @param tableInfo  表信息
     * @param objectMap  渲染数据
     * @since 3.5.1
     */
    @Override
    protected void outputCustomFile(@NotNull Map<String, String> customFile, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        String entityName = tableInfo.getEntityName();
        String otherPath = this.getPathInfo(OutputFile.entity);
        Set<String> set = customFile.keySet();
        for (String key : set) {
            String fileName = String.format(otherPath + File.separator + entityName + "%s", key);
            if (StringUtils.contains(key,"Form")){
                fileName = String.format(StringUtils.substring(otherPath,0,otherPath.length()-3) + "/form" + File.separator + entityName + "%s", key);
            }
            if (StringUtils.contains(key,"Param")){
                fileName = String.format(StringUtils.substring(otherPath,0,otherPath.length()-3) + "/param" + File.separator + entityName + "%s", key);
            }
            this.outputFile(new File(fileName), objectMap, customFile.get(key));
            
        }
        /*customFile.forEach((key, value) -> {
            String fileName = String.format(otherPath + File.separator + entityName + "%s", key);
            this.outputFile(new File(fileName), objectMap, value);
        });*/
    }

}