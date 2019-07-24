package cn.cliveh.dao.impl;

import cn.cliveh.dao.UserDao;
import cn.cliveh.domain.User;
import cn.cliveh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author CliveH
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User query(String id) {

        String sql = "select * from user where id=" + id + ";";
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
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //JDBCUtils.release(connection, preparedStatement);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
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
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));

                userList.add(users);

                //return userList;
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return null;
    }

    @Override
    public void addUser(User user) {

        String sql = "insert into user values(null,?,?,?,?,?,?,?,?);";
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
            preparedStatement.setString(7, user.getUsername());
            preparedStatement.setString(8, user.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }

    @Override
    public void delete(String id) {

        String sql = "delete from user where id=" + id + ";";
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

        String sql = "update user set name=?, gender=?, age=?, address=?, qq=?, email=?, username=?, password=? where id=?;";
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
            preparedStatement.setString(7, user.getUsername());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setInt(9, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }

    @Override
    public User checkUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user WHERE username='"+username+"' AND password="+password;
        System.out.println(sql);

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
                user.setQq(resultSet.getString("qq"));
                user.setEmail(resultSet.getString("email"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.queryAllUser();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
