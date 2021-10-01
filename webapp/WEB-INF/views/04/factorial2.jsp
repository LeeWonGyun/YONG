<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/factorial2.jsp</title>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<!-- 요청을 보내고 응답을 body로 받는데 />로 script를 닫으면 body로 받을 수 없다. -->
</head>
<body>

<form id="factorialForm" method="post">   <!-- form태그에 action이 없는 경우, (이 jsp를 호출한 곳이 없을 때) 자기자신을 호출하게 된다(새로고침) -->
<!-- action 을 생략했을 때 브라우저로 호출 => 즉 jsp에서 불러오지 않고 서블릿을 통하면 서블릿을 불러온다는 것. -->
   <input type="number" name="operand" min="1" max="10" /> 
   <input type="submit" value="!" />
   <span id="resultArea"><%=request.getAttribute("result") %></span>
</form>
<script type="text/javascript">
	$("#factorialForm").on("submit", function(event){ //submit 이벤트 발생시 처리할 콜백
		event.preventDefault(); //동기 이벤트를 중단하는 요청
		//동기 요청을 멈췄으니 비동기로 설정해야한다.
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize();
		console.log(data);		
		$.ajax({ //객체화 시켜서 넘겨주는 방식 
			url : url,
			data : data,
			method : method,
			dataType : "json", //accept(request)라는 헤더에 영향을 미친다. 응답데이터의 content-type(response)에 영향을 미친다.  text script xml json - 사용 가능한 dataType => 넷 다 문자로 구성되어있다.
								//html, plain, xml, json, script -> mime을 대표했던 것들. ''에 해당되는 타입이 오면 text/'html', 'text'/plain, application/'xml', application/'json', text/'script' 였던 것이다.
			success : function(resp) {//핸들링하기 위한 타입, 성공을 했을 때 ~~을 하겠다. 상태코드가 200일 때 된다.
				$("#resultArea").html(resp.result)
				
			},
			error : function(xhr, errorResp, error) { //요청 상태코드가 200이 아닐 시. xml http resp
				console.log(xhr);
				console.log(errorResp);
				console.log(error);
			}
		});
		return false;
	});
</script>
</body>
</html>