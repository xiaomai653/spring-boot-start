package ${package.Entity?substring(0,package.Entity?length-3)}.form;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.springboot.entity.form.BaseForm;
import ${package.Entity}.${entity};
<#if swagger>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
    <#if chainModel>
import lombok.experimental.Accessors;
    </#if>
</#if>
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
  * ${table.comment!}
  * </p>
 *
 * @author ${author}
 * @date ${date}
 */
<#if entityLombokModel>
@Data
    <#if chainModel>
@Accessors(chain = true)
    </#if>
</#if>
<#if swagger>
@ApiModel(value = "${entity}表单", description = "${table.comment!}表单")
</#if>
public class ${entity}Form extends BaseForm<${entity}>{

    @TableId(type = IdType.${idType})
    @ApiModelProperty("ID")
    private String id;

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if (!field.versionField && !field.logicDeleteField)>
        <#if field.keyFlag>
            <#assign keyPropertyName="${field.propertyName}"/>
        </#if>
        <#if field.comment!?length gt 0>
            <#if swagger>
    @ApiModelProperty("${field.comment}")
            <#else>
        /**
         * ${field.comment}
         */
            </#if>
        </#if>
        <#if field.keyFlag>
        <#-- 主键 -->
            <#if field.keyIdentityFlag>
        @TableId(value = "${field.annotationColumnName}", type = IdType.AUTO)
            <#elseif idType??>
        @TableId(value = "${field.annotationColumnName}", type = IdType.${idType})
            <#elseif field.convert>
        @TableId("${field.annotationColumnName}")
            </#if>
        <#-- 普通字段 -->
        <#elseif field.fill??>
        <#-- -----   存在字段填充设置   ----->
            <#if field.convert>
        @TableField(value = "${field.annotationColumnName}", fill = FieldFill.${field.fill})
            <#else>
        @TableField(fill = FieldFill.${field.fill})
            </#if>
        <#elseif field.convert>
        @TableField("${field.annotationColumnName}")
        </#if>
    private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>
    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

        <#if chainModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if chainModel>
        return this;
        </#if>
    }
    </#list>
</#if>
<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";

    </#list>
</#if>
<#if activeRecord>
    @Override
    public Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }

</#if>
<#if !entityLombokModel>
    @Override
    public String toString() {
        return "${entity}{" +
    <#list table.fields as field>
        <#if field_index==0>
            "${field.propertyName}=" + ${field.propertyName} +
        <#else>
            ", ${field.propertyName}=" + ${field.propertyName} +
        </#if>
    </#list>
        "}";
    }
</#if>
}
