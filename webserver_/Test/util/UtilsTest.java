package util;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static util.Utils.createHeadInfo;
import static util.Utils.parseReqInfo;

public class UtilsTest {
    @Test
    public void testParseReqInfo() {
        String getStr = "GET /login.html?uname=aaaa&pwd=shsxt HTTP/1.1\n" +
                "Host: localhost:8888\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, sdch, br\n" +
                "Accept-Language: zh-CN,zh;q=0.8";
        String post = "POST /aaaa?uname=laopei HTTP/1.1\n" +
                "Host: localhost:8888\n" +
                "Connection: keep-alive\n" +
                "Content-Length: 22\n" +
                "Cache-Control: max-age=0\n" +
                "Origin: null\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: zh-CN,zh;q=0.8\n" + "\r\n" +
                "pwd=soeasy";
        String method = null;
        String url = null;
        Map<String, List<String>> paraMap = null;
        parseReqInfo(getStr, method, url,paraMap);
        parseReqInfo(post, method, url, paraMap);
    }
    @Test
    public void testCreateHeadInfo(){
        StringBuilder headInfo = new StringBuilder();
        int length = 0;
        int code = 200;
        headInfo = createHeadInfo(headInfo,length,code);
        System.out.println(headInfo.toString());
    }
}
