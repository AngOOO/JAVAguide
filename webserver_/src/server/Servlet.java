package server;

import ReqAndResp.Request;
import ReqAndResp.Response;

import java.io.IOException;

/**
 * 服务器脚本接口
 */
public interface Servlet {
    void service(Request req, Response resp) throws IOException;
}
