<%--MVC：  它规避了JSP与Servlet各自的短板，Servlet只负责业务逻辑而不会通过out.append()动态生成HTML代码；
JSP中也不会充斥着大量的业务代码，这大大提高了代码的可读性和可维护性。--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>欢迎来到主界面！</title>
  <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
<div  class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">请问您需要注册吗？</h3>

  </div>
</div>
<br><br>
<center>
  <form action="/addressList/registerServlet" method="post">
    <table border="1" class="table table-bordered" style="margin: 5%">
      <tr>
        <td>姓名</td>
        <td><input type="text" name="username" class="form-control"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="text" name="userpwd" class="form-control"></td>
      </tr>
      <tr>
        <td>电话</td>
        <td><input type="text" name="userphone" class="form-control"></td>
      </tr>
    </table>
    <br />
    <input type="submit" value="注册" class="btn btn-primary" />
    <button class="btn btn-light">

  <b>已有帐号？角色登录：</b><a href="../../addressList/login.jsp">用户</a>
      <a href="Admlogin.jsp">管理员</a>

    </button>
  </form>
</center>
</body>
</html>