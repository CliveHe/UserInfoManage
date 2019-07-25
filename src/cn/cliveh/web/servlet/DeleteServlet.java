package cn.cliveh.web.servlet;

import cn.cliveh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户信息
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/15
 */
@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的用户id
        String id = request.getParameter("id");

        ////调用service完成删除操作
        UserServiceImpl service = new UserServiceImpl();
        service.deleteUser(id);

        //跳转页面
        request.getRequestDispatcher("/queryAllUserServlet").forward(request, response);

        //response.sendRedirect("new.jsp");//重定向到new.jsp
        //response.sendRedirect(request.getContextPath()+"/UserInforManage_war_exploded/queryAllUserServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
