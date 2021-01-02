<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">

</style>
</head>
<body>

<div id="container">
		<div class="container">
			<h1 class="display-4">欢迎管理员</h1>
			<p class="lead">Welcome Administrator</p>
		</div>
	<br>
	<br>
	<div id="login-container">
		<div align="center">
		<form action="/addressList/AdmloginServer" method="post">
			<br><br>
		 	<img class="mb-4" src="images/A.png" alt="这是一个图标" width="72" height="72">
 			 <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<table>
				<tr>
					<td>
						<div class="input-group mb-3">
							<div class="input-group-preend">
								<span class="input-group-text" id="inputGroup-sizing-default">账号</span>
							</div>
								<input name="user" type="text" required autofocus class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">

							<div class="input-group-append">
								<button class="btn btn-outline-secondary" >
									<a href="index.jsp" style="color: #6c757d">退出</a>
								</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-sizing-default">密码</span>
							</div>
							<input name="pwd" id="pwd" required type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"> 
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="submit" id="button-addon2">登录</button>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>

</div>

</body>
</html>