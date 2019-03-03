package com.threeg.controller;

import com.threeg.constant.ServiceEnum;
import com.threeg.constant.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController("/service")
abstract public class ServiceBaseController {
    @RequestMapping(value = "/{path}", method = RequestMethod.POST)
    public String getBlog(@PathVariable("path")String path, @RequestParam("body")String body) {
        if (!checkPath(path)){
            return StatusCode.ERROR_NOT_FIND_404.errorTextMsg();
        }else if (!checkPermission()){
            return "No authority";
        }
        return "";
    }

    private static boolean  checkPath(String path){
        try {
            ServiceEnum.valueOf(path.toUpperCase());
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }


    /**
     * 权限检查
     * @return
     */
    private static boolean checkPermission(){
        return true;
    }

}
