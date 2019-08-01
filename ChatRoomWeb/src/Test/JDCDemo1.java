import chatRoom.utils.CommUtils;
import org.junit.Test;

import java.sql.*;

public class JDCDemo1 {
    //select
    @Test
    public void test() {
        try {
            //1,加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2,获取连接
            Connection connection = null;
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "613104");
            //3,执行SQL
            String sql = "select * from user";
            //执行sql语句，每次都先编译后执行
            Statement statement = connection.createStatement();
            String userName = "zs";
            String passWord = "123";
            //获取sql执行数据
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(sql);
            //4,释放资源
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2(){
        try {
            //1,加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2,获取连接
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "613104");
            //3,执行SQL
            String sql = "select * from user" + " where username = ? and password = ?";
            //预编译sql，使用占位符？占位用户名密码等需要外部传入的资源
            PreparedStatement statement = connection.prepareStatement(sql);
            String userName = "zs";
            String passWord = "123";
            statement.setString(1,userName);
            statement.setString(2,passWord);
            //获取sql执行数据
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
            //4,释放资源
            connection.close();
            statement.close();
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
