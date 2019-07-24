<%--
  Created by IntelliJ IDEA.
  User: CliveH
  Date: 2019/7/13
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <%
      request.getRequestDispatcher("/login.jsp").forward(request, response);
    %>

    <title>登录</title>
  </head>
  <body>
    <%--<div align="right" style="margin: 0px 10px 0px 0px">${user.name}，欢迎您</div>
    <div align="center">
      <a href="${pageContext.request.contextPath}/queryAllUserServlet" style="text-decoration:none;font-size:33px">查询所有用户信息</a>
    </div>--%>
  </body>
</html>
