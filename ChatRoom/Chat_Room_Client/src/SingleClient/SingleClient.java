package SingleClient;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.security.Principal;
import java.util.Scanner;

public class SingleClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6666;
        try {//创建客户端，连接服务端
            Socket socket = new Socket(host, port);
            //客户端向服务端发送数据
            OutputStream out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("连接服务端：" + socket.getInetAddress());
            printStream.flush();
            //客户端接受服务端数据
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            System.out.println("接受到服务端数据：" + scanner.next());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
