<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>登陆</title>
<body>
<div style= "width:200px;height:150px;margin:0 auto;border:1px solid;">
    <form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="user">
        用户名：<form:input path="username"/><br/>
        密码： <form:input path="password"/><br/>
        <br/>
        <hr>
        <input type="submit" name="Submit" value="登录">
        <input type="reset" name="Submit2" value="重填">
    </form:form>
</div>
</body>
</html>