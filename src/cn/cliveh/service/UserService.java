package cn.cliveh.service;

<<<<<<< HEAD
=======
import cn.cliveh.dao.UserDao;
>>>>>>> add LoginFilter and SensitiveWordFilter
import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;

import java.util.List;

/**
 * @author CliveH
 */
public class UserService {

<<<<<<< HEAD
    //获取全部的用户
    public List<User> getUsers() {
        UserDaoImpl udi = new UserDaoImpl();
        List<User> userList = udi.queryAllUser();

        for (User user : userList) {
            System.out.println(user);
        }
=======
    UserDao dao = new UserDaoImpl();

    //获取全部的用户
    public List<User> getUsers() {
        List<User> userList = dao.queryAllUser();

        /*for (User user : userList) {
            System.out.println(user);
        }*/
>>>>>>> add LoginFilter and SensitiveWordFilter
        return userList;
    }

    //根据ID获取用户
    public User getUser(String id) {
<<<<<<< HEAD
        UserDaoImpl udi = new UserDaoImpl();
        //根据id查询用户信息
        return udi.query(id);
=======
        //根据id查询用户信息
        return dao.query(id);
>>>>>>> add LoginFilter and SensitiveWordFilter
    }

    //修改用户信息
    public void updateUser(User user) {
<<<<<<< HEAD
        UserDaoImpl udi = new UserDaoImpl();
        udi.update(user);
=======
        dao.update(user);
>>>>>>> add LoginFilter and SensitiveWordFilter
    }

    //删除用户信息
    public void deleteUser(String id) {
<<<<<<< HEAD
        UserDaoImpl udi = new UserDaoImpl();
        udi.delete(id);
=======
        dao.delete(id);
>>>>>>> add LoginFilter and SensitiveWordFilter
    }

    //添加用户
    public void addUser(User user) {
<<<<<<< HEAD
        UserDaoImpl udi = new UserDaoImpl();
        udi.addUser(user);
=======
        dao.addUser(user);
>>>>>>> add LoginFilter and SensitiveWordFilter
    }

}
