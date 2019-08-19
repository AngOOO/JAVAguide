package ReqAndResp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestTest {
    @Test
    public void TestRequest(){
        ServerSocket clientServer = null;
        try {
            clientServer = new ServerSocket(8888);
            Socket client = clientServer.accept();
            InputStream is =client.getInputStream();
            Request request = new Request(is);
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
