<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2020/12/31
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList, java.sql.ResultSet"%>
<%--导入JSTL的core标签库，让JSP找到标签库的描述文件--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    ArrayList users = (ArrayList) session.getAttribute("users");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理用户界面</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <%--省了写代码的时间，写好自己的HTML，jsp然后调用类名就可以了--%>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">用户列表</h1>

    </div>
</div>
<form action="/addressList/AdmselectServlet" method="post">
    <div class="row justify-content-center">
        <a href="index.jsp" class="btn btn-outline-secondary" style="margin-right: 24px;
">退出</a>
        <div class="form-inline row">
            <select name="selectbox" class="custom-select mr-sm-2">
                <option>用户名</option>
                <option>电话号码</option>
            </select>
            <input type="text" name="search" class="form-control"
                   style="width: 50%"></input>
            <button name="cheakSearch" class="btn btn-primary"
                    style="margin-left: 2%">查询</button>


        </div>
    </div>
</form>
<div class="row justify-content-center">
    <table border="" width="50%" style="margin: 2%" class="table table-bordered">
        <tr>
            <th scope="col">序号</th>
            <th scope="col">用户名</th>
            <th scope="col">密码</th>
            <th scope="col">电话2</th>
            <th scope="col"><a href="Admadd.jsp" class="btn btn-primary">添加</a>
            </th>

        </tr>
        <%--  遍历显示数据库信息(EL和JSTL表达式)，省去了用脚本的代码量--%>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.user_id}" /></td>
                <td><c:out value="${user.user_account}" /></td>
                <td><c:out value="${user.user_password}" /></td>
                <td><c:out value="${user.phone1}" /></td>
                <td><a href="Admupdate.jsp?id=<c:out value="${user.user_id}"/> " class="btn btn-info">编辑</a>
                    <a class="btn btn-danger"
                       href="/addressList/AdmdeleteServlet?id=<c:out value="${user.user_id}"/> ">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
