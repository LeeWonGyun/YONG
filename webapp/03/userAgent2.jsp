<%@page import="kr.or.ddit.enumpkg.BrowserType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/userAgent.jsp</title>
</head>
<body>
	<h4>User Agent Header</h4>
	<!-- 	클라이언트의 브라우저가 크롬이면 -> "당신의 브라우저는 크롬입니다!" -->
	<!-- 	클라이언트의 브라우저가 엣지면 -> "당신의 브라우저는 엣지입니다!" -->
	<!-- 	클라이언트의 브라우저가 사파리이면 -> "당신의 브라우저는 사파리입니다!" -->

	<%
		String agent = request.getHeader("User-Agent");
		String browserName = BrowserType.findBrowserName(agent);
		agent = agent.toUpperCase(); //전부 대문자로 바꾸기
		
		String pattern = "당신의 브라우저는 %s 입니다!"; //패턴 만들기 %s로 하드코딩x 변하게 만들기
		String message = String.format(pattern, browserName); //일정한 형태의 메세지 생성
	%>

	<%=agent%>
	<script type="text/javascript">
		alert("<%=message %>")
	</script>
</body>
</html>