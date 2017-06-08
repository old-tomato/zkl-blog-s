<%--
  Created by IntelliJ IDEA.
  User: 52426
  Date: 2017/5/27
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1 class="test">欢迎！</h1>

<form action="/login/checkInfo" method="post">
    用户名：<input type="text" name="username">
    <br>
    密码：<input type="password" name="password">
    <br>
    <input type="submit" value="登陆">
</form>
<br>
</body>
</html>
