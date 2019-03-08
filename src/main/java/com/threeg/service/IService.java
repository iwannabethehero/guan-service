package com.threeg.service;

import com.threeg.exception.inner.FlowNotFindException;
import com.threeg.exception.output.NonSupportFlowException;
import com.threeg.flow.Flow;
import com.threeg.utils.FlowBuilder;
import com.threeg.utils.FlowHelper;
import com.threeg.utils.FlowUtils;

import java.util.Map;

/**
 * 所有service必须实现此接口
 * @author hlz
 */
public interface IService {

    default public Object service(String param){
        //参数逻辑处理
        Object params = handleParam(param);
        //组建上下文参数
        Map<String, Object> context = createContext();
        context.put("param",params);
        //检查flowMapping是否存在
        Object flowMapping = null;
        if (context.containsKey("flowMapping")){
             flowMapping= context.get("flowMapping");
            if (!(flowMapping instanceof Flow)){
                throw new FlowNotFindException("错误的flowMapping格式");
            }
        }else {
            throw new FlowNotFindException("没有找到对应flowMapping!");
        }
        FlowHelper flowHelper = FlowBuilder.buildFlow(((Flow) flowMapping).flows);
        Object res = null;
        try {
            res = FlowUtils.runFlow(flowHelper,context);
        } catch (Exception e) {
            handleException(e);
        }

        return handleResponse(res);
    }

    public void handleException(Exception e);

    public Map<String, Object> createContext();

    public Object handleParam(String body);

    /**
     * 如果想进一步处理返回值可重写此方法
     * @param res 处理前的返回值
     * @return 处理后的返回值
     */
    default public Object handleResponse(Object res){
        return res;
    }


}
