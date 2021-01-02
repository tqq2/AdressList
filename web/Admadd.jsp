<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2020/12/31
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<div  class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">添加一名用户</h3>

    </div>
</div>
<br><br>
<center>
    <form action="/addressList/AdmaddServlet" method="post">
        <table border="1" class="table table-bordered" style="margin: 5%">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="addname" class="form-control"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="addpwd" class="form-control"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="addphone" class="form-control"></td>
            </tr>
        </table>
        <br />
        <input type="submit" value="保存" class="btn btn-primary" />
        <button class="btn btn-light">
            <a href="userslist.jsp" >返回</a>
        </button>
    </form>
</center>
</body>
</html>
