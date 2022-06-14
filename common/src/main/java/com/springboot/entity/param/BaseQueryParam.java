package com.springboot.entity.param;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.springboot.entity.po.BasePo;
import lombok.Data;

import java.util.Date;

/**
 * @author xiaomai
 * @date: 2022/6/9
 */
@Data
public class BaseQueryParam<T extends BasePo> {
    private Date createdTimeStart;
    private Date createdTimeEnd;

    public QueryWrapper<T> build() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != this.createdTimeStart, "created_time", this.createdTimeStart)
                .le(null != this.createdTimeEnd, "updated_time", this.createdTimeEnd);
        return queryWrapper;
    }
}
