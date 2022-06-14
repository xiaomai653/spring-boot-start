package com.springboot.exception;

import com.springboot.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaomai
 * @date 2022/6/10
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截所有Exception类的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result Exception(Exception e) {
        log.error("exception: {}", e.getCause().getMessage());
        return Result.fail(e.getCause().getMessage());
    }


    /**
     * 拦截RuntimeException类的异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result RuntimeException(RuntimeException e){
        log.error("runtime exception: {}", e.getCause().getMessage());
        return Result.fail(e.getCause().getMessage());
    }

    /**
     * 拦截DuplicateKeyException类的异常
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public Result DuplicateKeyException(DuplicateKeyException e){
        log.error("duplicate key exception: {}", e.getCause().getMessage());
        return Result.fail(e.getCause().getMessage());
    }


    /**
     * 定义@Valid注解全局异常处理机制
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result validationBodyException(BindException e){
        log.error("validation body exception: {}", e.getMessage());
        //打印校验住的所有的错误信息
        StringBuilder sb = new StringBuilder("参数错误：[");
        List<ObjectError> list = e.getAllErrors();
        for (ObjectError item : list) {
            sb.append(item.getDefaultMessage()).append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        String msg  =  sb.toString();
        return Result.fail(msg);
    }

}
