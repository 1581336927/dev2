package com.hcy.advice;

import com.hcy.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ResponseBody
    @ExceptionHandler(value = DuplicateKeyException.class)
    public ResultVo exception(DuplicateKeyException e){

        return new ResultVo(4500,"名字重复,换个名字",false,e.getMessage());
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResultVo missingHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new ResultVo(4610, "请求方式有误，麻烦自己查看文档，谢谢！", false, e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVo missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResultVo(4600, "缺少了重要的请求参数，请重新检查后再次发送", false, e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResultVo runtimeException(RuntimeException e) {
        return new ResultVo(5000, "系统操作异常，请稍后重试或者联系管理员", false, e.getMessage());
    }
}
