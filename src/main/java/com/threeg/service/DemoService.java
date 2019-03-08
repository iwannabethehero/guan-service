package com.threeg.service;

import com.threeg.flow.Flow;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoService implements IService{
    @Override
    public void handleException(Exception e) {
        //懒得写异常类了
        throw new RuntimeException("500异常");
    }

    @Override
    public Map<String, Object> createContext() {
        HashMap<String, Object> context = new HashMap<>();
        context.put("flowMapping",Flow.DEMO_FLOW);
        return context;
    }

    /**
     * 之后在Step中取参并使用就 context.get("param")
     * @param body 完整外部请求
     * @return 将请求处理
     */
    @Override
    public Object handleParam(String body) {
        return body;
    }
}
