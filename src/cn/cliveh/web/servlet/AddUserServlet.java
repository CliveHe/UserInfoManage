package cn.cliveh.web.servlet;

import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CliveH
 */
@WebServlet(name = "AddUserServlet", urlPatterns = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        //设置request对象的解码方式
        request.setCharacterEncoding("utf-8");

=======
>>>>>>> add LoginFilter and SensitiveWordFilter
        //封装数据
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        //将String型的ID转为int型，转换前判断是否为空
        user.setAge(request.getParameter("age") != null && !"".equals(request.getParameter("age")) ? Integer.parseInt(request.getParameter("age")) : null);
        user.setAddress(request.getParameter("address"));
        user.setQq(request.getParameter("qq"));
        user.setEmail(request.getParameter("email"));

        //调用service完成添加用户操作
        UserService service = new UserService();
        service.addUser(user);

        //跳转页面
        request.getRequestDispatcher("/queryAllUserServlet").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
