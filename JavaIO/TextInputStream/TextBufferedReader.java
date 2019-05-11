package TextInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*System.out.print("请输入（默认换行结束）>");
        try {
            System.out.println("内容为>"+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("请输入>");
        String len = null;
        while ((len = br.readLine()) != null) {
            if ("quit".equals(len)) {
                break;
            }
        }
    }
}
