package ReqAndResp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseTest {
    @Test
    public void TestResponse(){
        ServerSocket clientServer = null;
        try {
            clientServer = new ServerSocket(8888);
            Socket client = clientServer.accept();
            Request request = new Request(client);
            Response response = new Response(client);
            response.print("<html>\n" +
                    "\t<head>\n" +
                    "\t\t<title>首页</title>\n" +
                    "\t</head>\n" +
                    "\t<body>\n" +
                    "\t\t<h1>欢迎进入</h1>\n" +
                    "\t</body>\n" +
                    "</html>");
            response.pushToBro(200);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
