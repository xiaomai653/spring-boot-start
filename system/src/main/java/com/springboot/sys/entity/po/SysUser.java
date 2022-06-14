package com.springboot.sys.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.springboot.entity.po.BasePo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
@Data
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "用户表")
public class SysUser extends BasePo {


    @ApiModelProperty("昵称")
    private String username ;


    @ApiModelProperty("密码")
    private String password ;


    @ApiModelProperty("乐观锁")
    @Version
    @JsonIgnore
    private Integer version = 0;


    @ApiModelProperty("逻辑删除")
    @TableLogic
    @JsonIgnore
    private Integer deleted = 0;


    @ApiModelProperty("状态")
    private Integer status ;


}
