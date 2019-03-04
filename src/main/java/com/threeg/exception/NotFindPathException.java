package com.threeg.exception;

import com.threeg.constant.StatusCode;

public class NotFindPathException extends RuntimeException {
    public StatusCode status;
    public String description;
    public String msg;
    public int code;

    public NotFindPathException(int code,String description,String msg){
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
}
