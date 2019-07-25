package cn.cliveh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/7/20
 */

@WebFilter(filterName = "SensitiveWordFilter", urlPatterns = "/*")
public class SensitiveWordFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //动态代理模式，创建代理对象，增强getParameter方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if ("getParameter".equals(method.getName())){
                    //增强返回值功能
                    //获取返回值
                    String value = (String) method.invoke(req, args);

                    if (value != null){
                        for (String str : list) {
                            if (value.contains(str)){
                                //如果有敏感词汇，则替换为***
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }

                    return value;

                }
                return method.invoke(req, args);
            }
        });

        //放行proxyReq
        chain.doFilter(proxyReq, resp);
    }

    /**
     * 敏感词汇List集合
     */
    private List<String> list = new ArrayList<String>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            //获取文件绝对路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词列表.txt");

            //读取文件
            //创建输入缓冲流对象
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            //将文件的每一行数据添加到list中
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(line);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("敏感词汇："+list);

    }

}
