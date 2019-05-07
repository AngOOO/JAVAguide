package TextStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterOutputStream {
    public static void main(String[] args) {
        File file = new File("D:\\下载\\MJY\\text.txt");
        if (!file.getParentFile().exists()) {
            boolean result = file.getParentFile().mkdirs();
            System.out.println("创建文件父目录成功！" + result);
            System.out.println("需要重新运行程序！");
        }
        try {
            String msg = "你好，西安欢迎您！！！";
            Writer out = new FileWriter(msg);
            out.write(msg);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
