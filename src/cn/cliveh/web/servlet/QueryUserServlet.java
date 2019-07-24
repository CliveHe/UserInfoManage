package cn.cliveh.web.servlet;

import cn.cliveh.dao.impl.UserDaoImpl;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QueryUserServlet", urlPatterns = "/queryUserServlet")
public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取要查询的id
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        //将要修改的用户id存入session
        session.setAttribute("updateID",id);

        ////调用service完成获取用户信息操作
        UserService service = new UserService();
        User updateUser = service.getUser(id);

        //将查询出来的updateUser传递给update.jsp
        request.setAttribute("updateUser", updateUser);
        //跳转页面
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
