<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileManager.jsp</title>
</head>
<body>
<!-- /resource/images/* 경로에 있는 이미지들을 목록으로 만들기 -->
	<select size="10" id="srcSelect">
		
	</select>
	<div>
		<input type="radio" name="command" value="COPY" />COPY <!-- 왼쪽에서 오른쪽으로 카피버튼 누르면 카피됨. -->
		<input type="radio" name="command" value="MOVE" />MOVE <!-- 왼쪽에서 오른쪽으로 옮겨짐 -->
		<input type="radio" name="command" value="DELETE" />DELETE <!-- 왼쪽 목록에서 삭제됨 -->
	</div>
<!-- /09/* -> 자원의 목록 제공 -->
	<select size="10" id="destSelect">
	
	</select>
	
</body>
</html>