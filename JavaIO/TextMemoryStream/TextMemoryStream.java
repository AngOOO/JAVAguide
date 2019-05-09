package TextMemoryStream;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TextMemoryStream {
    public static void main(String[] args) {
        String msg = "Hello Java!";
        ByteArrayInputStream in = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int len = -1;
        while ((len = in.read()) != -1) {
            int newValue = Character.toUpperCase(len);
            out.write(newValue);
        }

        byte[] newData = out.toByteArray();
        System.out.println(new String(newData));
    }
}
