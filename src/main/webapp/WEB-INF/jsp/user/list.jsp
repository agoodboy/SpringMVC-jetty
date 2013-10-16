<%--
  Created by IntelliJ IDEA.
  User: 陈志强
  Date: 13-10-16
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <c:forEach items="${users}" var="user">
        ${user.value.name}---${user.value.nikeName}---${user.value.password}---${user.value.email} </br>
    </c:forEach>
</body>
</html>