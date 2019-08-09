package chatRoom.entity;

import lombok.Data;

@Data
public class MessageFromClient {
    //聊天信息
    private String msg;
    //聊天类别：1表示群聊 2表示私聊
    private String type;
    //私聊对象SessionID
    private String to;
}
