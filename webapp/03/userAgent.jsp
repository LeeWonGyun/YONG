<%@page import="kr.or.ddit.enumpkg.BrowserType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/userAgent.jsp</title>
</head>
<body>
	<h4>User Agent Header</h4>
	<!-- 	클라이언트의 브라우저가 크롬이면 -> "당신의 브라우저는 크롬입니다!" -->
	<!-- 	클라이언트의 브라우저가 엣지면 -> "당신의 브라우저는 엣지입니다!" -->
	<!-- 	클라이언트의 브라우저가 사파리이면 -> "당신의 브라우저는 사파리입니다!" -->

	<%
		String agent = request.getHeader("User-Agent");
		String browserName = BrowserType.findBrowserName(agent);
		agent = agent.toUpperCase(); //전부 대문자로 바꾸기
		//String browserName = null;
		//Map<String, String> browserMap = new LinkedHashMap<>(); //키값과 밸류값(이름)을 가진 맵 생성, 인터페이스 map은 인스턴스화 할 수 없기 때문에 링크드해시맵으로 설정
// 		browserMap.put("EDG", "엣지");//엣지라는 키와 이름
// 		browserMap.put("SAFARI", "사파리");//사파리라는 키와 이름
// 		browserMap.put("CHROME", "크롬");//크롬라는 키와 이름
// 		browserMap.put("OTHER", "기타");//기타라는 키와 이름

		/*browserName = BrowserType.OTHER.getBrowserName();
		for(BrowserType tmp : BrowserType.values()) {
			String key = tmp.name();
			if(agent.contains(key)){
				browserName = tmp.getBrowserName();
				break;
			}
		}*/
		
		//밑에있는 for문이 위로 됨.
		
// 		browserName = browserMap.get("OTHER");
// 		for(Entry<String, String> entry : browserMap.entrySet()){
// 			String key = entry.getKey();
// 			String name = entry.getValue();
// 			if(agent.contains(key)){
// 				browserName = name;
// 				break;
// 			}
// 		}
		String pattern = "당신의 브라우저는 %s 입니다!"; //패턴 만들기 %s로 하드코딩x 변하게 만들기
		String message = String.format(pattern, browserName); //일정한 형태의 메세지 생성
		//pattern 안에 %s 값을 browserName으로 넣어주겠다.
	%>

	<%=agent%>
	<script type="text/javascript">
		alert("<%=message %>")
	</script>
</body>
</html>