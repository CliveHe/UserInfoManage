package cn.cliveh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 登录验证的过滤器
 * @author CliveH
 * @date 2019/07/19
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //设置请求与响应的字符解码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取资源请求路径
        String uri = request.getRequestURI();

        //判断是否包括登录相关的URI
        if (uri.contains("/index.jsp")
                || uri.contains("/login.jsp")
                || uri.contains("/loginServlet")
                || uri.contains("/css/")
                || uri.contains("/fonts/")
                || uri.contains("/js/"))
        {
            //登录操作，放行
            chain.doFilter(req, resp);
        }else {
            //不包含，验证是否已经登录
            //从session中获取user
            Object adminUser = request.getSession().getAttribute("adminUser");
            if (adminUser != null){
                //已登录，放行
                chain.doFilter(req, resp);
            }else {
                //没有登录，跳转到登录页面
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
