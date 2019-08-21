package user;

import ReqAndResp.Request;
import ReqAndResp.Response;
import server.Servlet;

import java.io.IOException;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request req, Response resp) throws IOException {
        resp.print("<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"UTF-8\">\n" +
                "\t\t<title>注册</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "注册成功" + req.getParaVal("uname") +
                "\t</body>\n" +
                "</html>");
    }
}
