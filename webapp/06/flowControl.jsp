<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/flowControl.jsp</title>
</head>
<body>
	<h4>웹 어플리케이션에서 흐름 제어(페이지 이동, A -> B)</h4>
	<pre>
		1. Request Dispatch : 원본 요청에 대한 정보를 가지고 분기. 서버 사이드 위임구조(클라이언트가 서버가 바뀌었는지 모른다.)
			1) forward : 최종 응답은 이동 후에 B에서 전송
			2) include : A가 B에서 만들어지는 결과를 내포하는 구조(서버사이드 페이지 모듈화).
			<%
				String destination = "/07/destination.jsp"; //server side에서 사용할 주소
// 				RequestDispatcher rd =  request.getRequestDispatcher(destination);
// 				rd.forward(request, response);
// 				rd.include(request, response);
				pageContext.include(destination); //pageContext는 모든 기본 객체를 통괄하고 있는 친구.
				//기본적으로 버퍼가 내포되어있어 정확한 곳에 내용을 전달해준다. pageContext를 사용하지 않았을 땐 B에 대한 내용이 예상치 못한 곳에 들어가있다.
			%>
		2. Redirect : 원본 요청에 대한 정보가 페이지 이동전에 stateless 방식으로 삭제된 후에 이동하는 구조.
			원본 요청 발생(requestA) -> responseA가 전송 (Body가 없고, 302/Location 만으로 구성) -> server side에서 requestA 소멸,
			-> Location 방향으로 새로운 요청(requestB) 발생 -> responseB가 최종 전송  /-> B는 A의 존재를 모른다.
			<%--
				String location = request.getContextPath() + "/07/destination.jsp"; //client에서 location 방향으로 새로운 요청 즉 이 주소가 클라이언트에서 사용됨.
				response.sendRedirect(location);
			--%>
	</pre>
</body>
</html>