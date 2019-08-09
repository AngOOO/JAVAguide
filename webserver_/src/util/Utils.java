package util;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Utils {
    public static final String CRLF = "\r\n";
    public static final String BLANK =" ";

    //分解请求协议
    public static void parseReqInfo(String reqInfo, String method, String url,
                                    Map<String, List<String>> paraMap) {
        //请求方法：从开始到第一个“/”
        method = reqInfo
                .substring(0, reqInfo.indexOf("/"))
                .toLowerCase().trim();
        System.out.println(method);

        //请求url：第一个“/”到HTTP/...?后为请求参数
        // 1、获取开始位置(/后)
        int urlStart = reqInfo.indexOf("/") + 1;
        // 2、获取结束位置(HTTP/位置)
        int urlEnd = reqInfo.indexOf("HTTP/");
        // 3、提取url
        url = reqInfo.substring(urlStart, urlEnd).trim();
        // 4、获取请求参数开始位置(?位置)
        int queryStart = url.indexOf("?");
        // 5、若存在的请求参数，将url与请求参数分离
        String queryStr = null;
        if (queryStart >= 0) {
            String[] urlData = url.split("\\?");
            url = urlData[0];
            //get请求参数：
            queryStr = urlData[1];
        }
        System.out.println(url);

        //post请求参数(存在于请求体中)：
        if ("post".equals(method)) {
            String tmp = reqInfo.substring(reqInfo.lastIndexOf(CRLF)).trim();
            if (queryStr == null) {
                queryStr = tmp;
            } else {
                queryStr += "&" + tmp;
            }
        }
        queryStr = null == queryStr ? "" : queryStr;
        System.out.println(queryStr);
        //将请求参数存入map
        paraMap = convertMap(queryStr);
        System.out.println(paraMap);
    }

    //将请求参数存入Map
    private static Map<String, List<String>> convertMap(String queryStr) {
        Map<String, List<String>> paraMap = new HashMap<>();
        // 1、以“&”分割字符串
        String[] qStr1 = queryStr.split("&");
        // 2、以“=”分割字符串
        for (String qStr : qStr1) {
            String[] qStr2 = qStr.split("=");
            qStr2 = Arrays.copyOf(qStr2, 2);
            String key = qStr2[0];
            String value = decode(qStr2[1], "utf-8");
            if (!paraMap.containsKey(key)){
                paraMap.put(key,new ArrayList<String>());
            }
            paraMap.get(key).add(value);
        }
        return paraMap;
    }

    //处理中文
    private static String decode(String str, String enc) {
        if (str != null) {
            try {
                return java.net.URLDecoder.decode(str, enc);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

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
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("websever Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(length).append(CRLF);
        headInfo.append(CRLF);
        return headInfo;
    }
}
