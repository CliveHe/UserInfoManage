package cn.cliveh.dao.impl;

import cn.cliveh.dao.AdminDao;
import cn.cliveh.dao.UserDao;
import cn.cliveh.domain.Admin;
import cn.cliveh.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 持久层测试
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
 */
public class DaoImplTest {

    @Test
    public void query(){
        UserDao dao = new UserDaoImpl();
        //User user = new User();
        User user = dao.query("1");
        System.out.println(user);
        Assert.assertEquals(user.getName(),"何智强");
    }

    @Test
    public void queryAllUser() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("彭渲");
        user.setGender("女");
        user.setAge(14);
        user.setAddress("湖南省");
        user.setQq("987654321");
        user.setEmail("px2333@qq.com");

        UserDao dao = new UserDaoImpl();
        dao.addUser(user);
    }

    @Test
    public void delete() {
        UserDao dao = new UserDaoImpl();
        dao.delete("7");
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(6);
        user.setName("彭渲");
        user.setGender("女");
        user.setAge(14);
        user.setAddress("湖南省");
        user.setQq("123456789");
        user.setEmail("px@qq.com");

        UserDao dao = new UserDaoImpl();
        dao.update(user);
    }

    @Test
    public void checkAdmin(){
        AdminDao dao = new AdminDaoImpl();
        Admin user = dao.checkAdmin("cliveh","123456");

        System.out.println(user);
    }

    @Test
    public void getTotalCount(){
        Map<String, String[]> condition = new HashMap<>();
        String[] arr = {"李志文"};
        condition.put("name",arr);
        UserDao dao = new UserDaoImpl();
        int totalCount = dao.getTotalCount(condition);
        System.out.println(totalCount);
    }

    @Test
    public void findByPage(){
        Map<String, String[]> condition = new HashMap<>();
        String[] arr = {"李志文"};
        condition.put("name",arr);
        UserDao dao = new UserDaoImpl();
        List<User> byPage = dao.findByPage(2, 3, condition);
        for (User user : byPage) {
            System.out.println(user);
        }
    }
}
