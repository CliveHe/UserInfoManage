package cn.cliveh.service.impl;

import cn.cliveh.dao.AdminDao;
import cn.cliveh.dao.impl.AdminDaoImpl;
import cn.cliveh.domain.Admin;
import cn.cliveh.service.LoginService;


/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/16
 */
public class LoginServiceImpl implements LoginService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(String name, String password) {
        return dao.checkAdmin(name, password);
    }
}
