package ${package.Controller};

import com.springboot.entity.form.DeleteForm;
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}Form;
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}QueryForm;
import com.springboot.entity.vo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};

<#if swagger>
import io.swagger.annotations.*;
</#if>
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
<#if swagger>
    <#if table.comment?ends_with("表")>
@Api(value = "${table.comment?substring(0,table.comment?length-1)}管理", tags = "${table.comment?substring(0,table.comment?length-1)}管理")
    <#else >
@Api(value = "${table.comment}管理",tags = "${table.comment}管理")
    </#if>
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>


    @Autowired
    private ${table.serviceName?cap_first} ${entity?uncap_first}Service;

    @PostMapping("/add")
    <#if swagger>
        <#if table.comment?ends_with("表")>
    @ApiOperation("新增${table.comment?substring(0,table.comment?length-1)}")
        <#else >
    @ApiOperation("新增${table.comment}")
        </#if>
    </#if>
    public Result add(@RequestBody ${entity}Form ${entity?uncap_first}Form){
        return ${entity?uncap_first}Service.add(${entity?uncap_first}Form);
    }

    @DeleteMapping("/delete")
    <#if swagger>
        <#if table.comment?ends_with("表")>
    @ApiOperation("删除${table.comment?substring(0,table.comment?length-1)}")
        <#else >
    @ApiOperation("删除${table.comment}")
        </#if>
    </#if>
    public Result delete(@RequestBody DeleteForm deleteForm){
        return ${entity?uncap_first}Service.delete(deleteForm);
    }

    @PutMapping("/modify")
    <#if swagger>
        <#if table.comment?ends_with("表")>
    @ApiOperation("修改${table.comment?substring(0,table.comment?length-1)}")
        <#else >
    @ApiOperation("修改${table.comment}")
        </#if>
    </#if>
    public Result modify(@RequestBody ${entity}Form ${entity?uncap_first}Form){
        return ${entity?uncap_first}Service.modify(${entity?uncap_first}Form);
    }

    @GetMapping("/get")
    <#if swagger>
        <#if table.comment?ends_with("表")>
    @ApiOperation("${table.comment?substring(0,table.comment?length-1)}详情")
        <#else >
    @ApiOperation("${table.comment}详情")
        </#if>
    </#if>
    public Result get(@RequestParam String id){
        return ${entity?uncap_first}Service.get(id);
    }

    @PostMapping("/page")
    <#if swagger>
       <#if table.comment?ends_with("表")>
    @ApiOperation("${table.comment?substring(0,table.comment?length-1)}分页")
       <#else >
    @ApiOperation("${table.comment}分页")
       </#if>
    </#if>
    public Result pageList(@RequestBody ${entity}QueryForm ${entity?uncap_first}QueryForm){
        return ${entity?uncap_first}Service.pageList(${entity?uncap_first}QueryForm);
    }

    @PostMapping("/list")
    <#if swagger>
        <#if table.comment?ends_with("表")>
    @ApiOperation("${table.comment?substring(0,table.comment?length-1)}列表")
        <#else >
    @ApiOperation("${table.comment}列表")
        </#if>
    </#if>
    public Result getList(@RequestBody ${entity}QueryForm ${entity?uncap_first}QueryForm){
        return ${entity?uncap_first}Service.getList(${entity?uncap_first}QueryForm);
    }


}
</#if>
