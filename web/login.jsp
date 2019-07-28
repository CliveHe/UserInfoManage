<%--
  Created by IntelliJ IDEA.
  User: CliveH
  Date: 2019/7/14
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
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

    <script src="js/jquery.cookie.js"></script>

    <style>
        .login{
            width: 400px;

        }

        .company{
            height: 40px;/*高度*/
            background-color: rgb(51,122,183);/*背景颜色*/
            text-align: center;/*水平居中*/
            line-height:40px ;/*竖直居中*/
            font-size: 8px;
        }

        .label-color{
            color: rgb(51,122,183)
        }
    </style >


    <script>
        window.onload = function () {
            //表单提交绑定onsubmit事件
            document.getElementById("form").onsubmit = function () {
                //调用用户名校验方法
                //调用密码校验方法
                return checkUsername() && checkPassword();
            };

            //登录失败提示信息
            var loginError = "<%=request.getAttribute("loginError")%>";
            if (loginError === "loginError") {
                alert("账号或密码错误！");
            }

            //获取登录页面的url
            var getUrl = function (){
                var url = document.URL.toString();
                var arrUrl = url.split("/");
                var urlStr = arrUrl[0]+"//"+arrUrl[2]+"/"+arrUrl[3]+"/";
                return urlStr;
            }
            //浏览器网址框的url
            var urlBox = document.URL;
            //弹出未登录警告
            var login_msg = "<%=request.getAttribute("login_msg")%>";
            if (login_msg !== "null" &&(urlBox !== getUrl())) {    //登录页面不弹出未登录警告
                alert(login_msg);
            }


            //onblur校验
            document.getElementById("username").onblur = checkUsername;
            document.getElementById("password").onblur = checkPassword;

            //校验用户名
            function checkUsername() {
                //获取用户名
                var username = document.getElementById("username").value;
                //定义正则表达式
                var reg_username = /^\w{6,12}$/;
                //判断
                var flag = reg_username.test(username);

                //
                var inputUsername = document.getElementById("inputUsername");
                if (flag) {
                    inputUsername.innerHTML = "<div class=\"form-group has-success has-feedback\">\n" +
                        "  <label class=\"control-label\" for=\"inputSuccess2\">输入成功</label>\n" +
                        "  <input type=\"text\" value='"+username+"' class=\"form-control\" id=\"username\" name='username' aria-describedby=\"inputSuccess2Status\">\n" +
                        "  <span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "  <span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>\n" +
                        "</div>";

                    document.getElementById("username").onblur = checkUsername;
                }else if (username !== '') {    //若输入框为空，则不提示输入错误
                    inputUsername.innerHTML = "<div class=\"form-group has-error has-feedback\">\n" +
                        "  <label class=\"control-label\" for=\"inputError2\">格式错误</label>\n" +
                        "  <input type=\"text\" value='"+username+"' placeholder=\"请输入6-12位数字或字母\" class=\"form-control\" id=\"username\" aria-describedby=\"inputError2Status\">\n" +
                        "  <span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "  <span id=\"inputError2Status\" class=\"sr-only\">(error)</span>\n" +
                        "</div>";

                    document.getElementById("username").onblur = checkUsername;
                }

                return flag;
            }

            //校验密码
            function checkPassword() {
                //获取密码
                var password = document.getElementById("password").value;
                //定义正则表达式
                var reg_password = /^\w{6,12}$/;
                //判断
                var flag = reg_password.test(password);

                //
                var inputPassword = document.getElementById("inputPassword")
                if (flag) {
                    inputPassword.innerHTML = "<div class=\"form-group has-success has-feedback\">\n" +
                        "  <label class=\"control-label\" for=\"inputSuccess2\">输入成功</label>\n" +
                        "  <input type=\"password\" value='"+password+"' class=\"form-control\" id=\"password\" name='password' aria-describedby=\"inputSuccess2Status\">\n" +
                        "  <span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "  <span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>\n" +
                        "</div>";

                    document.getElementById("password").onblur = checkPassword;
                }else if (password !== '') {    //若输入框为空，则不提示输入错误
                    inputPassword.innerHTML = "<div class=\"form-group has-error has-feedback\">\n" +
                        "  <label class=\"control-label\" for=\"inputError2\">格式错误</label>\n" +
                        "  <input type=\"password\" value='"+password+"' placeholder=\"请输入6-12位数字或字母\" class=\"form-control\" id=\"password\" aria-describedby=\"inputError2Status\">\n" +
                        "  <span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>\n" +
                        "  <span id=\"inputError2Status\" class=\"sr-only\">(error)</span>\n" +
                        "</div>";

                    document.getElementById("password").onblur = checkPassword;
                }

                return flag;
            }


            //添加cookie
            var addCookie = function (name, value, time) {
                var strSec = getSec(time);
                var exp = new Date();
                exp.setTime(exp.getTime() + strSec * 1);
                //设置cookie的名称、值、失效时间
                document.cookie = name + "=" + value + ";expires="+ exp.toGMTString();
                //alert("添加"+name+"_Cookie成功");
            };

            //获取cookie
            var getCookie = function (name) {
                //获取当前所有cookie
                var strCookies = document.cookie;
                //截取变成cookie数组
                var array = strCookies.split(';');
                //循环每个cookie
                for (var i = 0; i < array.length; i++) {
                    //去除字符串内左侧的空格
                    array[i] = array[i].replace(/^\s*/,"");

                    //将cookie截取成两部分
                    var item = array[i].split("=");

                    //判断cookie的name 是否相等
                    if (item[0] === name) {
                        return item[1];
                    }
                }
                return null;
            };

            //删除cookie
            var delCookie = function (name) {
                var exp = new Date();
                exp.setTime(exp.getTime() - 1);
                //获取cookie是否存在
                var value = getCookie(name);
                if (value != null) {
                    document.cookie = name + "=" + value + ";expires="+ exp.toUTCString();
                    //alert("删除"+name+"_Cookie成功");
                }
            };

            //获取时间的秒数（参数：d，h,m,s） 12m
            var getSec = function(str){
                var str1 = str.substr(0, str.length - 1);  //时间数值
                var str2 = str.substr(str.length-1, 1);    //时间单位
                if (str2 == "s") {
                    return str1 * 1000;
                }
                else if (str2 == "m") {
                    return str1 * 60 * 1000;
                }
                else if (str2 == "h") {
                    return str1 * 60 * 60 * 1000;
                }
                else if (str2 == "d") {
                    return str1 * 24 * 60 * 60 * 1000;
                }
            };

            var remember_me = document.getElementById("remember_me");
            var username_key = "username_key";
            var password_key ="password_key";
            var remember_me_key = "remember_me_key";

            var flush = true;
            //重新打开页面时，从cookie中判断remember_me的按钮状态
            if (flush === true){
                remember();
            }
            function remember(){
                if (getCookie(remember_me_key) === "true" ){
                    //若cookie中remember_me为true,则初始化checked = true
                    remember_me.checked = true;

                    //获取cookie里的用户和密码
                    var cookie_username = getCookie(username_key);
                    var cookie_password = getCookie(password_key);

                    document.getElementById("inputUsername").innerHTML = "<div id=\"inputUsername\">\n" +
                        "                <label class=\"control-label label-color\" for=\"username\">用户名：</label>\n" +
                        "                <label for=\"username\" class=\"sr-only\">请输入6-12位数字或字母</label>\n" +
                        "                <input type=\"text\" name=\"username\" id=\"username\" value='"+cookie_username+"' class=\"form-control\" placeholder=\"请输入6-12位数字或字母\" required autofocus>\n" +
                        "            </div>";
                    document.getElementById("inputPassword").innerHTML = "<div id=\"inputPassword\">\n" +
                        "                <label class=\"control-label label-color\" for=\"password\">密码：</label>\n" +
                        "                <label for=\"password\" class=\"sr-only\">请输入6-12位数字或字母</label>\n" +
                        "                <input type=\"password\" name=\"password\" id=\"password\" value='"+cookie_password+"' class=\"form-control\" placeholder=\"请输入6-12位数字或字母\" required>\n" +
                        "            </div>";
                }
            }


            //保存用户信息和密码
            remember_me.onclick = function () {
                if (remember_me.checked === true){
                    var username = document.getElementById("username").value;
                    var password = document.getElementById("password").value;

                    //如果cookie中用户名为空，则添加cookie
                    if (getCookie(username_key) === null && username !== null && password !== null) {
                        addCookie(username_key,username,"365d");
                        addCookie(password_key,password,"365d");
                    }

                    //记忆remember_me按钮状态
                    var flag_key = remember_me.checked;
                    //如果cookie为空，则添加cookie
                    if (getCookie(remember_me_key) === null) {
                        addCookie(remember_me_key,flag_key,"365d");
                    }

                }else {
                    delCookie(username_key);
                    delCookie(password_key);
                    delCookie(remember_me_key);

                    document.getElementById("inputUsername").innerHTML = "<div id=\"inputUsername\">\n" +
                        "                <label class=\"control-label label-color\" for=\"username\">用户名：</label>\n" +
                        "                <label for=\"username\" class=\"sr-only\">请输入6-12位数字或字母</label>\n" +
                        "                <input type=\"text\" name=\"username\" id=\"username\" class=\"form-control\" placeholder=\"请输入6-12位数字或字母\" required autofocus>\n" +
                        "                <!--<span id=\"s_username\" class=\"error\"></span>-->\n" +
                        "            </div>";
                    document.getElementById("inputPassword").innerHTML = "<div id=\"inputPassword\">\n" +
                        "                <label class=\"control-label label-color\" for=\"password\">密码：</label>\n" +
                        "                <label for=\"password\" class=\"sr-only\">请输入6-12位数字或字母</label>\n" +
                        "                <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" placeholder=\"请输入6-12位数字或字母\" required>\n" +
                        "            </div>";

                }
            };

        };

        //刷新验证码
        function refreshCode () {
            var img = document.getElementById("vcode");
            img.onclick = function () {
                //时间戳，返回的是毫秒数
                var time = new Date().getTime();
                //使用变化的毫秒值使src链接不固定，不然链接不改变浏览器不会刷新此链接
                img.src = "${pageContext.request.contextPath}/checkCodeServlet?"+time;
            }
        }
    </script>

    <title>登录</title>
