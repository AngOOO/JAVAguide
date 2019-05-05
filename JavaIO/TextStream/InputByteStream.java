package TextStream;

import java.io.*;

public class InputByteStream {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text1" + File.separator + "Text1.txt");
        if (file.exists()){
            try {
                InputStream in = new FileInputStream(file);
                byte[] msg = new byte[1024];
                String result = new String(msg,0,in.read(msg));
                //按字节读取
                //String result = new String(msg,0,in.read(msg,0,3));
                System.out.println("读取文件结果："+result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
