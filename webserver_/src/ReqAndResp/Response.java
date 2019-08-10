package ReqAndResp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import static util.Utils.CRLF;
import static util.Utils.createHeadInfo;

/**
 * 分析响应信息
 */
public class Response {
    private BufferedWriter bw;
    // 正文
    private StringBuilder content;
    // 协议头(状态行与请求头 回车) 信息
    private StringBuilder headInfo;
    // 正文字节数
    private int length;

    public Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        length = 0;
    }

    //通过输出流获取客户端信息
    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response(OutputStream on) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(on));
    }

    //添加正文内容
    public Response print(String info) {
        content.append(info);
        length += info.getBytes().length;
        return this;
    }

    public Response println(String info) {
        content.append(info).append(CRLF);
        length += (info + CRLF).getBytes().length;
        return this;
    }

    //推送响应信息
    public void pushToBro(int code) {
        if (headInfo == null) {
            code = 505;
        }
        //拼接后的响应信息
        headInfo = createHeadInfo(headInfo, length, code);
        try {
            bw.append(headInfo);
            bw.append(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
