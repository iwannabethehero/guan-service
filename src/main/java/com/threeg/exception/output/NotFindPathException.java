package com.threeg.exception.output;

import com.threeg.constant.StatusCode;
import com.threeg.exception.OutPutBaseException;

/**
 * 404异常类
 */
public class NotFindPathException extends OutPutBaseException {
    /**
     * 通用异常枚举,不可使用,只约束
     */
    public StatusCode status;
    /**
     * 异常详细描述
     */
    public String description;


    public NotFindPathException(){
        setException(StatusCode.ERROR_NOT_FIND_404);
    }

    public NotFindPathException(String msg){
        setException(StatusCode.ERROR_NOT_FIND_404);
        this.msg = msg;
    }

    public NotFindPathException(int code,String description,String msg){
        status = StatusCode.ERROR_NOT_FIND_404;
        this.code = code;
        this.description =description;
        this.msg =msg;
    }

    public NotFindPathException(StatusCode status){
        this.status = status;
        this.code = status.code;
        this.msg = status.message;
        this.description = status.description;
    }

    /**
     * 对外响应格式
     * @param type
     */
    public void setType(int type){
        this.type = type;
    }

    private void setException(StatusCode status){
        this.status = status;
        this.code = status.code;
        this.msg = status.message;
        this.description = status.description;
    }
}
