package cn.cliveh.service;

import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;

import java.util.List;

/**
 * @author CliveH
 */
public class UserService {

    //获取全部的用户
    public List<User> getUsers() {
        UserDaoImpl udi = new UserDaoImpl();
        List<User> userList = udi.queryAllUser();

        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

    //根据ID获取用户
    public User getUser(String id) {
        UserDaoImpl udi = new UserDaoImpl();
        //根据id查询用户信息
        return udi.query(id);
    }

    //修改用户信息
    public void updateUser(User user) {
        UserDaoImpl udi = new UserDaoImpl();
        udi.update(user);
    }

    //删除用户信息
    public void deleteUser(String id) {
        UserDaoImpl udi = new UserDaoImpl();
        udi.delete(id);
    }

    //添加用户
    public void addUser(User user) {
        UserDaoImpl udi = new UserDaoImpl();
        udi.addUser(user);
    }

}
