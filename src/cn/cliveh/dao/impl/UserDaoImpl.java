package cn.cliveh.dao.impl;

import cn.cliveh.dao.UserDao;
import cn.cliveh.domain.User;
import cn.cliveh.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 持久层实现类
 *
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

    /**
     * 获取数据库中全部数据的总记录条数
     *
     * @return totalCount
     */
    @Override
    public int getTotalCount() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalCount = -1;

        String sql = "SELECT count(*) FROM user";


        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalCount = resultSet.getInt(1);
            }

            return totalCount;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }

        return -1;
    }

    /**
     * 获取数据库中符合条件的记录条数
     *
     * @param condition
     * @return totalCount
     */
    @Override
    public int getTotalCount(Map<String, String[]> condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int totalCount = -1;

        String sql = "SELECT count(*) FROM user WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);

        //遍历Map
        for (Map.Entry<String, String[]> entry : condition.entrySet()) {
            //获取key
            String key = entry.getKey();
            if ("name".equals(key) || "address".equals(key) || "email".equals(key)) {
                //获取value
                String value = entry.getValue()[0];
                //判断value是否有值
                if (value != null && !("".equals(value))) {
                    sb.append(" and " + key + " like '%" + value + "%'");
                }
            }
        }

        sql = sb.toString();

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalCount = resultSet.getInt(1);
            }

            return totalCount;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }

        return -1;
    }

    /**
     * 获取每页要显示的数据
     *
     * @param currentPage 当前页码
     * @param rows        每页需要显示的行数
     * @param condition
     * @return 用户列表
     */
    @Override
    public List<User> findByPage(int currentPage, int rows, Map<String, String[]> condition) {

        List<User> userList = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM user WHERE 1=1";
        StringBuilder sb = new StringBuilder(sql);

        if (condition.size() == 3) {
            //遍历Map
            for (Map.Entry<String, String[]> entry : condition.entrySet()) {
                //获取key
                String key = entry.getKey();
                if ("name".equals(key) || "address".equals(key) || "email".equals(key)) {
                    //获取value
                    String value = entry.getValue()[0];
                    //判断value是否有值
                    if (value != null && !("".equals(value))) {
                        sb.append(" and " + key + " like '%" + value + "%'");
                    }
                }
            }
        }

        sb.append(" LIMIT " + rows + " OFFSET " + (rows * (currentPage - 1)));

        sql = sb.toString();

        System.out.println(sql);

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