</head>
<body>

<!--登录框-->
<div class="container">
    <br>
    <h1 class="text-center" style="color: rgb(51,122,183)">用户信息管理系统</h1>
    <br><br>

    <div class="col-md-offset-3 col-md-6">
        <form id="form" class="form-signin" action="${pageContext.request.contextPath}/loginServlet" method="post">
            <h2 class="form-signin-heading" style="color: rgb(51,122,183)">请登录</h2>
            <br>
            <div id="inputUsername">
                <label class="control-label label-color" for="username">用户名：</label>
                <label for="username" class="sr-only">请输入6-12位数字或字母</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="请输入6-12位数字或字母" required autofocus>
                <!--<span id="s_username" class="error"></span>-->
            </div>
            <br>
            <div id="inputPassword">
                <label class="control-label label-color" for="password">密码：</label>
                <label for="password" class="sr-only">请输入6-12位数字或字母</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="请输入6-12位数字或字母" required>
            </div>
            <br>
            <div class="form-inline">
                <label class="control-label label-color" for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" autocomplete="off" style="width: 120px;"/>
                <a href="javascript:void(0);" onclick="refreshCode()">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
                </a>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" id="remember_me" value="remember-me"> 记住我
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
    </div>

</div> <!-- /container -->

</body>

<footer class="navbar-fixed-bottom">
    <div class="row company ">
        ©何智强 版权所有
    </div>
</footer>

</html>
