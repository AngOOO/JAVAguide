package chatRoom.service;

import chatRoom.entity.MessageFromClient;
import chatRoom.entity.MessageToClient;
import chatRoom.utils.Utils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的websocket
    private static CopyOnWriteArraySet<WebSocket> clients =
            new CopyOnWriteArraySet<>();
    //缓存所有用户列表
    private static Map<String,String> names = new ConcurrentHashMap<>();
    //绑定当前websocket会话
    private Session session;
    //当前客户端的用户名
    private String userName;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        // username=' + '${username}
        String userName = session.getQueryString().split("=")[1];
        this.userName = userName;
        //将客户端聊天实体保存到clients
        clients.add(this);
        //将单签用户以及SessionID保存到用户列表
        names.put(session.getId(),userName);
        System.out.println("SessionID:"+session.getId()+"  userName:"+userName+"已连接");
        //发送给所有在线用户上线通知
        MessageToClient messageToClient = new MessageToClient();
        messageToClient.setContent(userName+"上线了！");
        messageToClient.setNames(names);
        //发送消息
        String jsonStr = Utils.objectToJson(messageToClient);
        for (WebSocket webSocket : clients){
            webSocket.sendMsg(jsonStr);
        }
    }
    @OnError
    public void onError(Throwable e){
        System.err.println("WebSocket连接失败");
    }
    @OnMessage
    public void onMessage(String msg){
        //将msg转换为MessageFromClient
        MessageFromClient messageFromClient = (MessageFromClient)
                Utils.jsonToObject(msg,MessageFromClient.class);
        if (messageFromClient.getType().equals("1")){
            //群聊
            groupChat(messageFromClient);
        }else if (messageFromClient.getType().equals("2")){
            //私聊
            privateChat(messageFromClient);
        }
    }
    private void groupChat(MessageFromClient mfc){
        String content = mfc.getMsg();
        MessageToClient mtc = new MessageToClient();
        mtc.setContent(content);
        mtc.setNames(names);
        for (WebSocket webSocket : clients){
            webSocket.sendMsg(Utils.objectToJson(mtc));
        }
    }
    private void privateChat(MessageFromClient mfc){
        String content = mfc.getMsg();
        int toLength = mfc.getTo().length();
        String[] tos = mfc.getTo()
                .substring(0,toLength-1).split("-");
        List<String> list = Arrays.asList(tos);
        for (WebSocket webSocket:clients){
            if (list.contains(webSocket.session.getId())&&
                    this.session.getId() != webSocket.session.getId()){
                MessageToClient mtc = new MessageToClient();
                mtc.setContent(userName,content);
                mtc.setNames(names);
                webSocket.sendMsg(Utils.objectToJson(mtc));
            }
        }
    }
    private void sendMsg(String msg){
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose(){
        //将客户端移除
        clients.remove(this);
        names.remove(session.getId());
        System.out.println("userName:"+userName+"断开连接");
        MessageToClient messageToClient = new MessageToClient();
        messageToClient.setContent(userName+"下线了！");
        messageToClient.setNames(names);
        String jsonStr = Utils.objectToJson(messageToClient);
        for (WebSocket webSocket:clients){
            webSocket.sendMsg(jsonStr);
        }
    }
}
