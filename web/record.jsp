<%--
  Created by IntelliJ IDEA.
  User: lxj716
  Date: 2020/12/16
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
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
  <script>
    function loadXMLDoc1()
    {

      var xhr;
      if (window.XMLHttpRequest)
      {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xhr=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
      }
      xhr.onreadystatechange=function()
      {
        if (xhr.readyState==4 && xhr.status==200)
        {
          console.log(xhr.responseText);
          // document.getElementById("myDiv").innerHTML=xhr.responseText;
        }
      }
      xhr.open("DELETE", "http://localhost:8080/minio/delete?name=84b273fb93e74232810906eecd28931d.JPG");
      xhr.send();

    }
    function upload()
    {
      var data = new FormData();
      data.append("file", $("#pic")[0].files[0]);
      var url;
      $.ajax({
        type: "POST",
        url: "http://localhost:8080/minio/upload",
        data: data,
        async: false,
        contentType: false,
        processData: false,
        success: function (res) {
          var textId=$("#myTxt");
          textId.val(res)
          url=res;
        },
        error: function (res) {
          var textId=$("#myTxt");
          textId.val(res)
          url=res;
        }
      });
      return url;
    }
  </script>
  <title>成功</title>
</head>

<body style="margin-left: 0;">

  <ul>
    <li><a href="index.jsp">主页</a></li>
    <li><a href="survey.jsp">创建SURVEY</a></li>
    <li><a href="DoSurveyCheck">浏览SURVEY</a> </li>
    <li style="float: right"><a href="">关于</a></li>
  </ul>

  <div style="float:top;padding-top: 30px;background-color: aliceblue">
    <form action="DoRecordAdd" method="post" name="formrecord">

      <p style="color: cadetblue;
  font-family:Verdana;
  font-size: 20px;
  text-align: center">

        本次调查编号：<input type="text"
                      name="surveyid"
                      readonly="readonly"
                      value="${surveyid}"/><br/>

        鸟类名称: <input type="text"
                   placeholder="名称"
                   name="birdname"/><br/>

        数目: <input type="text"
                   placeholder="数目"
                   name="birdnumber"/><br/>
        上传图片的url：<input type="text"
                        id="myTxt"
                        value=""
                        name="birdpictureurl"/><br/><br/>

        <input style="color: cadetblue;"
               type="submit"
               value="添加">
        <input style="color: cadetblue;margin-left: 20px"
               type="reset"
               value="重置">
      </p>
    </form>
    <div style="float:top;padding-top: 30px;background-color: aliceblue">
    <form method="POST"  id="uploadForm" enctype="multipart/form-data">
      <input type="file" id="pic" name="file">
    </form>
    <button type="button" id="btn" onclick="upload()">上传</button>
    </div>

  </div>

</body>
</html>
