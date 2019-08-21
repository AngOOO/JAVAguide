package util;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Utils {
    public static final String CRLF = "\r\n";
    public static final String BLANK =" ";

    //拼接响应协议
    public static StringBuilder createHeadInfo(StringBuilder headInfo,int length,int code){
        //1、构建响应行
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        //2、构建响应头
        headInfo.append("Server:").append("websever Server/0.0.1;charset=utf-8").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(length).append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append(CRLF);
        return headInfo;
    }
    //读取html
    public static String readHtml(InputStream in,String html) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] msg = new byte[10];
        int len = -1;
        while ((len=in.read(msg))!=-1){
            out.write(msg,0,len);
            if (len < msg.length){
                break;
            }
        }
        in.close();
        out.close();
        return new String(out.toByteArray());
    }
    //利用SAX解析配置文件
    public static WebContext parseText(String text){
        WebContext webContext = null;
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
                    .getResourceAsStream(text);
            parser.parse(in,handler);
            // 获取数据
            webContext = new WebContext(handler.getEntities(), handler.getMappings());
        } catch (Exception e) {
            System.err.println("解析配置文件失败...");
            e.printStackTrace();
        }
        return webContext;
    }
}
