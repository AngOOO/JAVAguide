package R;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.Utils.parseReqInfo;

/**
 * 分析请求信息
 */
public class Request {
    //协议信息
    private String reqInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //存储参数
    private Map<String, List<String>> paraMap;

    //客户端获取协议信息
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream in) {
        paraMap = new HashMap<>();
        byte[] data = new byte[1024 * 1024 * 1024];
        int length;
        try {
            //通过输入流将协议信息读入
            length = in.read(data);
            this.reqInfo = new String(data, 0, length);
        } catch (IOException e) {
            System.err.println("数据流读取失败...");
            e.printStackTrace();
        }
        //分解请求协议
        parseReqInfo(this.reqInfo,this.method,this.url,this.paraMap);
    }
    //通过name获取对应的多个值
    public String[] getParaValues(String key){
        List<String> values = this.paraMap.get(key);
        if (values==null || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    //通过name获取对应的一个值
    public String getParaVal(String key){
        String[] values = getParaValues(key);
        return values == null?null:values[0];
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

}
