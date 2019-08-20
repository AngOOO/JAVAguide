package user;

import ReqAndResp.Request;
import ReqAndResp.Response;
import server.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request req, Response resp) {
        resp.print("<html>\n" +
                "\t<head>\n" +
                "\t\t<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">\t\n" +
                "\t\t<title>register</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h1>注册页面</h1>\t\n" +
                "\t</body>\n" +
                "</html>");
    }
}
