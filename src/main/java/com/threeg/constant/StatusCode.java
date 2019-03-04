package com.threeg.constant;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回状态码
 * 对外
 * @author hlz
 */
public enum StatusCode {

    /**
     * 404请求
     */
    ERROR_NOT_FIND_404(404, "对不起！您访问的页面不存在", "对不起，您请求的页面不存在、或已被删除、或暂时不可用");

    public int code;

    public String description;

    public String message;

    StatusCode(int code, String description, String message) {
        this.description = description;
        this.message = message;
        this.code = code;
    }


    /**
     * 错误图片需要分类整理
     * @return
     */
    public String errorPage() {
        String htmlPage =
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head>\n" +
                        "<meta charset=\"UTF-8\" http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                        "<title>"+this.code+"-"+this.description+"</title>\n" +
                        "<style type=\"text/css\">\n" +
                        ".head404{ width:580px; height:234px; margin:50px auto 0 auto; background:url(https://www.daixiaorui.com/Public/images/head404.png) no-repeat; }\n" +
                        ".txtbg404{ width:499px; height:169px; margin:10px auto 0 auto; background:url(https://www.daixiaorui.com/Public/images/txtbg404.png) no-repeat;}\n" +
                        ".txtbg404 .txtbox{ width:390px; position:relative; top:30px; left:60px;color:#eee; font-size:13px;}\n" +
                        ".txtbg404 .txtbox p {margin:5px 0; line-height:18px;}\n" +
                        ".txtbg404 .txtbox .paddingbox { padding-top:15px;}\n" +
                        ".txtbg404 .txtbox p a { color:#eee; text-decoration:none;}\n" +
                        ".txtbg404 .txtbox p a:hover { color:#FC9D1D; text-decoration:underline;}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body bgcolor=\"#494949\">\n" +
                        "   \t<div class=\"head404\"></div>\n" +
                        "   \t<div class=\"txtbg404\">\n" +
                        "  <div class=\"txtbox\">\n" +
                        "      <p>"+this.message+"</p>\n" +
                        "      <p class=\"paddingbox\">请点击以下链接继续浏览网页</p>\n" +
                        "      <p>》<a style=\"cursor:pointer\" onclick=\"history.back()\">返回上一页面</a></p>\n" +
                        "      <p>》<a href=\"https://www.hanszz.com\">返回网站首页</a></p>\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "</body>\n" +
                        "</html>\n";

        return htmlPage+"";
    }

    public String errorTextMsg(){
        JSONObject json = new JSONObject();
        json.put("code",this.code);
        json.put("description",this.description);
        json.put("message",this.message);
        json.put("body","");
        return json.toJSONString();
    }
}
