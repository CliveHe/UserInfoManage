package cn.cliveh.service;

import cn.cliveh.domain.User;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/25
 */
public interface UserService {

    /**
     * 获取全部的用户
     * @return 用户列表
     */
    public List<User> getUsers();

    /**
     * 根据ID获取用户
     * @param id
     * @return User用户信息
     */
    public User getUser(String id);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);
    /**
     * 删除用户信息
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

}
