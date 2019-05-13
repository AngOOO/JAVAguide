package MultiServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private String currentName;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    private static final Map<String, Socket> SOCKET_MAP = new ConcurrentHashMap<>();

    @Override
    public void run() {
        //业务实现
        try {
            InputStream in = this.clientSocket.getInputStream();
            Scanner scanner = new Scanner(in);
            while (true) {
                String line = scanner.nextLine();
                if (line.startsWith("register")) {
                    String[] strings = line.split(":");
                    if (strings.length == 2 && "register".equals(strings[0])) {
                        String name = strings[1];
                        register(name, this.clientSocket);
                    }
                    continue;
                }
                if (line.startsWith("group")) {
                    String[] strings = line.split(":");
                    if (strings.length == 2 && "group".equals(strings[0])) {
                        String msg = strings[1];
                        group(msg);
                    }
                    continue;
                }
                if (line.startsWith("private")) {
                    String[] strings = line.split(":");
                    if (strings.length == 3 && "private".equals(strings[0])) {
                        String name = strings[1];
                        String msg = strings[2];
                        privateChat(name, msg);
                    }
                    continue;
                }
                if ("quit".equals(line)) {
                    quit();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void register(String name, Socket socket) throws IOException {
        currentName = name;
        SOCKET_MAP.put(name, this.clientSocket);
        this.sentMessage(this.clientSocket, "恭喜<" + name + ">注册成功");
        printOnlineClient();
    }

    private void group(String message) throws IOException {
        //不包含自己
        //格式： sb:msg
        Set<Map.Entry<String, Socket>> entrySet = SOCKET_MAP.entrySet();
        /*String currentName = "";
        for (Map.Entry<String, Socket> entry : entrySet) {
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if (socket == this.clientSocket) {
                currentName = key;
            }
        }*/
        for (Map.Entry<String, Socket> entry : entrySet) {
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if (socket != this.clientSocket) {
                this.sentMessage(socket, currentName + ":" + message);
            }
        }
    }

    private void privateChat(String name, String msg) throws IOException {
        Set<Map.Entry<String, Socket>> entrySet = SOCKET_MAP.entrySet();
        /*String currentName = "";
        for (Map.Entry<String, Socket> entry : entrySet) {
            String key = entry.getKey();
            Socket socket = entry.getValue();
            if (socket == this.clientSocket) {
                currentName = key;
            }
        }*/
        Socket socket = SOCKET_MAP.get(name);
        if (socket != null) {
            this.sentMessage(socket, currentName + ":" + msg);
        }
    }

    private void quit() {
        Iterator<Map.Entry<String, Socket>> iterator = SOCKET_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Socket> entry = iterator.next();
            if (entry.getValue() == this.clientSocket) {
                System.out.println(entry.getKey() + "退出了");
                iterator.remove();
                break;
            }
        }
        printOnlineClient();
    }

    private void sentMessage(Socket socket, String msg) throws IOException {
        OutputStream out = socket.getOutputStream();
        PrintStream printStream = new PrintStream(out);
        printStream.println(msg);
        printStream.flush();
    }

    private void printOnlineClient() {
        System.out.println("当前有" + SOCKET_MAP.size() + "个客户端在线,名称列表如下：");
        for (String key : SOCKET_MAP.keySet()) {
            System.out.println(key);
        }
    }
}
