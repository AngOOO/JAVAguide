package chatRoom.entity;

import lombok.Data;

import java.util.Map;
@Data
public class MessageToClient {
    //聊天内容
    private String content;
    //服务端登陆所有用户列表
    private Map<String, String> names;

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent(String userName, String content) {
        this.content = userName + ":" + content;
    }
}
