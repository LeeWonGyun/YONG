<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="True" %> <!-- True를 사용하면 jsp에 오류처리를 할것이다 라는것 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/implicitObject.jsp</title>
</head>
<body>
	<h4>기본 객체(내장 객체)</h4>
	<pre>
		: JSP에 해당하는 서블릿 소스가 파싱될 때 컨테이너에 의해 기본 제공되는 객체.
		
		1. request(HttpServletRequest) : 
		2. response(HttpServletResponse) : 
		3. <a href="bufferDesc.jsp">out(JspWriter)</a> : 출력 스트림으로 버퍼에 응답 데이터를 기록할 때 사용됨. 버퍼 제어에 사용. 
		4. <a href="../08/sessionDesc.jsp">session(HttpSession) / Cookie 쿠키가 없으면 세션이 유지가 되지 않는다.</a>
		5. <a href="../09/servletContextDesc.jsp">application(ServletContext) :</a> 
		
		6. config(ServletConfig) : 
		7. page(Object-Jsp 인스턴스, this) : 
		
		8. exception(Throwable) : 일반적인 상황에서 사용x, 예외 처리 용도의 페이지에서 활성화(isErrorPage="true")
		
		***** 9. <a href="../09/pageContextDesc.jsp">pageContext(제일 중요) : 가장 먼저 생성되는 기본 객체, 나머지 객체의 참조를 소유함.</a>
		
	</pre>
</body>
</html>