package com.threeg.exception;

import com.threeg.constant.StatusCode;

/**
 * 对外异常基类
 */
public class OutPutBaseException extends RuntimeException{

    /**
     * 对外请求需要指定statusCode
     */
    public StatusCode status;
    /**
     *  0 - json返回
     *  1 - html返回
     */
    public int type = 0 ;

    /**
     *  errorMsg
     */
    public String msg;

    /**
     *  响应码
     */
    public int code;

    public String getMessage(){
        return msg;
    }
}
