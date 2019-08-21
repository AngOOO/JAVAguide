package web;
import ReqAndResp.Request;
import ReqAndResp.Response;
import org.junit.Test;
import server.Servlet;
import util.WebContext;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static util.Utils.parseText;
import static util.Utils.readHtml;

public class WebAppTest {
    @Test
    public void testGetServletFromUrl() {
        WebContext webContext = parseText("web.xml");
        webContext.getClz("/login");
        ServerSocket clientServer = null;
        try {
            clientServer = new ServerSocket(8888);
            Socket client = clientServer.accept();
            Request request = new Request(client);
            Response response = new Response(client);
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
