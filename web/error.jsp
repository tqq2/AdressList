<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%

    String message = (String) session.getAttribute("message");
    out.print(message);
%>
</body>
</html>