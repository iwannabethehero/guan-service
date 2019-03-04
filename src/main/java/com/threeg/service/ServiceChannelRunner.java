package com.threeg.service;

import org.springframework.stereotype.Service;

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

}
