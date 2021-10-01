<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/cacheControl.jsp</title>
</head>
<body>
	<h4>캐시 제어용 헤더</h4>
	<pre>
		:Pragme(http 1.0), Cache-Control(http 1.1) - 캐시 여부 결정
		 Expires(공통, 캐시 만료 시한)
		 <%
// 		 	response.setHeader("Pragma", "no-cache");
// 		 	response.setHeader("Cache-Control", "no-cache"); //파이어폭스 특정 버전에서는 안됨.
// 		 	response.addHeader("Cache-Control", "no-store"); //파이어폭스 특정 버전은 이거로 사용
		 	//set을 사용하면 자동으로 덮어지기 때문에 add로 추가해야한다.
		 	
// 		 	String cacheValue1 = "no-cache";
// 		 	String cacheValue2 = "no-store";
		 	String cacheValue1 = "public";
		 	response.setHeader("Pragma", cacheValue1);
		 	response.setHeader("Cache-Control", cacheValue1);
		 	Calendar now = Calendar.getInstance();
		 	now.add(Calendar.DAY_OF_WEEK_IN_MONTH, 7);
		 	response.setDateHeader("Expires", now.getTimeInMillis());
		 %>
	</pre>
</body>
</html>