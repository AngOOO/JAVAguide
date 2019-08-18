package server;

import ReqAndResp.Request;
import ReqAndResp.Response;
/**
 * 服务器脚本接口
 */
public interface Servlet {
    void service(Request req, Response resp);
}
