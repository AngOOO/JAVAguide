package user;

import ReqAndResp.Request;
import ReqAndResp.Response;
import server.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request req, Response resp) {
        String uname = req.getParaVal("uname");
        String[] favs =req.getParaValues("fav");
        resp.print("<html>");
        resp.print("<head>");
        resp.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">" );
        resp.print("<title>");
        resp.print("注册成功");
        resp.print("</title>");
        resp.print("</head>");
        resp.print("<body>");
        resp.println("你注册的信息为:"+uname);
        resp.println("你喜欢的类型为:");
        for(String v:favs) {
            if(v.equals("0")) {
                resp.print("萝莉型");
            }else if(v.equals("1")) {
                resp.print("豪放型");
            }else if(v.equals("2")) {
                resp.print("经济节约型");
            }
        }
        resp.print("</body>");
        resp.print("</html>");
    }
}
