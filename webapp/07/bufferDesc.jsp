<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/bufferDesc.jsp</title>
</head>
<body>
	<h4>출력 버퍼</h4>
	<pre>
		<%
			for(int i = 1; i <= 500; i++){
				out.print(i + "번 째");
				if(out.getRemaining() < 100){ //100 byte보다 적게 남았을 때
					out.flush(); //비워준다
				}
				if(i == 490) {
// 					throw new NullPointerException("강제 발생 예외"); 
					request.getRequestDispatcher("/07/destination.jsp").forward(request, response);
				}
			}
		%> 
	</pre>
</body>
</html>