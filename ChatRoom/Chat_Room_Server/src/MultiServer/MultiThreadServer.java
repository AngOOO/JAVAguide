package MultiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadServer {
    //支持处理客户端数100
    //一个线程池可处理10个客户端
    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(10, new ThreadFactory() {
                private final AtomicInteger id = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread - Client - Handler - " + id.getAndIncrement());
                    return thread;
                }
            });

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务端启动！ " + serverSocket.getInetAddress() +serverSocket.getLocalPort());

            while (true) {
                final Socket clientSocket = serverSocket.accept();
                //使用线程池执行业务逻辑
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
