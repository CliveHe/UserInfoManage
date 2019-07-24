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
import java.util.List;

@WebServlet(name = "QueryAllUserServlet",urlPatterns = "/queryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service完成查询全部用户操作
        UserService service = new UserService();
        List<User> userList = service.getUsers();

        //将全部用户List存入session
        HttpSession session = request.getSession();
        session.setAttribute("userList", userList);

        //System.out.println("QueryAll:"+request.getContextPath());
        //response.sendRedirect(request.getContextPath()+"/list.jsp");

        //跳转页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
