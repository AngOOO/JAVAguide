package chatRoom.utils;

import chatRoom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class UtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "datasource.properties";
        Properties properties = Utils.loadProperties(fileName);
        String url = properties.getProperty("url");
        Assert.assertNotNull(url);
    }

    @Test
    public void objectToJsonTest() {
        User user = new User();
        user.setId(1901);
        user.setUserName("Tom");
        user.setPassWord("123");
        String jsonStr = Utils.objectToJson(user);
        System.out.println(jsonStr);
    }

    @Test
    public void jsonToObjectTest() {
        String jsonStr = "{\"id\":1901,\"userName\":\"Tom\",\"passWord\":\"123\"}";
        User user = (User) Utils.jsonToObject(jsonStr, User.class);
        System.out.println(user);
    }
}