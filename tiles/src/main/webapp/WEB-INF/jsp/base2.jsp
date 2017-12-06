<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: yubotao
  Date: 2017/12/06
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<tiles:insertAttribute name="header"/>
<hr>
<tiles:insertAttribute name="menu"/>

<tiles:insertAttribute name="body"/>
<hr>
<tiles:insertAttribute name="footer"/>
</body>
</html>
