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
      //request.getAttribute("user");
      session.getAttribute("user");
    %>

    <title>添加用户</title>
  </head>
  <body>
    <div align="right" style="margin: 0px 10px 0px 0px">${adminUser.name}，欢迎您</div>
    <div align="center">
      <p style="color: rgb(51,122,183);font-size:33px">添加用户信息</p>
    </div>
  <div class="container">
    <div class="row">
      <form action="<%=request.getContextPath()%>/addUserServlet" method="post">
          <div class="form-group">
              <label for="name">Name</label>
              <input type="text" name="name" class="form-control" id="name" placeholder="Name">
          </div>
          <div class="form-group">
              <label for="gender">Gender</label>
              <select name="gender" class="form-control" id="gender">
                  <option selected="selected" value="男">男</option>
                  <option value="女">女</option>
              </select>
          </div>
          <div class="form-group">
              <label for="age">Age</label>
              <input type="text" name="age" class="form-control" id="age" placeholder="Age">
          </div>
          <div class="form-group">
              <label for="address">Address</label>
              <input type="text" name="address" class="form-control" id="address" placeholder="Address">
          </div>
          <div class="form-group">
              <label for="qq">QQ</label>
              <input type="text" name="qq" class="form-control" id="qq" placeholder="QQ">
          </div>
          <div class="form-group">
              <label for="email">Email</label>
              <input type="email" name="email" class="form-control" id="email" placeholder="Email">
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">添加</button>
      </form>
    </div>
  </div>
  </body>
</html>
