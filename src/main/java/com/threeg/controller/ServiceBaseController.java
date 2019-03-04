package com.threeg.controller;

import com.threeg.constant.ServiceEnum;
import com.threeg.constant.StatusCode;
import com.threeg.exception.NotFindPathException;
import org.springframework.web.bind.annotation.*;

/**
 * 此类用来处理请求规范性
 * 权限以及请求过滤
 *
 * @author hlz
 */
@RestController("/service")
public class ServiceBaseController {
    /**
     * 此方法中的try catch 为根异常处理,所有服务器级别错误均应在此层处理
     * 不可以处理业务异常以及其他外部无关异常
     *
     * @param path 路径
     * @param body 参数 json格式
     * @return xml或者json, 根据需求或者解析请求头获取其请求方式
     */
    @RequestMapping(value = "/{path}", method = RequestMethod.POST)
    public String getBlog(@PathVariable("path") String path, @RequestParam("body") String body) {
        try {
            checkPath(path);
            checkPermission();
        } catch (Exception e) {
            e.printStackTrace();
            return handleException(e, 0);
        }

        return "";
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
     *
     * @return
     */
    private static void checkPermission() {

    }

    /**
     * 异常处理
     * 默认非预期错误,返回500状态码及msg
     *
     * @param type 此字段约定 0 - json返回
     *             1 - xml返回
     */
    private static String handleException(Exception ex, int type) {
        return ex.getMessage();
    }
}
