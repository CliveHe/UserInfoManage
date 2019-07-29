package cn.cliveh.service.impl;


import cn.cliveh.dao.UserDao;
import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.Paging;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * 用户逻辑操作
 *
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/15
 */
public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    /**
     * 获取全部的用户
     *
     * @return 用户列表
     */
    @Override
    public List<User> getUsers() {
        return dao.queryAllUser();
    }

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return User用户信息
     */
    @Override
    public User getUser(String id) {
        //根据id查询用户信息
        return dao.query(id);
    }

    /**
     * 分页模糊查询
     *
     * @param currentPage
     * @param rows
     * @param condition
     * @return Paging<User>
     */
    @Override
    public Paging<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition) {

        //调用dao获取数据库总记录的条数
        int totalCount;
        if (condition.size() > 3) {
            totalCount = dao.getTotalCount();
        }else {
            totalCount = dao.getTotalCount(condition);
        }
        //分页页面数量
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        //调用dao获取分页查询的数据
        List<User> list = dao.findByPage(currentPage, rows, condition);

        //封装PagingJavaBean的数据
        Paging<User> paging = new Paging<User>();
        paging.setTotalCount(totalCount);
        paging.setTotalPage(totalPage);
        paging.setList(list);
        paging.setCurrentPage(currentPage);
        paging.setRows(rows);


        return paging;
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    /**
     * 删除用户信息
     *
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        dao.delete(id);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public int getEndPage() {
        //调用dao获取数据库总记录的条数
        int totalCount = dao.getTotalCount();
        //分页页面数量
        int totalPage = (totalCount % 6) == 0 ? (totalCount / 6) : (totalCount / 6 + 1);

        return totalPage;
    }
}
