<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/25/2018
  Time: 03:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#getUser").click(function() {
                var url = this.href;
                var para = {};
                $.post(url, para, function(data) {
                    for(var i = 0; i < data.length; i++) {
                        var id = data[i].id;
                        var name = data[i].username;
                        var age = data[i].age;
                        alert(id + name + age);
                    }
                })
            })
        })
    </script>
</head>
<body>

    <a href="hello">Hello World!!!</a>
    <br><br>

    <a href="testModelAndView">testModelAndView</a>
    <br><br>

    <a href="testMap">testMap</a>
    <br><br>

    <a href="testBeanNameView">testBeanNameView</a>
    <br><br>

    <form action="testModelAttribute" method="post">
        <input type="hidden" name="id" value="1" />
        用户名： <input type="text" name="username" />
        <br>
        年龄： <input type="text" name="age" />
        <br>
        <input type="submit" value="提交" />
    </form>
    <br><br>

    <a href="getUsers" id="getUser">getUsers for Json</a>
    <br><br>

    <form action="uploadfile" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="text" name="desc">
        <input type="submit" value="提交">
    </form>
    <br><br>

    <a href="downloadfile">文件下载</a>
    <br><br>

    <a href="i18n.jsp">文件下载</a>
    <br><br>

    <%--springmvc文件上传--%>
    <form action="fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="text" name="desc" />
        <input type="submit" value="提交" />
    </form>
    <br><br>

</body>
</html>
