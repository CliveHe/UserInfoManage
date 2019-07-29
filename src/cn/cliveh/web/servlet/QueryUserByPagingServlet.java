package cn.cliveh.web.servlet; /**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/27
 */

import cn.cliveh.domain.Paging;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;
import cn.cliveh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author CliveH
 * @date 2019/7/27
 */
@WebServlet(name = "QueryUserByPagingServlet", urlPatterns = "/queryUserByPagingServlet")
public class QueryUserByPagingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前页码
        String currentPage = request.getParameter("currentPage");
        //获取每页需要显示的行数
        String rows = request.getParameter("rows");
        //获取模糊查询的条件
        Map<String, String[]> condition = request.getParameterMap();

        //处理currentPage,rows参数为空时的情况
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "6";
        }

        //如果获取的当前页页码小于第一页的页码
        if (Integer.parseInt(currentPage) < 1){
            currentPage = "1";
        }

        UserService service = new UserServiceImpl();
        //调用UserService中的查询最后一页页码的方法
        int endPage = service.getEndPage();
        //如果获取的当前页页码大于实际的最后页码
        if (Integer.parseInt(currentPage) > endPage){
            currentPage = endPage+"";
        }

        //调用UserService中的分页模糊查询方法
        Paging<User> userByPage = service.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),condition);

        HttpSession session = request.getSession();
        //将分页查询的用户分页List列表存入session
        session.setAttribute("userByPage", userByPage);
        //将模糊查询的条件Map集合存入session
        session.setAttribute("condition",condition);

        //跳转页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
