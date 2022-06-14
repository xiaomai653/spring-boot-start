package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}Form;
import ${package.Entity?substring(0,package.Entity?length-3)}.form.${entity}QueryForm;
import ${package.Entity?substring(0,package.Entity?length-3)}.param.${entity}QueryParam;
import com.springboot.entity.form.DeleteForm;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.springboot.entity.vo.Result;

import java.util.Arrays;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
@Service
@Slf4j
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public Result add(${entity}Form ${entity?uncap_first}Form) {
        log.info("add ${entity}：{}", ${entity?uncap_first}Form);
        if (this.save(${entity?uncap_first}Form.toPo(${entity}.class))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result delete(DeleteForm deleteForm) {
        log.info("delete ${entity}：{}", deleteForm);
        if (this.removeByIds(Arrays.asList(deleteForm.getIds()))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result modify(${entity}Form ${entity?uncap_first}Form) {
        log.info("modify ${entity}：{}", ${entity?uncap_first}Form);
        if (this.updateById(${entity?uncap_first}Form.toPo(${entity}.class))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result get(String id) {
        log.info("get ${entity}：{}", id);
        return Result.success(this.getById(id));
    }

    @Override
    public Result pageList(${entity}QueryForm ${entity?uncap_first}QueryForm) {
        log.info("getPageList ${entity}：{}", ${entity?uncap_first}QueryForm);
        ${entity?cap_first}QueryParam ${entity?uncap_first}QueryParam =${entity?uncap_first}QueryForm.toParam(${entity?cap_first}QueryParam.class);
        QueryWrapper<${entity}> queryWrapper= ${entity?uncap_first}QueryParam.build();
        return Result.success(this.page(${entity?uncap_first}QueryForm.getPage(), queryWrapper));
    }

    @Override
    public Result getList(${entity}QueryForm ${entity?uncap_first}QueryForm) {
        log.info("getPageList ${entity}：{}", ${entity?uncap_first}QueryForm);
        ${entity?cap_first}QueryParam ${entity?uncap_first}QueryParam =${entity?uncap_first}QueryForm.toParam(${entity?cap_first}QueryParam.class);
        QueryWrapper<${entity}> queryWrapper= ${entity?uncap_first}QueryParam.build();
        return Result.success(this.list(queryWrapper));
    }

}
</#if>
