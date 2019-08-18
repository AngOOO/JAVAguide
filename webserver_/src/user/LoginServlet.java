package user;

import ReqAndResp.Request;
import ReqAndResp.Response;
import server.Servlet;

public class LoginServlet implements Servlet {
    @Override
    public void service(Request req, Response resp) {
        resp.print("<html>");
        resp.print("<head>");
        resp.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" );
        resp.print("<title>");
        resp.print("第一个servlet");
        resp.print("</title>");
        resp.print("</head>");
        resp.print("<body>");
        resp.print("欢迎回来:"+req.getParaVal("uname"));
        resp.print("</body>");
        resp.print("</html>");
    }
}
