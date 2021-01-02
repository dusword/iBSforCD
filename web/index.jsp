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
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
  function beforeSubmit(form){
    if(form.username.value==''){
      alert('用户名不能为空！');
      form.username.focus();
      location.href='index.jsp'
      return false;
    }
    if(form.password.value==''){
      alert('密码不能为空！');
      form.password.focus();
      location.href='index.jsp'
      return false;
    }
    if(form.password.value.length<6){
      alert('密码至少为6位，请重新输入！');
      form.password.focus();
      location.href='index.jsp'
      return false;
    }

    return true;
  }
</script>

<head>
  <meta charset="utf-8" name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
  <title>注册界面</title>
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
</head>

<body style="margin-left: 0">



  <ul>
    <li><a class="active" href="index.jsp">主页</a></li>
    <li><a href="failed.jsp">失败</a></li>
    <li><a href="DoUserSelect">成功</a></li>
    <li style="float: right"><a href="">关于</a></li>
  </ul>


<div style="float:top;padding-top: 30px;background-color: aliceblue">
<form action="" method="post" name="formindex" onsubmit="return beforeSubmit(this)">

  <p style="color: cadetblue;
  font-family:Verdana;
  font-size: 20px;
  text-align: center">

    账号: <input type="text"
               placeholder="用户名"
               name="username"/><br/>

    密码: <input type="password"
               placeholder="密码"
               name="password"/><br/><br/>

    <input style="color: cadetblue;"
           type="submit"
           onclick="formindex.action='DoUserLogin';formindex.submit();"
           value="登录">
    <input style="color: cadetblue;margin-left: 20px"
           type="reset"
           value="重置">
    <input style="color: cadetblue;margin-left: 20px"
           type="submit"
           onclick="formindex.action='DoUserAdd';formindex.submit();"
           value="注册">
  </p>

  <p style="text-align: center">
    <img src="image/16919569A3EB225ED04743A54311DB4E.png"
         alt="picture"
         width="400"
         height="300" />
  </p>

</form>
</div>

</body>
</html>
