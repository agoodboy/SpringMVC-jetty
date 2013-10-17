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
<a href="add">添加用户</a>—》<strong>${loginUser.nikeName}</strong>已登录  ==${redir}     <br>
    <c:forEach items="${users}" var="user">
       <a href="${user.value.name}">${user.value.name}</a>---${user.value.nikeName}---${user.value.password}---${user.value.email}
        <a href="${user.value.name}/update">修改</a>
        <a href="${user.value.name}/delete">删除</a>
        </br>
    </c:forEach>
</body>
</html>