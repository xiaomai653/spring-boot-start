package com.springboot.sys.rest;

import com.springboot.entity.form.DeleteForm;
import com.springboot.sys.entity.form.SysUserForm;
import com.springboot.sys.entity.form.SysUserQueryForm;
import com.springboot.entity.vo.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.sys.service.ISysUserService;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {


    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/add")
    @ApiOperation("新增用户")
    public Result add(@RequestBody SysUserForm sysUserForm){
        return sysUserService.add(sysUserForm);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除用户")
    public Result delete(@RequestBody DeleteForm deleteForm){
        return sysUserService.delete(deleteForm);
    }

    @PutMapping("/modify")
    @ApiOperation("修改用户")
    public Result modify(@RequestBody SysUserForm sysUserForm){
        return sysUserService.modify(sysUserForm);
    }

    @GetMapping("/get")
    @ApiOperation("用户详情")
    public Result get(@RequestParam String id){
        return sysUserService.get(id);
    }

    @PostMapping("/page")
    @ApiOperation("用户分页")
    public Result pageList(@RequestBody SysUserQueryForm sysUserQueryForm){
        return sysUserService.pageList(sysUserQueryForm);
    }

    @PostMapping("/list")
    @ApiOperation("用户列表")
    public Result getList(@RequestBody SysUserQueryForm sysUserQueryForm){
        return sysUserService.getList(sysUserQueryForm);
    }


}
