package cn.cliveh.dao;

import cn.cliveh.domain.User;

import java.util.List;

/**
 * @author CliveH
 * @date 2019/7/13
 */
public interface UserDao {
    /**
     * 查询全部用户
     */
    public List<User> queryAllUser();

    /**
     * 查询用户
     */
    public User query(String id);

    /**
     * 添加用户
     */
    public void addUser(User user);

    /**
     * 删除用户
     */
    public void delete(String id);

    /**
     * 更新用户
     */
    public void update(User user);

    /**
     * 判断用户是否存在
     */
    public User checkUser(String username, String password);
}
