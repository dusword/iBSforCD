<%--
  Created by IntelliJ IDEA.
  User: lxj716
  Date: 2020/12/16
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  <style>
    ul {
      position: fixed;
      top: 0;
      width: 100%;
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #555555;
    }

    li {
      float: left;
    }

    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }

    li a:hover {
      background-color: #111;
    }
  </style>
  <title>成功</title>
</head>

<body style="margin-left: 0;">

  <ul>
    <li><a href="index.jsp">主页</a></li>
    <li><a class="active" href="failed.jsp">失败</a></li>
    <li><a href="">成功</a></li>
    <li style="float: right"><a href="">关于</a></li>
  </ul>


<div style="margin-top: 60px" >
<div style="color: green;text-align: center;background-color: aliceblue;width: 100%;float: top">
  成功
</div>

<div  style=" padding-left: 30px;float: top">
  <table >
    <tr >
      <th style="padding-left: 20px">唯一ID</th>
      <th style="padding-left: 20px">账户</th>
      <th style="padding-left: 20px">密码</th>
    </tr>

    <c:forEach items="${userlist}" var="user">
      <tr>
        <td style="padding-left: 20px">${user.USER_ID}</td>
        <td style="padding-left: 20px">${user.USER_NAME}</td>
        <td style="padding-left: 20px">${user.USER_PASSWORD}</td>
      </tr>
    </c:forEach>
  </table>

</div>
</div>
</body>
</html>
