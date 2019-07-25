package cn.cliveh.dao;

import cn.cliveh.domain.Admin;
import cn.cliveh.domain.User;

import java.util.List;

/**
 * 持久层接口
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
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

}
