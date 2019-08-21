package util;

import ReqAndResp.Request;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import static util.Utils.createHeadInfo;
import static util.Utils.readHtml;

public class UtilsTest {
    @Test
    public void testCreateHeadInfo(){
        StringBuilder headInfo = new StringBuilder();
        int length = 0;
        int code = 404;
        headInfo = createHeadInfo(headInfo,length,code);
        System.out.println(headInfo.toString());
    }
    @Test
    public void testReadHtml(){
        try {
            InputStream in = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("index.html");
            String str = readHtml(in,"index.html");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
