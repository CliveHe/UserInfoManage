package cn.cliveh.service;

import cn.cliveh.dao.impl.UserDaoImpl;
<<<<<<< HEAD
import cn.cliveh.domain.User;

/**
 * @author CliveH
=======
import cn.cliveh.domain.Admin;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/16
>>>>>>> add LoginFilter and SensitiveWordFilter
 */
public class LoginService {
    private UserDaoImpl udi = new UserDaoImpl();

<<<<<<< HEAD
    public User login(String name, String password) {
        return udi.checkUser(name, password);
=======
    public Admin login(String name, String password) {
        return udi.checkAdmin(name, password);
>>>>>>> add LoginFilter and SensitiveWordFilter
    }
}
