package com.springboot.sys.service.impl;

import com.springboot.sys.entity.po.SysUser;
import com.springboot.sys.dao.SysUserMapper;
import com.springboot.sys.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.sys.entity.form.SysUserForm;
import com.springboot.sys.entity.form.SysUserQueryForm;
import com.springboot.sys.entity.param.SysUserQueryParam;
import com.springboot.entity.form.DeleteForm;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.springboot.entity.vo.Result;

import java.util.Arrays;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public Result add(SysUserForm sysUserForm) {
        log.info("add SysUser：{}", sysUserForm);
        if (this.save(sysUserForm.toPo(SysUser.class))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result delete(DeleteForm deleteForm) {
        log.info("delete SysUser：{}", deleteForm);
        if (this.removeByIds(Arrays.asList(deleteForm.getIds()))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result modify(SysUserForm sysUserForm) {
        log.info("modify SysUser：{}", sysUserForm);
        if (this.updateById(sysUserForm.toPo(SysUser.class))) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result get(String id) {
        log.info("get SysUser：{}", id);
        return Result.success(this.getById(id));
    }

    @Override
    public Result pageList(SysUserQueryForm sysUserQueryForm) {
        log.info("getPageList SysUser：{}", sysUserQueryForm);
        SysUserQueryParam sysUserQueryParam =sysUserQueryForm.toParam(SysUserQueryParam.class);
        QueryWrapper<SysUser> queryWrapper= sysUserQueryParam.build();
        return Result.success(this.page(sysUserQueryForm.getPage(), queryWrapper));
    }

    @Override
    public Result getList(SysUserQueryForm sysUserQueryForm) {
        log.info("getPageList SysUser：{}", sysUserQueryForm);
        SysUserQueryParam sysUserQueryParam =sysUserQueryForm.toParam(SysUserQueryParam.class);
        QueryWrapper<SysUser> queryWrapper= sysUserQueryParam.build();
        return Result.success(this.list(queryWrapper));
    }

}
