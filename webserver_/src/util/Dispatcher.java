package util;

import ReqAndResp.Request;
import ReqAndResp.Response;
import server.Servlet;
import web.WebApp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static util.Utils.readHtml;

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
                InputStream in = Thread.currentThread()
                        .getContextClassLoader().getResourceAsStream("index.html");
                response.print(readHtml(in,"index.html"));
                response.pushToBro(200);
                return;
            }
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (servlet!=null){
                servlet.service(request,response);
                response.pushToBro(200);
            }else {
                InputStream in = Thread.currentThread()
                        .getContextClassLoader().getResourceAsStream("error.html");
                response.print(readHtml(in,"error.html"));
                response.pushToBro(404);
            }
        } catch (IOException e) {
            response.println("正在努力中...");
            response.pushToBro(500);
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
