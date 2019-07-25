package cn.cliveh.dao.impl;

import cn.cliveh.dao.AdminDao;
import cn.cliveh.domain.Admin;
import cn.cliveh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/25
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin checkAdmin(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM admin WHERE username='"+username+"' AND password="+password;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Admin adminUser = new Admin();

                adminUser.setUsername(resultSet.getString("username"));
                adminUser.setPassword(resultSet.getString("password"));
                adminUser.setName(resultSet.getString("name"));

                return adminUser;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //数据库中匹配用户不到就返回null
        return null;
    }
}
