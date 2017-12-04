<%--
  Created by IntelliJ IDEA.
  User: yubotao
  Date: 2017/12/03
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style= "width:200px;height:150px;margin:0 auto;border:1px solid;">
    <form action="${pageContext.request.contextPath}/a/login" method="post">
        用户名：<input name="name" type="text"/><br/>
        密码： <input name="password" type="password"/><br/>
        <br/>
        <hr>
        <input type="submit" name="Submit" value="登录">
        <input type="reset" name="Submit2" value="重填">

    </form>
</div>
</body>
</html>
