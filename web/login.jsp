<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录界面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/mystyle.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .container {
            color: white;
        }

        #footer {
            position: fixed;
            bottom: 0;
            text-align: center;
            margin-left: -50px; /*div宽度的一半*/
            left: 39%;
        }
    </style>
</head>
<body>

<div id="container">
    <div class="container">
        <h1 class="display-4">共享通讯录</h1>
        <p class="lead">Shared AddressBook</p>
    </div>
    <br>
    <br>
    <div id="login-container">
        <div align="center">
            <form action="/addressList/loginServer" method="post">
                <br><br>
                <img class="mb-4" src="images/b.jpg" alt="这是一个图标" width="72" height="72">
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
    <div id="footer" align="center">
        <footer class="text-muted">
            <div class="container">
                <p style="color: white;">Copyright &copy; 2020 author : qianqing tang, Wellcome you to join us!</p>
            </div>
        </footer>
    </div>
</div>

</body>
</html>