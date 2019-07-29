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

  <%
    session.getAttribute("updateUser");
  %>

  <title>更新信息</title>
</head>
<body>
<div align="right" style="margin: 0px 10px 0px 0px">${adminUser.name}，欢迎您</div>
<div align="center">
  <p style="color: rgb(51,122,183);font-size:33px">修改用户信息</p>
</div>
<div class="container">
  <div class="row">
    <form action="<%=request.getContextPath()%>/updateServlet" method="post">
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" name="name" class="form-control" id="name" value="${updateUser.name}">
      </div>
      <div class="form-group">
        <label for="gender">Gender</label>
        <select name="gender" class="form-control" id="gender">
          <c:if test="${updateUser.gender == '男'}">
            <option selected="selected" value="男">男</option>
            <option value="女">女</option>
          </c:if>
          <c:if test="${updateUser.gender == '女'}">
            <option value="男">男</option>
            <option selected="selected" value="女">女</option>
          </c:if>
        </select>
      </div>
      <div class="form-group">
        <label for="age">Age</label>
        <input type="text" name="age" class="form-control" id="age" value="${updateUser.age}">
      </div>
      <div class="form-group">
        <label for="address">Address</label>
        <input type="text" name="address" class="form-control" id="address" value="${updateUser.address}">
      </div>
      <div class="form-group">
        <label for="qq">QQ</label>
        <input type="text" name="qq" class="form-control" id="qq" value="${updateUser.qq}">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" name="email" class="form-control" id="email" value="${updateUser.email}">
      </div>
      <div class="form-group" style="text-align: center">
        <input class="btn btn-primary" type="submit" value="提交" />
        <input class="btn btn-default" type="reset" value="重置" />
        <a class="btn btn-default" href="${pageContext.request.contextPath}/list.jsp" role="button">返回</a>
      </div>
    </form>
  </div>
</div>
</body>
</html>
