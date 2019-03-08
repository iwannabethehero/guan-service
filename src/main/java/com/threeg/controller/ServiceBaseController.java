package com.threeg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.threeg.constant.ServiceEnum;
import com.threeg.constant.StatusCode;
import com.threeg.entity.BaseResponseDTO;
import com.threeg.exception.output.NotFindPathException;
import com.threeg.exception.OutPutBaseException;
import com.threeg.service.ServiceChannelRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 此类用来处理请求规范性
 * 权限以及请求过滤
 *
 * @author hlz
 */
@RestController("/")
public class ServiceBaseController {

    @Autowired
    ServiceChannelRunner channel;
    /**
     * 此方法中的try catch 为根异常处理,所有服务器级别错误均应在此层处理
     * 不可以处理业务异常以及其他外部无关异常
     *
     * @param path 路径
     * @param body 参数 json格式
     * @return xml或者json, 根据需求或者解析请求头获取其请求方式
     */
    @RequestMapping(value = "service/{path}", method = RequestMethod.GET)
    public String getBlog(@PathVariable("path") String path, @RequestParam("body") String body) {
        try {
            checkPath(path);
            checkPermission();
            checkGeneralParam(body);
            Object res = channel.run(path, body);
            //包装参数
            return packResponse(res);
        } catch (Exception e) {
            int type = e instanceof OutPutBaseException ? ((OutPutBaseException) e).type : 0;
            return handleException(e, type);
        }
    }

    @RequestMapping("/nice")
    public String getDemo(){
        return "6666666666666666666";
    }

    private String packResponse(Object res) {
        BaseResponseDTO resObj = new BaseResponseDTO(res);
        return JSONObject.toJSON(resObj).toString();

    }

    private static void checkPath(String path) {
        try {
            ServiceEnum.valueOf(path.toUpperCase());
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new NotFindPathException(StatusCode.ERROR_NOT_FIND_404);
        }
    }


    /**
     * 权限检查
     */
    private static void checkPermission() {

    }

    /**
     * 通用参数处理
     */
    private static void checkGeneralParam(String body) {

    }

    /**
     * 异常处理
     * 默认非预期错误,返回500状态码及msg
     * 如果是base异常则返回异常内部信息
     *
     * @param type 此字段约定 0 - json返回
     *             1 - xml返回
     */
    private static String handleException(Exception ex, int type) {
        return ex.getMessage();
    }
}
