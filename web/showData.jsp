<%--
  Created by IntelliJ IDEA.
  User: redocn-201804
  Date: 2019/3/18
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="tab2" width="100%">
    <tbody>
    <tr>
        <th><input type="checkbox" id="all" onclick="#"/></th>
        <th>序号</th>
        <th>指令名称</th>
        <th>描述</th>
    </tr>
    <c:forEach items="${messageList}" var="message" varStatus="status">
        <tr <c:if test="${status.index % 2!= 0}">style="background-color:#ECF6EE;"</c:if>>
            <td><input type="checkbox" /></td>
            <td>${status.index+1}</td>
            <td>${message.author}</td>
            <td>${message.title}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>