package TextStream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CharacterInputStream {
    public static void main(String[] args) {
        File file = new File("D:\\下载\\MJY\\text.txt");
        if (file.exists()) {
            try {
                Reader in = new FileReader(file);
                /*char[] msg = new char[1024];
                System.out.println("文件中读取内容：" + new String(msg, 0, in.read(msg)));*/
                char[] msg = new char[5];
                int len = -1;
                while ((len = in.read(msg)) != -1) {
                    System.out.print(new String(msg, 0, len));
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在！");
        }

    }
}
