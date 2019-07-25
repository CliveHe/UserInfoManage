package cn.cliveh.dao.impl;

import cn.cliveh.dao.UserDao;
<<<<<<< HEAD
=======
import cn.cliveh.domain.Admin;
>>>>>>> add LoginFilter and SensitiveWordFilter
import cn.cliveh.domain.User;
import cn.cliveh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
<<<<<<< HEAD
 * @author CliveH
=======
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
>>>>>>> add LoginFilter and SensitiveWordFilter
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User query(String id) {

<<<<<<< HEAD
        String sql = "select * from user where id=" + id + ";";
=======
        String sql = "select * from user where id=" + id;
>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
=======
>>>>>>> add LoginFilter and SensitiveWordFilter

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
<<<<<<< HEAD
            //JDBCUtils.release(connection, preparedStatement);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
=======
            JDBCUtils.release(connection, preparedStatement, resultSet);
>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
=======
>>>>>>> add LoginFilter and SensitiveWordFilter

                userList.add(users);

                //return userList;
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
<<<<<<< HEAD
            JDBCUtils.release(connection, preparedStatement);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                resultSet = null;
            }
=======
            JDBCUtils.release(connection, preparedStatement, resultSet);
>>>>>>> add LoginFilter and SensitiveWordFilter
        }

        return null;
    }

    @Override
    public void addUser(User user) {

<<<<<<< HEAD
        String sql = "insert into user values(null,?,?,?,?,?,?,?,?);";
=======
        String sql = "insert into user values(null,?,?,?,?,?,?);";
>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
            preparedStatement.setString(7, user.getUsername());
            preparedStatement.setString(8, user.getPassword());
=======
>>>>>>> add LoginFilter and SensitiveWordFilter

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }

    @Override
    public void delete(String id) {

<<<<<<< HEAD
        String sql = "delete from user where id=" + id + ";";
=======
        String sql = "delete from user where id=" + id;
>>>>>>> add LoginFilter and SensitiveWordFilter
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

<<<<<<< HEAD
        String sql = "update user set name=?, gender=?, age=?, address=?, qq=?, email=?, username=?, password=? where id=?;";
=======
        String sql = "update user set name=?, gender=?, age=?, address=?, qq=?, email=? where id=?;";
>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
            preparedStatement.setString(7, user.getUsername());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setInt(9, user.getId());
=======
            preparedStatement.setInt(7, user.getId());
>>>>>>> add LoginFilter and SensitiveWordFilter

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement);
        }

    }

    @Override
<<<<<<< HEAD
    public User checkUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user WHERE username='"+username+"' AND password="+password;
        System.out.println(sql);
=======
    public Admin checkAdmin(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM admin WHERE username='"+username+"' AND password="+password;
>>>>>>> add LoginFilter and SensitiveWordFilter

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
<<<<<<< HEAD
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
=======
                Admin adminUser = new Admin();

                adminUser.setUsername(resultSet.getString("username"));
                adminUser.setPassword(resultSet.getString("password"));
                adminUser.setName(resultSet.getString("name"));

                return adminUser;
>>>>>>> add LoginFilter and SensitiveWordFilter
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        return null;
    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.queryAllUser();

        for (User user : users) {
            System.out.println(user);
        }
=======

        //数据库中匹配用户不到就返回null
        return null;
>>>>>>> add LoginFilter and SensitiveWordFilter
    }
}
