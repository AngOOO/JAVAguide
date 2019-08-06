package chatRoom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtils {
    //用于序列化
    private static final Gson gson = new GsonBuilder().create();

    private CommUtils() {
    }

    //加载配置文件
    public static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(filename);
        try {
            properties.load(in);
        } catch (IOException e) {
            System.err.println("配置文件加载失败");
        }
        return properties;
    }

    public static String objectToJson(Object o){
        return gson.toJson(o);
    }

    public static Object jsonToObject(String jsonStr,Class objClass){
        return gson.fromJson(jsonStr,objClass);
    }
    public static boolean strIsNull(String str){
        return str == null || str.equals("");
    }
}
