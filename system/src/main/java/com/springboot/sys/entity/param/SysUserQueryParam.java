package com.springboot.sys.entity.param;

import com.springboot.entity.param.BaseQueryParam;
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
@ApiModel(value = "SysUser查询参数", description = "用户表查询参数")
public class SysUserQueryParam extends BaseQueryParam<SysUser>{

    @ApiModelProperty("昵称")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private Integer status;

}
