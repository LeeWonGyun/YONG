<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String textParam = request.getParameter("textParam");
	String numberParam = request.getParameter("numberParam");
	String radioParam = request.getParameter("radioParam"); //어떠한 라디오버튼도 선택하지않으면 null값이 들어간다.
	String[] checkParam = request.getParameterValues("checkParam"); //다중상속을 하기 때문에 그냥 String만 할 시에는 값 1개만 가져오기 때문에 배열을 선택
	String singleSelect = request.getParameter("singleSelect");
	String[] multiSelect = request.getParameterValues("multiSelect");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/sampleProcess.jsp</title>
</head>
<body>
	<table>
		<tr>
			<th>textParam</th>
			<td><%=textParam %></td>
		</tr>
		
		<tr>
			<th>numberParam</th>
			<td><%=numberParam %></td>
		</tr>
		
		<tr>
			<th>radioParam</th>
			<td><%=radioParam %></td>
		</tr>
		
		<tr>
			<th>checkParam</th>
			<td><%=checkParam %></td>
		</tr>
		
		<tr>
			<th>singleSelect</th>
			<td><%=singleSelect %></td>
		</tr>
		
		<tr>
			<th>multiSelect</th>
			<td><%=multiSelect %></td>
		</tr>
	</table>
</body>
</html>