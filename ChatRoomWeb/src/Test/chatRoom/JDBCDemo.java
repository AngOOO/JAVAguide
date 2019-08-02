package chatRoom;

import chatRoom.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    @Test
    public void testQuery(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,2);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String passWord = resultSet.getString("password");
                System.out.println("id:"+id+",userName:"+userName+",password:"+passWord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResources(connection,statement,resultSet);
        }
    }
}
