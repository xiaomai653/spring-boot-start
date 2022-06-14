package com.springboot.exception;

import lombok.Getter;

/**
 * @author xiaomai
 * @date 2022/6/9
 * 返回错误码
 */
@Getter
public enum SystemErrorType{

    SYSTEM_ERROR("-1", "系统异常");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    SystemErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
