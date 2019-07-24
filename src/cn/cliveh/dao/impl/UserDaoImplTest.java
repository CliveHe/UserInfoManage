package cn.cliveh.dao.impl;

import cn.cliveh.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void query(){
        UserDaoImpl ud = new UserDaoImpl();
        //User user = new User();
        User user = ud.query("1");
        System.out.println(user);
        Assert.assertEquals(user.getName(),"何智强");
    }

    @Test
    public void queryAllUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.queryAllUser();
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
        user.setUsername("px333");
        user.setPassword("19970321333");

        UserDaoImpl ud = new UserDaoImpl();
        ud.addUser(user);
    }

    @Test
    public void delete() {
        UserDaoImpl ud = new UserDaoImpl();
        ud.delete("7");
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
        user.setUsername("px");
        user.setPassword("19970321");

        UserDaoImpl ud = new UserDaoImpl();
        ud.update(user);
    }

    @Test
    public void checkUser(){
        UserDaoImpl ud = new UserDaoImpl();
        User user = ud.checkUser("cliveh","123456");
        System.out.println(user);
    }
}
