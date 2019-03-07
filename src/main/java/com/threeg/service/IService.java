package com.threeg.service;

import java.util.Map;

/**
 * 所有service必须实现此方法
 * @author hlz
 */
public interface IService {

    public Map<String, Object> service(String param);

}
