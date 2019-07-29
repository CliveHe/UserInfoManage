<%@ page import="cn.cliveh.domain.Paging" %>
<%@ page import="cn.cliveh.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

    <script>

      //保证下边的选中状态和第一个复选框的选中状态一致
      function selectAll(obj) {
        //获取下边的复选框，然后设置选中状态和this一样
        $(".itemSelect").prop("checked",obj.checked);
        //使“删除选中”按钮起作用
        if ($(".itemSelect:checked").length > 0) {
          $("#del_select_btn").removeAttr("disabled");
        }else {
          $("#del_select_btn").attr("disabled","disabled");
        }
      }

      $(function () {

        $(".itemSelect").click(function () {
          //判断当前选中的元素是否和页面显示的记录条数一致
          var flag = ($(".itemSelect:checked").length === $(".itemSelect").length);
          //如果一致则全部选中了,flag为true,表头的checkbox也要变成选中
          $("#selectAll").prop("checked",flag);

          //使“删除选中”按钮起作用
          if ($(".itemSelect:checked").length > 0) {
            $("#del_select_btn").removeAttr("disabled");
          }else {
            $("#del_select_btn").attr("disabled","disabled");
          }
        });

        $("#del_select_btn").click(function () {
          var id = "";
          var name = "";
          //遍历被选中的元素,然后把id取出来
          $.each($(".itemSelect:checked"),function () {
            id += $(this).parents("tr").find("td:eq(1)").text()+"&";
            name += $(this).parents("tr").find("td:eq(2)").text()+"，";
          });

          //去除name字符串中后面多余的'，'
          id = id.substring(0,id.length-1);
          //去除id字符串中后面多余的'&'
          name = name.substring(0,name.length-1);
          //确认删除
          if (confirm("确认删除这"+$(".itemSelect:checked").length+"个用户：“"+name+"” "+"吗？")){
            //发送ajax请求删除
            $.get("deleteServlet",{id:id},function () {
              //获取当前页面页码
              var url = document.URL;
              var strings = url.split("/");
              var url1 = strings[4].split("&");
              var url2 = url1[0];
              var url3 = url2.split("=");
              var currentPage = url3[1];

              //跳转到查询页面
              window.location.href = "${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage="+currentPage+"&rows=6";
            })

          }
        })

        //http://localhost:8080/UserInfoManage_war_exploded/queryUserByPagingServlet?currentPage=3&rows=6
        var url = document.URL;
        var strings = url.split("/");
        var url1 = strings[4].split("&");
        var url2 = url1[0];
        var url3 = url2.split("=");
        var currentPage = url3[1];

        //单击修改的<a>的时候获取href并且让href增加一个currentPage参数
        $("a[name='update_btn']").click(function () {
          $(this).attr("href",$(this).attr("href")+"&currentPage="+currentPage);
        })

        //单击删除的<a>的时候获取href并且让href增加一个currentPage参数
        $("a[name='delete_btn']").click(function () {
          $(this).attr("href",$(this).attr("href")+"&currentPage="+currentPage);
        })

      })

    </script>

    <style>
      td,th{
        text-align: center;
      }
    </style>


    <title>用户信息管理系统</title>
  </head>
  <body>
    <div align="right" style="margin: 0px 10px 0px 0px">${adminUser.name}，欢迎您</div>
    <div align="center" style="margin-bottom: 50px">
      <a href="${pageContext.request.contextPath}/queryUserByPagingServlet" style="text-decoration:none;font-size:33px">用户信息列表</a>
    </div>

  <div class="container">

    <div style="float: left;margin-bottom: 5px">
      <form class="form-inline" action="${pageContext.request.contextPath}/queryUserByPagingServlet">
        <div class="form-group">
          <label for="exampleInputName2">姓名</label>
          <input type="text" name="name" class="form-control" id="exampleInputName2">
        </div>
        <div class="form-group">
          <label for="exampleInputName3">地址</label>
          <input type="text" name="address" class="form-control" id="exampleInputName3">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail2">邮箱</label>
          <input type="text" name="email" class="form-control" id="exampleInputEmail2">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
      </form>
    </div>

    <div style="float: right;margin-bottom: 5px;">
      <a href="${pageContext.request.contextPath}/addUser.jsp" class="btn btn-primary" role="button">添加联系人</a>
      <input id="del_select_btn" name="delete_select_btn" class="btn btn-primary" disabled="disabled" type="button" value="删除选中">
    </div>

    <table class="table table-striped table-bordered table-hover text-center">
      <tr style="background-color: rgb(222,241,214)">
        <th><input id="selectAll" type="checkbox" onclick="selectAll(this)"></th>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>地址</th>
        <th>QQ</th>
        <th>Email</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${userByPage.list}" var="user">
        <tr>
          <td><input type="checkbox" class="itemSelect" name="checkbox"></td>
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.gender}</td>
          <td>${user.age}</td>
          <td>${user.address}</td>
          <td>${user.qq}</td>
          <td>${user.email}</td>
          <td><a name="update_btn" class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/queryUserServlet?id=${user.id}">修改</a>&nbsp;<a name="delete_btn" class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}" onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
        </tr>
      </c:forEach>
    </table>

    <div>
      <nav aria-label="Page navigation">
        <ul class="pagination">
        <c:if test="${userByPage.currentPage  <= 1}">
          <li class="disabled">
              <a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${userByPage.currentPage - 1}&rows=6" aria-label="Previous" class="disabled">
                  <span aria-hidden="true">&laquo;</span>
              </a>
          </li>
        </c:if>
        <c:if test="${userByPage.currentPage > 1}">
          <li>
              <a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${userByPage.currentPage - 1}&rows=6" aria-label="Previous" class="disabled">
                  <span aria-hidden="true">&laquo;</span>
              </a>
          </li>
        </c:if>

          <c:forEach var="index" begin="1" end="${userByPage.totalPage}">
            <c:if test="${userByPage.currentPage == index}">
              <li class="active"><a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${index}&rows=6">${index}</a></li>
            </c:if>
            <c:if test="${userByPage.currentPage != index}">
              <li><a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${index}&rows=6">${index}</a></li>
            </c:if>
          </c:forEach>
          <c:if test="${userByPage.currentPage >= userByPage.totalPage}">
              <li class="disabled">
                  <a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${userByPage.currentPage + 1}&rows=6" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                  </a>
              </li>
          </c:if>
          <c:if test="${userByPage.currentPage < userByPage.totalPage}">
              <li>
                  <a href="${pageContext.request.contextPath}/queryUserByPagingServlet?currentPage=${userByPage.currentPage + 1}&rows=6" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                  </a>
              </li>
          </c:if>
          <span style="font-size: 25px; margin-left: 5px">共${userByPage.totalCount}条记录，共${userByPage.totalPage}页</span>
        </ul>
      </nav>
    </div>

  </div>
  </body>
</html>
