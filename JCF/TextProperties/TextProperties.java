package TextProperties;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class TextProperties {
    public static void TextProperties1() {
        Properties properties = new Properties();
        properties.setProperty("40701", "MJY");
        properties.setProperty("40702", "ZW");
        properties.setProperty("40703", "ZQN");
        System.out.println(properties.getProperty("40703"));
        System.out.println(properties.getProperty("40705"));//null
        System.out.println(properties.getProperty("40705", "LYJ")
        );
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        properties.list(System.out);
        PrintStream printStream = null;
        try {
            printStream = new PrintStream("D:" + File.separator + "text.properties");
            {
                properties.list(printStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void TextProperties2() {
        Properties properties = new Properties();
        String path = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JCF\\src\\text.properties";
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.setProperty("Java", "好好学习");
        try {
            properties.store(new FileOutputStream(path), "add key = value");
            properties.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TextProperties3() {
        Properties properties = new Properties();
        String path = "C:\\Users\\ANGOOO\\Documents\\javaidea\\JCF\\src\\text.properties";
        /*properties.setProperty("40704", "WSN");
        properties.setProperty("40705", "LYJ");
        properties.setProperty("40706", "BXG");*/
        try {
            properties.load(new FileInputStream(path));
            String value = properties.getProperty("40707");
            if (value != null) {
                properties.setProperty("40707", "MXM");
            }
            properties.store(new FileOutputStream(path), "add key = value");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TextProperties4() {
        Properties properties = new Properties();
        InputStream inputStream = TextProperties.
                class.
                getClassLoader().
                getResourceAsStream("text.properties");
        System.out.println(inputStream);
        if (inputStream != null){
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        properties.list(System.out);
    }

    public static void main(String[] args) {
        //TextProperties1();
        //TextProperties2();
        //TextProperties3();
        TextProperties4();
    }
}
