<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <style>
      td,th{
        text-align: center;
      }
    </style>

    <%
      session.getAttribute("user");
    %>

    <title>用户管理</title>
  </head>
  <body>
    <div align="right" style="margin: 0px 10px 0px 0px">${adminUser.name}，欢迎您</div>
    <div align="center">
      <a href="${pageContext.request.contextPath}/queryAllUserServlet" style="text-decoration:none;font-size:33px">查询所有用户信息</a>
    </div>

  <div class="container">
    <div class="row">
      <table class="table table-striped table-bordered table-hover text-center">
        <tr>
          <th>ID</th>
          <th>姓名</th>
          <th>性别</th>
          <th>年龄</th>
          <th>地址</th>
          <th>QQ</th>
          <th>Email</th>
          <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="user">
          <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a href="${pageContext.request.contextPath}/queryUserServlet?id=${user.id}">修改</a>|<a href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>

    <div style="text-align:center">
      <a href="${pageContext.request.contextPath}/addUser.jsp" class="btn btn-primary btn-lg active" role="button">添加用户</a>
    </div>

  </div>
  </body>
</html>
