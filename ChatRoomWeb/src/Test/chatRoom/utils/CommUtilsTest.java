package chatRoom.utils;

import chatRoom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "datasource.properties";
        Properties properties = CommUtils.loadProperties(fileName);
        String url = properties.getProperty("url");
        Assert.assertNotNull(url);
    }
    @Test
    public void objectToJsonTest(){
        User user = new User();
        user.setId(1901);
        user.setUserName("Tom");
        user.setPassWord("123");
        String jsonStr = CommUtils.objectToJson(user);
        System.out.println(jsonStr);
    }
}