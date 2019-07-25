package cn.cliveh.dao.impl;

<<<<<<< HEAD
=======
import cn.cliveh.domain.Admin;
>>>>>>> add LoginFilter and SensitiveWordFilter
import cn.cliveh.domain.User;
import org.junit.Assert;
import org.junit.Test;

<<<<<<< HEAD
import java.util.List;

import static org.junit.Assert.*;

=======
import java.util.Arrays;
import java.util.List;

>>>>>>> add LoginFilter and SensitiveWordFilter
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
<<<<<<< HEAD
        user.setUsername("px333");
        user.setPassword("19970321333");
=======
>>>>>>> add LoginFilter and SensitiveWordFilter

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
<<<<<<< HEAD
        user.setUsername("px");
        user.setPassword("19970321");
=======
>>>>>>> add LoginFilter and SensitiveWordFilter

        UserDaoImpl ud = new UserDaoImpl();
        ud.update(user);
    }

    @Test
<<<<<<< HEAD
    public void checkUser(){
        UserDaoImpl ud = new UserDaoImpl();
        User user = ud.checkUser("cliveh","123456");
=======
    public void checkAdmin(){
        UserDaoImpl ud = new UserDaoImpl();
        Admin user = ud.checkAdmin("cliveh","123456");
>>>>>>> add LoginFilter and SensitiveWordFilter
        System.out.println(user);
    }
}
