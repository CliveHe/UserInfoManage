package cn.cliveh.service;

import cn.cliveh.domain.Admin;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/25
 */
public interface LoginService {
    public Admin login(String name, String password);
}
