package ${package.Service};

import com.springboot.entity.vo.Result;
import com.springboot.entity.form.DeleteForm;
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}Form;
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}QueryForm;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
        <#if table.comment?ends_with("表")>
     * 新增${table.comment?substring(0,table.comment?length-1)}
        <#else >
     * 新增${table.comment}
        </#if>
     * @param ${entity?uncap_first}Form
     * @return 新增Result
     */
    Result add(${entity}Form ${entity?uncap_first}Form);

    /**
        <#if table.comment?ends_with("表")>
     * 删除${table.comment?substring(0,table.comment?length-1)}
        <#else >
     * 删除${table.comment}
        </#if>
     * @param deleteForm
     * @return 删除Result
     */
    Result delete(DeleteForm deleteForm);

    /**
        <#if table.comment?ends_with("表")>
     * 修改${table.comment?substring(0,table.comment?length-1)}
        <#else >
     * 修改${table.comment}
        </#if>
     * @param ${entity?uncap_first}Form
     * @return 修改Result
     */
    Result modify(${entity}Form ${entity?uncap_first}Form);

    /**
        <#if table.comment?ends_with("表")>
     * ${table.comment?substring(0,table.comment?length-1)}详情
        <#else >
     * ${table.comment}详情
        </#if>
     * @param id
     * @return 详情Result
     */
    Result get(String id);

    /**
        <#if table.comment?ends_with("表")>
     * ${table.comment?substring(0,table.comment?length-1)}分页
        <#else >
     * ${table.comment}分页
        </#if>
     * @param ${entity?uncap_first}QueryForm
     * @return 分页Result
     */
    Result pageList(${entity}QueryForm ${entity?uncap_first}QueryForm);

    /**
        <#if table.comment?ends_with("表")>
     * ${table.comment?substring(0,table.comment?length-1)}列表
        <#else >
     * ${table.comment}列表
        </#if>
     * @param ${entity?uncap_first}QueryForm
     * @return 列表Result
     */
    Result getList(${entity}QueryForm ${entity?uncap_first}QueryForm);

}
</#if>
