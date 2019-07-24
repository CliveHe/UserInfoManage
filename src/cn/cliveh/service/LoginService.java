package cn.cliveh.service;

import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;

/**
 * @author CliveH
 */
public class LoginService {
    private UserDaoImpl udi = new UserDaoImpl();

    public User login(String name, String password) {
        return udi.checkUser(name, password);
    }
}
