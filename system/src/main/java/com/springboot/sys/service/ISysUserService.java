package com.springboot.sys.service;

import com.springboot.entity.vo.Result;
import com.springboot.entity.form.DeleteForm;
import com.springboot.sys.entity.form.SysUserForm;
import com.springboot.sys.entity.form.SysUserQueryForm;
import com.springboot.sys.entity.po.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 新增用户
     * @param sysUserForm
     * @return 新增Result
     */
    Result add(SysUserForm sysUserForm);

    /**
     * 删除用户
     * @param deleteForm
     * @return 删除Result
     */
    Result delete(DeleteForm deleteForm);

    /**
     * 修改用户
     * @param sysUserForm
     * @return 修改Result
     */
    Result modify(SysUserForm sysUserForm);

    /**
     * 用户详情
     * @param id
     * @return 详情Result
     */
    Result get(String id);

    /**
     * 用户分页
     * @param sysUserQueryForm
     * @return 分页Result
     */
    Result pageList(SysUserQueryForm sysUserQueryForm);

    /**
     * 用户列表
     * @param sysUserQueryForm
     * @return 列表Result
     */
    Result getList(SysUserQueryForm sysUserQueryForm);

}
