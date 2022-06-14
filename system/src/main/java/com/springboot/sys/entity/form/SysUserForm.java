package com.springboot.sys.entity.form;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.springboot.entity.form.BaseForm;
import com.springboot.sys.entity.po.SysUser;
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
@ApiModel(value = "SysUser表单", description = "用户表表单")
public class SysUserForm extends BaseForm<SysUser>{

    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("昵称")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private Integer status;

}
