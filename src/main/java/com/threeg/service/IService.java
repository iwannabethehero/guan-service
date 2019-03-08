package com.threeg.service;

import java.util.Map;

/**
 * 所有service必须实现此接口
 * @author hlz
 */
public interface IService {

    default public Map<String, Object> service(String param){
        //参数逻辑处理
        Map<String, Object> params = handleParam(param);
        //组建上下文参数
        Map<String, Object> context = createContext();
        context.put("param",params);

        //检查flowMapping是否存在
        return null;
    }

    public Map<String, Object> createContext();

    public Map<String, Object> handleParam(String body);


}
