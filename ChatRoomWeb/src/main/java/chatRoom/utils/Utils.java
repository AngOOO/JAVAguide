package chatRoom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    //用于序列化对象
    private static final Gson gson = new GsonBuilder().create();

    //加载配置文件
    public static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        InputStream in = Utils.class.getClassLoader().getResourceAsStream(filename);
        try {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("配置文件加载失败");
        }
        return properties;
    }

    //对象序列化
    public static String objectToJson(Object o) {
        return gson.toJson(o);
    }

    //将序列化字符串转换为对象
    public static Object jsonToObject(String jsonStr, Class objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    //判断字符串是否为空
    public static boolean strIsNull(String str) {
        return str == null || str.equals("");
    }
}
