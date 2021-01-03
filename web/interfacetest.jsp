<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>

    <meta charset="utf-8">
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
        function loadXMLDoc2()
        {
            var data = new FormData();
            data.append("file", $("#pic")[0].files[0]);

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/minio/upload",
                data: data,
                async: false,
                contentType: false,
                processData: false,
                success: function (res) {
                    document.getElementById("myDiv").innerText="success";
                    return "success";
                },
                error: function (res) {
                    document.getElementById("myDiv").innerText="false";
                    return "false"
                }
            })

        }
    </script>
</head>
<body>
<div>
    <form method="POST"  id="uploadForm" enctype="multipart/form-data">
        <input type="file" id="pic" name="file">
    </form>
    <button type="button" id="btn" onclick="loadXMLDoc2()">上传</button>

</div>
<h2>AJAX</h2>
<button type="button" onclick="loadXMLDoc1()">删除图片</button>
<div id="myDiv"></div>

</body>
</html>