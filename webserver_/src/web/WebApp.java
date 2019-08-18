package web;

import server.Servlet;
import util.WebContext;
import util.WebHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * 解析配置文件
 */
public class WebApp {
    private static WebContext webContext;

    static {
        try {
            //SAX解析
            // 1、获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 2、从解析工厂获取解析器
            SAXParser parser = factory.newSAXParser();
            // 3、解析处理器
            // 4、加载文档注册处理器
            WebHandler handler = new WebHandler();
            // 5、解析
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("C:\\Users\\ANGOOO\\Documents\\JAVAguide\\webserver_\\src\\web.xml");
            parser.parse(in,handler);
            // 获取数据
            webContext = new WebContext(handler.getEntities(), handler.getMappings());
        } catch (Exception e) {
            System.err.println("解析配置文件失败...");
            e.printStackTrace();
        }
    }
    //通过URL获取配置文件对应的servlet
    public static Servlet getServletFromUrl(String url){
        String className = webContext.getClz("/"+url);
        Class clz;
        try{
            System.out.println("url:"+url+" className:"+className);
            clz = Class.forName(className);
            return (Servlet) clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
