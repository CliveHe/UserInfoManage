package cn.cliveh.web.servlet;

import cn.cliveh.domain.Admin;
import cn.cliveh.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登录
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/15
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取登录页面输入的用户名和密码
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service获取数据库中查询的User对象
        LoginServiceImpl service = new LoginServiceImpl();
        Admin adminUser = service.login(name, password);

        HttpSession session = request.getSession();

        if(adminUser != null){
            //将用户存入session
            session.setAttribute("adminUser",adminUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/queryAllUserServlet");
        }else {
            //提示登录错误信息
            request.setAttribute("loginError", "loginError");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
