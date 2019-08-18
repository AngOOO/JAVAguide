package util;

import org.junit.Test;
import server.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import static util.Utils.createHeadInfo;
import static util.Utils.parseReqInfo;

public class UtilsTest {
    @Test
    public void testParseReqInfo() {
        Server server = new Server();
        ServerSocket clientServer = null;
        String requestInfo = null;
        String method = null;
        String url = null;
        Map<String, List<String>> paraMap = null;
        try {
            clientServer = new ServerSocket(8888);
            Socket client = clientServer.accept();
            InputStream is =client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        parseReqInfo(requestInfo, method, url, paraMap);
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
