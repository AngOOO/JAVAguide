package TextInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TextInputStream {
    public static void main(String[] args) throws IOException {
        /*InputStream in = System.in;
        System.out.print("请输入>");
        byte[] msg = new byte[1024];
        System.out.println("内容为>"+new String(msg,0,in.read(msg)));*/
        InputStream in = System.in;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.out.print("请输入>");
        byte[] msg = new byte[3];
        int len = -1;
        while ((len = in.read(msg))!= -1){
            out.write(msg,0,len);
            if (len < msg.length){
                break;
            }
        }
        in.close();
        out.close();
        System.out.println("内容为>"+new String(out.toByteArray()));
    }
}
