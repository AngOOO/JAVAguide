package SingleServer;

import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleServer {
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ServerSocket serverSocket = null;
                    try {//创建服务端socket
                        serverSocket = new ServerSocket(6666);
                        System.out.println("服务端启动：" +
                                serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
                        //等待客户端连接
                        final Socket socket = serverSocket.accept();
                        System.out.println("等待用户端" +
                                socket.getRemoteSocketAddress() + "链接ing...");
                        //服务端接受客户端数据
                        InputStream in = socket.getInputStream();
                        Scanner scanner = new Scanner(in);
                        System.out.println("接收到客户端的数据：" + scanner.next());
                        //服务端发送数据到客户端
                        OutputStream out = socket.getOutputStream();
                        PrintStream printStream = new PrintStream(out);
                        printStream.println("你好！" + socket.getRemoteSocketAddress());
                        printStream.flush();

                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
