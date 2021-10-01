<%@page import="java.util.Locale"%>
<%@page import="java.util.Calendar"%>
<%@page import="static java.util.Calendar.*"%> <!-- 캘린더가 가지고 있는 static 멤버들을 전부 import => static import => Calendar.을 안 써도 됨 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Refresh" content="5;url=https://www.naver.com"> --> <!-- 아래 client side -->
<title>06/autoRequest.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h4>헤더를 이용한 페이지 갱신(동기 요청)</h4>
	<%
		Locale[] locales = Locale.getAvailableLocales();
		//getAvailableLocales를 사용하면 Locale의 모든 값들을 볼 수 있다.
	%>
	<select id="language">
		<%
			for(Locale tmp : locales){ //향상된 포문
				String text = tmp.getDisplayLanguage(tmp); //text 객체에 locales에 담은 값들을 넣어서 담는다.
				if(text == null || text.isEmpty()) continue; //만약 text에 값이 없거나 문자열의 길이가 0이면 continue로 반복문 탈출해서 다시 반복문으로 들어간다.
				String languageTag = tmp.toLanguageTag(); //languageTag 객체에 
				String selected = tmp.equals(request.getLocale())?"selected" : ""; //selected 객체에 tmp에 담긴 locales들과 요청받은 locale이 같은지 비교해서 같으면 ""로 포장
		%>
			<option value="<%=languageTag %>" <%=selected %>><%=text %></option> <!-- 위 반복문에서 나온 값들을 넣어준다. -->
		<%		
			}
		%>
	</select>
	<h4>현재 서버의 시간 : <span id="serverTime"></span></h4>
	<h4>현재 클라이언트의 시간 : <span id="clientTime"></span></h4>
	<pre>
		auto request 방법
		1. server side : Refresh 응답 헤더
		
		2. client side
			1) html : meta 태그의 http-equiv 사용(Refresh)
			2) javascript : scheduling function 사용, location.reload() (refresh역할 => 페이지 갱신)
		
	</pre>
	<script type="text/javascript">
		let clientTime = $("#clientTime"); //script안에 스판태그 id값 넣는다.
		let serverTime = $("#serverTime");
		let language = $("#language");
		
		setInterval(function(){
			clientTime.text(new Date()); //text로 가져오기
			$.ajax({ //객체화 시켜서 넘겨주는 방식 
				url : "<%=request.getContextPath() %>/getServerTime.do",  <%-- servlet 주소 --%>
				data : {
					language : language.val();	//json 형식 {language : language.val() }
				},
// 				method : "get", //method가 get방식이면 생략 가능
				dataType : "text", //서버에서 받을 데이터 방식 = text
				success : function(resp) {//핸들링하기 위한 타입, 성공을 했을 때 ~~을 하겠다. 상태코드가 200일 때 된다.
					serverTime.text(resp); //요청받은 값을 text로
				},
				error : function(xhr, errorResp, error) { //요청 상태코드가 200이 아닐 시. xml http resp
					console.log(xhr);
					console.log(errorResp);
					console.log(error);
				}
			});
		}), 1000); //1초
	</script>
</body>
</html>