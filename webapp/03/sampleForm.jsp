<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/sampleForm.jsp</title>
</head>
<body>
	<h4>입력 양식</h4>
	<form action="<%=request.getContextPath() %>/sampleProcess.do" method="get">
		<pre>
			<input type="text" name="textParam" required /> 입력데이터에 제한을 두지 않겠다
			<input type="number" name="numberParam" required /> 입력데이터에 제한이 생긴다
			<input type="hidden" name="hiddenParam" value="hiddenText"/> 입력받기위한 용도가 아니다.
			
			<label><input type="radio" name="radioParam" value="radio1"/>Radio1</label> <label><input type="radio" name="radioParam" value="radio2"/> Radio2 </label>
			<!-- label로 묶으면 옆에 있는 text를 클릭해도 이벤트가 발생한다. -->
			<!-- radio와 차이점 -> 다중상속이 가능한지 여부 -->
			<input type="checkbox" name="checkParam" value="check1" /> Check1
			<input type="checkbox" name="checkParam" value="check2" /> Check2
			<input type="checkbox" name="checkParam" value="check3" /> Check3
			
			<select name="singleSelect" required>
				<option value>선택</option> <!-- promptText -->
				<option>text1</option>
				<option>text2</option>
				<option>text3</option>
			</select>
			
			<select name="multiSelect" multiple size="10"> <!-- multiple => listbox 형식 , boolean타입은 생략가능-->
				<option>text1</option>
				<option>text2</option>
				<option>text3</option>
			</select>
			
			<input type="button" value="버튼" /> 밑과는 버튼에 따라 발생하는 이벤트가 다르다. ->클릭하면 끝남.
			<input type="submit" value="전송" />	클릭하면 submit이라는 이벤트 발생 form에 submit이라는 이벤트를 실행시킨다. = trigger라고도 함. 타겟 = 폼태그
			<input type="reset" value="취소" /> form안에 있는 모든 입력값 초기화. 타겟 = 폼태그
		</pre>
	</form>
</body>
</html>