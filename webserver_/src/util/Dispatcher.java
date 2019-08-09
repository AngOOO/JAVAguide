package util;


import R.Request;
import R.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 创建多线程启动客户端
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher(Socket client){
        this.client = client;
        try{
            //获取请求协议
            request = new Request(client);
            //获取响应协议
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        try{
            if (request.getUrl()==null||request.getUrl().equals("")){
                InputStream in = Thread.currentThread().
                        getContextClassLoader().getResourceAsStream("index.html");
                response.print(new String(String.valueOf(in.read())));
                response.pushToBro(200);
                in.close();
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
