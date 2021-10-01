<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/pageContextDesc.jsp</title>
</head>
<body>
	<h4>pageContext(PageContext)</h4>
	<pre>
		:나머지 기본 객체의 참조 소유자.
		<%=request == pageContext.getRequest() %> 
		<%=response == pageContext.getResponse() %>
		<!-- 실행시 true가 뜬 것으로 pageContext가 request와 response를 기본적으로 가지고 있다. -->
		
		활용
		1. 속성 데이터 관리 <% pageContext.setAttribute("sample", "value", pageContext.SESSION_SCOPE); %> <!-- pageContext.SESSION_SCOPE를 사용하면 세션의 번호를 알지 않아도 된다.  -->
		2. flow control 
		<%--
			String destination = "/07/destination.jsp";
// 			request.getRequestDispatcher(destination).forward(request, response);
// 			pageContext.forward(destination); //페이지가 있어야 사용 가능하다.
// 			request.getRequestDispatcher(destination).include(request, response);
			pageContext.include(destination); //include 위치 예상 가능.
		--%>
		3.에러 데이터 확보 : <%= exception == pageContext.getException() %>
		이 라인이 어디에 출력되는지 잘 봐야한다!
	</pre>
</body>
</html>