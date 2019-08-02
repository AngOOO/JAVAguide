package chatRoom.service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的websocket
    private static CopyOnWriteArraySet<WebSocket> clients =
            new CopyOnWriteArraySet<>();
    //绑定当前websocket会话
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        clients.add(this);
        System.out.println("有新的连接，当前SessiodId为"+session.getId()+
        "，当前聊天室有"+clients.size()+"人");
    }
    @OnError
    public void onError(){
        System.err.println("websocket连接失败");
    }
    @OnMessage
    public void onMessage(String msg){
        System.out.println("浏览器发来信息为："+msg);
        //群聊
        for (WebSocket webSocket : clients){
            webSocket.sendMsg(msg);
        }
    }
    public void sendMsg(String msg){

    }
    @OnClose
    public void onClose(){

    }
}
