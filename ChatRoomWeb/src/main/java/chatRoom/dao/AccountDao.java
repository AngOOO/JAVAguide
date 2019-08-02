package chatRoom.dao;

import chatRoom.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class AccountDao extends BaseDao {
    //登陆select
    public User userLogin(String username,String password){
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "select * from user where username=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,DigestUtils.md5Hex(password));
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = getUserInfo(resultSet);
            }
        } catch (SQLException e) {
            System.err.println("查询用户不存在");
            e.printStackTrace();
        } finally {
            closeResources(connection,statement,resultSet);
        }
        return user;
    }
    //注册insert
    public boolean userRegister(User user){
        String userName = user.getUserName();
        String password = user.getPassWord();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String sql = "insert into user(username,password) values(?,?)";
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            isSuccess = (statement.executeUpdate() == 1);
        } catch (SQLException e) {
            System.err.println("用户注册失败");
            e.printStackTrace();
        } finally {
            closeResources(connection,statement);
        }
        return isSuccess;
    }
    //将数据表信息封装到user类中
    public User getUserInfo(ResultSet resultSet){

        return null;
    }
}
