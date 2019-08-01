package chatRoom.utils;

import java.sql.*;
import java.util.Properties;

public class JDBCUtils1 {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String passWord;

    static {
        Properties properties = CommUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverName");
        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        passWord = properties.getProperty("passWord");
        try {
            //加载驱动
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            System.err.println("加载数据库驱动出错");
        }
    }
    //获取连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            System.err.println("获取数据库连接错误");
        }
        return null;
    }
    //释放资源
    public static void closeResources(Connection connection,
                                      Statement statement){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeResources(Connection connection,
                                      Statement statement,
                                      ResultSet resultSet){
        closeResources(connection,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
