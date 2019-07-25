package cn.cliveh.dao.impl;

import cn.cliveh.dao.UserDao;
import cn.cliveh.domain.Admin;
import cn.cliveh.domain.User;
import cn.cliveh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层实现类
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User query(String id) {

        String sql = "select * from user where id=" + id;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setQq(resultSet.getString("qq"));
                user.setEmail(resultSet.getString("email"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.release(connection, preparedStatement, resultSet);

        }

        return null;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> userList = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM user;";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User users = new User();

                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString("name"));
                users.setGender(resultSet.getString("gender"));
                users.setAge(resultSet.getInt("age"));
                users.setAddress(resultSet.getString("address"));
                users.setQq(resultSet.getString("qq"));
                users.setEmail(resultSet.getString("email"));

                userList.add(users);

                //return userList;
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.release(connection, preparedStatement, resultSet);

        }

        return null;
    }

    @Override
    public void addUser(User user) {

        String sql = "insert into user values(null,?,?,?,?,?,?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getQq());
            preparedStatement.setString(6, user.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }

    @Override
    public void delete(String id) {

        String sql = "delete from user where id=" + id;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }
    }

    @Override
    public void update(User user) {

        String sql = "update user set name=?, gender=?, age=?, address=?, qq=?, email=? where id=?;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getQq());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setInt(7, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }
}
