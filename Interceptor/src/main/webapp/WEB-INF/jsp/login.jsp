<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<div style="width:200px;height:150px;margin:0 auto;border:1px solid;">
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input name="name" type="text"><br/>
        密码：<input name="password" type="password"><br/>
        <br/>
        <hr>
        <input type="submit" name="Submit" value="登陆">
        <input type="reset" name="Reset" value="重置">
    </form>
</div>

</body>
</html>