package TextStream;

import java.io.*;

public class TransformationStream {
    public static void MyOutputStreamWriter() {
        File file = new File("C:\\Users\\ANGOOO\\Documents\\javaidea\\JavaIO\\src\\Text1\\Text1.txt");
        if (!file.getParentFile().exists()) {
            boolean result = file.getParentFile().mkdirs();
            System.out.println("创建父目录：" + result);
            System.out.println("需要重新运行程序");
        }
        try {
            OutputStream out = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(out);//将字节输出流转换为字节输入流
            writer.write("方便中文操作.");
            writer.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void MyInputStreamReader(){
        File file = new File("D:\\下载\\MJY\\text.txt");
        if (file.exists()){
            try {
                InputStream in = new FileInputStream(file);
                Reader reader = new InputStreamReader(in);
                char[] msg = new char[2];
                int len = -1;
                while ((len = reader.read(msg))!=-1){
                    System.out.println(new String(msg,0,len));
                }
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件不存在！");
        }
    }
    public static void main(String[] args) {
        MyOutputStreamWriter();
    }
}
