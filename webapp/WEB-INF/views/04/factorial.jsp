<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/factorial.jsp</title>
</head>
<body>

<form method="post">   <!-- form태그에 action이 없는 경우, (이 jsp를 호출한 곳이 없을 때) 자기자신을 호출하게 된다(새로고침) -->
<!-- action 을 생략했을 때 브라우저로 호출 => 즉 jsp에서 불러오지 않고 서블릿을 통하면 서블릿을 불러온다는 것. -->
   <input type="number" name="operand" min="1" max="10" /> 
   <input type="submit" value="!" />
   <%=request.getAttribute("result") %>
</form>

</body>
</html>