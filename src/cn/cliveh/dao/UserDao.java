package cn.cliveh.dao;

import cn.cliveh.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 持久层接口
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.2
 * @date 2019/7/15
 */
public interface UserDao {
    /**
     * 查询全部用户
     * @return List<User>
     */
    public List<User> queryAllUser();

    /**
     * 查询用户
     * @param id
     */
    public User query(String id);

    /**
     * 获取数据库全部数据的总记录条数
     * @return totalCount
     */
    public int getTotalCount();

    /**
     * 获取数据库符合条件的总记录数
     * @return totalCount
     * @param condition
     */
    public int getTotalCount(Map<String, String[]> condition);

    /**
     * 获取每页要显示的数据
     * @param currentPage 当前页码
     * @param rows 每页需要显示的行数
     * @param condition 模糊查询的条件
     * @return 用户列表
     */
    public List<User> findByPage(int currentPage, int rows, Map<String, String[]> condition);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void delete(String id);

    /**
     * 更新用户
     * @param user
     */
    public void update(User user);

}
