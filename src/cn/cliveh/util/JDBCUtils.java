package cn.cliveh.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**@author CliveH
 * @date 2019/07/15
 * @ JDBC工具类，使用c3p0连接池
 */
public class JDBCUtils {
    /**
     * 数据库连接池对象
     */
    private static DataSource ds = null;

    /**
     * 初始化C3P0数据源
     */
    static{
        // 使用c3p0-config.xml配置文件中的named-config节点中name属性的值
        ComboPooledDataSource cpds = new ComboPooledDataSource("userinformanage");
        ds = cpds;
    }

    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

    /**
     * 释放数据库连接
     */
    public static void release(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement = null;
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        JDBCUtils.release(connection, preparedStatement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
    }
}
