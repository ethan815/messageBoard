<%--
  Created by IntelliJ IDEA.
  User: redocn-201804
  Date: 2019/2/21
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>servlet2</title>
</head>
<body>
<!--
    1.完整路径：localhost:8080/servlet2/reg
    2.绝对路径：格式：/项目名/网名 实例：/srevlet2/reg
    3.相对路径（*）：只需写出目标和当前页面的相对位置
    当前页面：/servlet2/register.html
    访问目标：/servlet2/reg
    二者是平级关系，相对路径是reg，不能以/开头
-->
<form action="reg" method="host">
    <p>
        账号：<input type="text" name="userName">
    </p>
    <p>
        密码：<input type="password" name="passWord">
    </p>
    <p>
        性别：
        <input type="radio" name="sex" value="M">男
        <input type="radio" name="sex" value="F">女
    </p>
    <p>
        兴趣：
        <input type="checkbox" name="interest" value="sport">运动
        <input type="checkbox" name="interest" value="music">音乐
        <input type="checkbox" name="interest" value="movie">电影
    </p>
    <p>
        <input type="submit" value="注册">
    </p>
</form>
</body>
</html>
