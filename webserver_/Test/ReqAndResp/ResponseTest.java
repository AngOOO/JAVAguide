package ReqAndResp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static util.Utils.readHtml;

public class ResponseTest {
    @Test
    public void TestResponse(){
        ServerSocket clientServer = null;
        try {
            clientServer = new ServerSocket(8888);
            Socket client = clientServer.accept();
            Request request = new Request(client);
            Response response = new Response(client);
            InputStream in = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("index.html");
            String str = readHtml(in,"index.html");
            response.print(str);
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
