package web;

import server.Servlet;
import util.WebContext;

import static util.Utils.parseText;

/**
 * 解析配置文件
 * 根据配置文件动态读取类名
 * 进行反射获取具体的Servlet来处理业务
 */
public class WebApp {
    private static WebContext webContext;

    static {
        webContext = parseText("web.xml");
    }
    //通过URL获取配置文件对应的servlet
    public static Servlet getServletFromUrl(String url){
        String className = webContext.getClz("/"+url);
        Class clz;
        try{
            clz = Class.forName(className);
            System.out.println("url:"+url+" className:"+className);
            return (Servlet) clz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
