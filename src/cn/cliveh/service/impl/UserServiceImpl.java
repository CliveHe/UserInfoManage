package cn.cliveh.service.impl;


import cn.cliveh.dao.UserDao;
import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;

import java.util.List;

/**
 * 用户逻辑操作
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/15
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    /**
     * 获取全部的用户
     * @return 用户列表
     */
    @Override
    public List<User> getUsers() {
        return dao.queryAllUser();
    }

    /**
     * 根据ID获取用户
     * @param id
     * @return User用户信息
     */
    @Override
    public User getUser(String id) {
        //根据id查询用户信息
        return dao.query(id);
    }

    /**
     * 修改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    /**
     * 删除用户信息
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        dao.delete(id);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

}
