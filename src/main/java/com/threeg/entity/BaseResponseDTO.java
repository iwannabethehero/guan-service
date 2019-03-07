package com.threeg.entity;

import java.util.Map;

public class BaseResponseDTO {
    private String code = "200";
    private String msg = "调用成功";
    private Map<String,Object> result;

    public BaseResponseDTO(){}

    public BaseResponseDTO(Map<String,Object> res){
        this.result = res;
    }
}
