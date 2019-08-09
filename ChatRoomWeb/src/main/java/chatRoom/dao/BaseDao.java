package chatRoom.dao;

import chatRoom.utils.Utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
    private static DataSource dataSource;

    //加载资源文件
    static {
        Properties properties = Utils.loadProperties("datasource.properties");
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("获取数据资源失败");
        }
    }

    //连接数据
    public DruidPooledConnection getConnection() {
        try {
            return (DruidPooledConnection) dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("获取数据失败");
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public void closeResources(Connection connection,
                               Statement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResources(Connection connection,
                               Statement statement,
                               ResultSet resultSet) {
        closeResources(connection,statement);
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
