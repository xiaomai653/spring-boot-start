package com.springboot.sys.entity.form;

import com.springboot.entity.form.BaseQueryForm;
import com.springboot.sys.entity.param.SysUserQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
  * 用户表
  * </p>
 *
 * @author xiaomai
 * @date 2022/06/14
 */
@Data
@ApiModel(value = "SysUser查询表单", description = "用户表查询表单")
public class SysUserQueryForm extends BaseQueryForm<SysUserQueryParam>{

    @ApiModelProperty("昵称")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("查询开始时间")
    private Date createdTimeStart;

    @ApiModelProperty("查询结束时间")
    private Date createdTimeEnd;
}
