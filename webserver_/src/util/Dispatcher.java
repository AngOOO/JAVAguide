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
 * 创建多线程完成请求响应
 */
public class Dispatcher implements Runnable {
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher(Socket client){
        this.client = client;
        try{
            request = new Request(client);
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
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
            try {
                response.pushToBro(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
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
