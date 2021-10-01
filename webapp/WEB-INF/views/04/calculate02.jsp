<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/calculate.jsp</title>
</head>
<body>
	<form id="guguForm" method="post"> <!-- 어느 방향으로 날릴건지. action이 없으면 현 브라우저 주소 -->
		<input type="text" name="leftOp" required />
		<select name="operator">
			<option value>연산자</option>
			<option value="PLUS">+</option>
			<option value="MINUS">-</option>
			<option value="MULTIPLY">*</option>
			<option value="DIVIDE">/</option>
		</select>
		<input type="text" name="rightOp" required />
		<button type="submit"> = </button>
<!-- 1.leftOp, rightOp, operator가 서버로 넘어가게. -->
<!-- 2. 비동기 요청 구조 -->
<!-- 3. 응답데이터의 mime : json -->
	</form>
	<script type="text/javascript">
		$("#guguForm").on("submit", function(event){
			event.preventDefault();
			let url = this.action;
			let method = this.method;
			let ata = $(this).serialize();
			console.log(data);
			$.ajax({
				url : url,
				data : data,
				method : method,
				dataType : "json",
				success : function(resp){
					$("#resultCal").html(resp.result)
				},
				error : function(xhr, errorResp, error) { //요청 상태코드가 200이 아닐 시. xml http resp
					console.log(xhr);
					console.log(errorResp);
					console.log(error);
				}
			})
			return false;
		});
	</script>
<!-- 	2 * 3 = 6 형식이 되게 -->
</body>
</html>