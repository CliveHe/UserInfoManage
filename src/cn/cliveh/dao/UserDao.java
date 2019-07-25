package cn.cliveh.dao;

<<<<<<< HEAD
=======
import cn.cliveh.domain.Admin;
>>>>>>> add LoginFilter and SensitiveWordFilter
import cn.cliveh.domain.User;

import java.util.List;

/**
<<<<<<< HEAD
 * @author CliveH
 * @date 2019/7/13
=======
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
     * 判断用户是否存在
     */
    public User checkUser(String username, String password);
=======
     * 判断管理员是否存在
     */
    public Admin checkAdmin(String username, String password);
>>>>>>> add LoginFilter and SensitiveWordFilter
}
