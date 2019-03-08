package com.threeg.entity;

import java.io.Serializable;

public class BaseResponseDTO implements Serializable {

    private static final long serialVersionUID = 362494352363181265L;

    public String code = "200";
    public String msg = "调用成功";
    public Object result;

    public BaseResponseDTO(){}

    public BaseResponseDTO(Object res){
        this.result = res;
    }
}
