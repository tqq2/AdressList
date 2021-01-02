<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加一名联系人</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">  
</head>
<body>
	<div  class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">添加一名联系人</h3>

		</div>
	</div>
	<br><br>
	<center>
		<form action="/addressList/addServlet" method="post">
			<table border="1" class="table table-bordered" style="margin: 5%">
				<tr>
					<td>姓名</td>
					<td><input type="text" name="addname" class="form-control"></td>
				</tr>
				<tr>
					<td>电话1</td>
					<td><input type="text" name="addphone1" class="form-control"></td>
				</tr>
				<tr>
					<td>电话2</td>
					<td><input type="text" name="addphone2" class="form-control"></td>
				</tr>
			</table>
			<br /> 
			<input type="submit" value="保存" class="btn btn-primary" /> 
			<button class="btn btn-light">
				<a href="addresslist.jsp" >返回</a>
			</button>
		</form>
	</center>
</body>
</html>