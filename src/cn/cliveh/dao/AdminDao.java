package cn.cliveh.dao;

import cn.cliveh.domain.Admin;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/25
 */
public interface AdminDao {
    /**
     * 判断管理员是否存在
     * @param username
     * @param password
     */
    public Admin checkAdmin(String username, String password);
}
