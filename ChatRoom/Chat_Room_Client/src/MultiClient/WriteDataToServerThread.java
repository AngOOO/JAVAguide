package MultiClient;

import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteDataToServerThread extends Thread {
    private final Socket client;

    public WriteDataToServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            OutputStream out = client.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            while (true){
                System.out.print("请输入>");
                String msg = scanner.nextLine();
                printStream.println(msg);
                if ("quit".equals(msg)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
