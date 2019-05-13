package MultiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadServer {
    public static void main(String[] args) {
        //--port=6666  --thread=10
        System.out.println(Arrays.toString(args));
        int defaultPort = 6666;
        int defaultThread = 10;
        int port = defaultPort;
        int thread = defaultThread;
        for (String arg : args){
            if (arg.startsWith("--port")){
                String portStr = arg.substring("--port".length());
                try{
                    port = Integer.parseInt(portStr);
                }catch (NumberFormatException e){
                    port = defaultPort;
                }
            }
        }
        for (String arg : args){
            if (arg.startsWith("--thread")){
                String threadStr = arg.substring("--thread".length());
                try{
                    thread = Integer.parseInt(threadStr);
                }catch (NumberFormatException e){
                    thread = defaultThread;
                }
            }
        }
        //支持处理客户端数100
        //一个线程池可处理10个客户端
        final ExecutorService executorService =
                Executors.newFixedThreadPool(thread, new ThreadFactory() {
                    private final AtomicInteger id = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("Thread - Client - Handler - " + id.getAndIncrement());
                        return thread;
                    }
                });
        try {
            ServerSocket serverSocket = new ServerSocket(port);
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
