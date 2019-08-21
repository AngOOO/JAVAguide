package ReqAndResp;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

import static util.Utils.CRLF;

/**
 * 分析请求信息
 */
public class Request {
    //协议信息
    private String reqInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //存储参数
    private Map<String, List<String>> paraMap;

    //客户端获取协议信息
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream in) {
        paraMap = new HashMap<>();
        byte[] data = new byte[1024 * 1024 * 1024];
        int length;
        try {
            //通过输入流将协议信息读入
            length = in.read(data);
            this.reqInfo = new String(data, 0, length);
        } catch (IOException e) {
            System.err.println("数据流读取失败...");
            e.printStackTrace();
        }
        //分解请求协议
        parseReqInfo();
    }
    //分解请求协议
    public void parseReqInfo() {
        //请求方法：从开始到第一个“/”
        this.method = this.reqInfo
                .substring(0, this.reqInfo.indexOf("/"))
                .toLowerCase().trim();
        System.out.println(this.method);

        //请求url：第一个“/”到HTTP/...?后为请求参数
        // 1、获取开始位置(/后)
        int urlStart = this.reqInfo.indexOf("/") + 1;
        // 2、获取结束位置(HTTP/位置)
        int urlEnd = this.reqInfo.indexOf("HTTP/");
        // 3、提取url
        this.url = this.reqInfo.substring(urlStart, urlEnd).trim();
        // 4、获取请求参数开始位置(?位置)
        int queryStart = this.url.indexOf("?");
        // 5、若存在的请求参数，将url与请求参数分离
        String queryStr = null;
        if (queryStart >= 0) {
            String[] urlData = this.url.split("\\?");
            this.url = urlData[0];
            //get请求参数：
            queryStr = urlData[1];
        }
        System.out.println(this.url);

        //post请求参数(存在于请求体中)：
        if ("post".equals(this.method)) {
            String tmp = this.reqInfo.substring(this.reqInfo.lastIndexOf(CRLF)).trim();
            if (queryStr == null) {
                queryStr = tmp;
            } else {
                queryStr += "&" + tmp;
            }
        }
        queryStr = null == queryStr ? "" : queryStr;
        System.out.println(queryStr);
        //将请求参数存入map
        this.paraMap = convertMap(queryStr);
        System.out.println(this.paraMap);
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
    //通过name获取对应的多个值
    public String[] getParaValues(String key){
        List<String> values = this.paraMap.get(key);
        if (values==null || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    //通过name获取对应的一个值
    public String getParaVal(String key){
        String[] values = getParaValues(key);
        return values == null?null:values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        System.out.println("url:"+url);
        return url;
    }

}
