package com.threeg.service;

import com.threeg.utils.SpringContextUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 此类为服务分发处理器
 * 应根据path找到对应的service
 * 并对service返回的结果进行差异化屏蔽
 * 暂时预定以Map<String,Object> 格式返回
 *
 * @author hlz
 */
@Service
public class ServiceChannelRunner {
    private final static String SERVICE_STUFF = "Service";

    public Map<String, Object> run(String path, String body) {
        char[] newPath = path.toCharArray();
        newPath[0] -= 32;
        path = String.valueOf(newPath) + SERVICE_STUFF;
        IService service = (IService) SpringContextUtils.getBean(path);
        Map<String, Object> response = service.service(body);
        postService(response);
        return response;

    }

    private static void postService(Map<String, Object> map) {

    }
}
