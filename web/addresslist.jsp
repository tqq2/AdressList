<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.ResultSet"%>
<%
	ArrayList addressbook = (ArrayList) session.getAttribute("addressbook");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>共享通讯录</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<%--	<base href="<%=basePath%>">--%>
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">共享通讯录列表</h1>

		</div>
	</div>
	<form action="/addressList/selectServlet" method="post">
		<div class="row justify-content-center">
		<a href="index.jsp" class="btn btn-outline-secondary" style="margin-right: 24px;
">退出</a>
			<div class="form-inline row">

				<select name="selectbox" class="custom-select mr-sm-2">
					<option>姓名</option>
					<option>电话号码</option>
				</select>
				<input type="text" name="search" class="form-control"
					style="width: 50%"></input>
				<button name="cheakSearch" class="btn btn-primary"
					style="margin-left: 2%">查询</button>
				<a href="export.jsp" class="btn btn-outline-secondary" style="margin-right: -5%">导出</a>

			</div>
		</div>
	</form>
	<div class="row justify-content-center">
		<table border="" width="50%" style="margin: 2%" class="table table-bordered">
			<tr>
				<th scope="col">序号</th>
				<th scope="col">姓名</th>
				<th scope="col">电话1</th>
				<th scope="col">电话2</th>
				<th scope="col"><a href="add.jsp" class="btn btn-primary">添加</a>

				</th>

			</tr>
			<c:forEach var="address" items="${addressbook}">
				<tr>
					<td><c:out value="${address.id}" /></td>
					<td><c:out value="${address.name}" /></td>
					<td><c:out value="${address.phone1}" /></td>
					<td><c:out value="${address.phone2}" /></td>
					<td><a href="update.jsp?id=<c:out value="${address.id}"/> " class="btn btn-info">编辑</a>
						<a class="btn btn-danger"
						href="/addressList/deleteServlet?id=<c:out value="${address.id}"/> ">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>