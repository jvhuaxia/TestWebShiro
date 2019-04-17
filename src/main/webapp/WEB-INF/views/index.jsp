<%--
  Created by IntelliJ IDEA.
  User: JvHuaxia
  Date: 2019/4/2
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Index</h1>
<shiro:principal/>

<a href="${pageContext.request.contextPath}/product/view/1">Product View</a>
</body>
</html>
