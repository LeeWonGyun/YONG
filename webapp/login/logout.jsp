<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    HttpSession userSession = request.getSession();
    userSession.invalidate();
    out.println("<h4>로그아웃 되었습니다.</h4>");
%>
</body>
</html>