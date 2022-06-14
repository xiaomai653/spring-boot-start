package com.springboot.sys.dao;

import com.springboot.sys.entity.po.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
