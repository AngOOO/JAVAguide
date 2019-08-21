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
 * 使用输出流将内容输出
 */
public class Response {
    //用于输出内容
    private BufferedWriter bw;
    // 正文
    private StringBuilder content;
    // 协议头(状态行与请求头 回车)
    private StringBuilder headInfo;
    // 正文字节数
    private int length;

    public Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
        length = 0;
    }

    //通过输出流输出响应内容
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

    //动态添加正文内容
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
    public void pushToBro(int code) throws IOException {
        if (headInfo == null) {
            code = 505;
        }
        //拼接后的响应信息
        headInfo = createHeadInfo(headInfo, length, code);
        bw.append(headInfo);
        bw.append(content);
        bw.flush();
    }
}
