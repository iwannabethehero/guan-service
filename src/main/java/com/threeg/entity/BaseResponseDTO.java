package com.threeg.entity;

import java.util.Map;

public class BaseResponseDTO {
    private String code = "200";
    private String msg = "调用成功";
    private Object result;

    public BaseResponseDTO(){}

    public BaseResponseDTO(Object res){
        this.result = res;
    }
}
