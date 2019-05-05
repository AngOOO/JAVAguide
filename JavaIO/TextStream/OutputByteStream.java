package TextStream;

import java.io.*;

public class OutputByteStream {
    public static void TextByteStream1() {
        File file = new File("C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text1" + File.separator + "Text1.txt");
        /*if (file.exists()) {
            try {
                OutputStream out = new FileOutputStream(file);
                String msg = "Hello Java,Hello World!";
                out.write(msg.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        if (file.getParentFile().exists()) {
            try {
                OutputStream out = new FileOutputStream(file, true);
                String msg = "\nHello Java,Hello World!";
                out.write(msg.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            boolean result = file.getParentFile().mkdirs();
            System.out.println("创建父目录" + result);
            System.out.println("重新执行程序方可写入！");
        }
    }

    public static void TextByteStream2() {
        File file = new File("C:" + File.separator + "Users" + File.separator +
                "ANGOOO" + File.separator + "Documents" + File.separator + "javaidea" + File.separator +
                "JavaIO" + File.separator + "src" + File.separator + "Text1" + File.separator + "Text1.txt");
        if (!file.getParentFile().exists()) {
            boolean result = file.getParentFile().mkdirs();
            System.out.println("创建父目录：" + result);
        }
        /*try{
            OutputStream out = new FileOutputStream(file,true);
            String msg = "Hello Xi'An University Of Science and Technology!";
            out.write(msg.getBytes(),6,5);
            out.write(97);//ACS-II
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        //自动关闭流
        try (OutputStream out = new FileOutputStream(file, true)) {
            String msg = "Hello Xi'An University Of Science and Technology!";
            out.write(msg.getBytes(), 6, 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextByteStream2();
    }
}
