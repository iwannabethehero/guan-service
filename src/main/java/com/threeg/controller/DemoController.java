package com.threeg.controller;

import com.threeg.utils.HttpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  hlz
 */
@RestController
public class DemoController {

    private static final String TEST_BLOG_URL = "https://blog.csdn.net/rx3oyuyi/article/details/88059418";
    @RequestMapping("/demo")
    public String testHttpClient() {
        String post = HttpUtils.sendPost(TEST_BLOG_URL);
        System.out.println(post);
        return post;
    }
}
