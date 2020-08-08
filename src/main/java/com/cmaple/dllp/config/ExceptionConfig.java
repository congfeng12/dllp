package com.cmaple.dllp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：全局异常处理 - ExceptionConfig
 * 功能描述： 用于返回固定格式的全局异常信息，取代原有的异常返回信息
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：NULL
 * 创建人：cmaple
 * 创建日期：2020-08-02
 */
@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> globaException(Exception exception) {
        //返回异常信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("RTCODE", "error");
        map.put("RTMSG", "请求异常，详情请查看 RTDATA ！");
        map.put("RTDATA", exception.getMessage());
        return map;
    }
}
