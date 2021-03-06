package server;

import util.Dispatcher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建ServerSocket
 * 建立连接获取Socket
 * 通过输入流获取请求协议
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            System.err.println("服务器启动失败...");
            e.printStackTrace();
        }finally {
            stop();
        }
    }
    //接受连接处理
    public void receive(){
        while (isRunning){
            try{
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接...");
                //多线程处理，获取请求协议
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                System.err.println("客户端错误...");
                e.printStackTrace();
            }
        }
    }
    //停止服务
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器关闭...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
