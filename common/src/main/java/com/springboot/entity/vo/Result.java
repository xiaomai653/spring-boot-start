package com.springboot.entity.vo;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.exception.SystemErrorType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;



/**
 * @author xiaomai
 * @date 2022/6/9
 * 统一返回结果
 */
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MSG = "处理成功";
    public static final String FAILED_CODE = "-1";
    public static final String FAILED_MSG = "操作失败";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;

    @ApiModelProperty(value = "处理结果描述信息")
    private String msg;

    @ApiModelProperty(value = "请求结果生成时间戳")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant time;

    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = Instant.now();
    }


    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param msg
     * @param data
     */
    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = Instant.now();
    }

    /**
     * @param systemErrorType
     */
    public Result(SystemErrorType systemErrorType) {
        this.code = systemErrorType.getCode();
        this.msg = systemErrorType.getMsg();
        this.time = Instant.now();
    }

    /**
     * @param systemErrorType
     * @param data
     */
    public Result(SystemErrorType systemErrorType, T data) {
        this(systemErrorType);
        this.data = data;
    }



    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MSG, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }


    /**
     * 系统异常类没有返回数据
     *
     * @return Result
     */
    public static Result fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR,FAILED_MSG);
    }


    /**
     * 系统异常类并返回结果数据
     *
     * @param systemErrorType
     * @param data
     * @return Result
     */
    public static Result fail(SystemErrorType systemErrorType, Object data) {
        return new Result<>(systemErrorType, data);
    }


    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Result
     */
    public static Result fail(Object data) {
        return new Result<>(SystemErrorType.SYSTEM_ERROR, data);
    }



    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }


}
