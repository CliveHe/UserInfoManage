package cn.cliveh.web.servlet;

import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;
import cn.cliveh.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CliveH
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取登录页面输入的用户名和密码
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service完成登录操作
        LoginService service = new LoginService();
        User user = service.login(name, password);

        HttpSession session = request.getSession();

        if(user != null){
            //将用户存入session
            session.setAttribute("user",user);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/queryAllUserServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
