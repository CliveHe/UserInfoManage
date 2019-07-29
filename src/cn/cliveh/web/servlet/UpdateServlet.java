package cn.cliveh.web.servlet;

import cn.cliveh.domain.User;
import cn.cliveh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 更新用户信息
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/15
 */
@WebServlet(name = "UpdateServlet", urlPatterns = "/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");

        //获取session里的updateID，用来进行更新操作
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("updateID");

        //获取修改页面输入的用户信息并封装数据
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(request.getParameter("name"));
        user.setGender(request.getParameter("gender"));
        //将String型的age转换为int型，转换时判断age是否为空
        user.setAge(request.getParameter("age") != null && !"".equals(request.getParameter("age")) ? Integer.parseInt(request.getParameter("age")) : null);
        user.setAddress(request.getParameter("address"));
        user.setQq(request.getParameter("qq"));
        user.setEmail(request.getParameter("email"));

        ////调用service完成修改操作
        UserServiceImpl service = new UserServiceImpl();
        service.updateUser(user);

        //获取session记忆的修改时的页面
        String updateCurrentPage = (String) session.getAttribute("updateCurrentPage");

        //跳转页面
        request.getRequestDispatcher("/queryUserByPagingServlet?currentPage="+updateCurrentPage+"&rows=6").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
