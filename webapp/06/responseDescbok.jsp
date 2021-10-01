<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/responseDescbok.jsp</title>
</head>
<body>
	<h4>response(HttpServletResponse)</h4>
	<pre>
		: 서버에서 클라이언트로 전송되는 응답과 관련된 모든 정보를 캡슐화한 객체.
		
		Http 따른 response 패키징 방식
		1. Response Line : response status code(응답 상태 코드) -> 성공 실패여부를 브라우저로 보냄.
			: 명령 처리 결과를 표현하는 세자리 숫자
			1) 100 ~ : ing... (요청을 계속 해야한다)
			2) 200 ~ : OK(처리에 성공)
			3) 300 ~ : 처리가 완료되려면, 클라이언트로부터 추가 액션이 필욯다ㅏ.
				304(Not Modified) -> 요청된 리소스를 재전송할 필요 없음, 302/307(Moved) -> 요청한 리소스가 임시적으로 이동 페이지로 이동됐다.
			4) 400 ~ : client side fail
				404(Not Found), 400(Bad Request),
				401<%=HttpServletResponse.SC_UNAUTHORIZED %> -> 권한이 없는 요청
				403<%=HttpServletResponse.SC_FORBIDDEN %> -> 서버가 허용하지않는 웹페이지나 미디어를 사용자가 요청할 때
				405<%=HttpServletResponse.SC_METHOD_NOT_ALLOWED%> -> 사용 불가능한 상태, 서버에서 내보냄.
				415<%=HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE %> -> Json에서 자주 일어남. ContentType이 맞지 않을 때
			5) 500 ~ : server side fail, 500(Interal server error)
		
		connectless
		stateless
		
		jsp servlet / session cookie
		
		상태코드 변경시 : response.sendError[sendRedirect]
		
		2. Response Header : content meta data, setHeader(name, value)
			1) content mime setting : Content-Type
				response.setHeader("Content-Type", "value");
				response.setContentType(value)
				page 지시자의 contentType 속성 
				
			2) cache control
				<a href = "cacheControl.jsp">cacheControl.jsp</a>
			3) auto request를 통한 페이지 생신
				<a href = "autoRequest.jsp">autoRequest.jsp</a>
			4) flow control
			
		3. Response Body(Content Body, Message Body)
			: request method가 head인 경우, body가 구성되지 않음.
			: redirect 이동 방식의 경우, 중간에 body가 없는 응답이 전송.
	</pre>
	<img src="<%=request.getContextPath() %>/resources/images/cute7.JPG" />
</body>
</html>