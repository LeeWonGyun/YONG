<%@page import="java.time.DayOfWeek"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int getLastDayOfMonth(int year, int month){
	
	boolean leap_yaer = false;
	if(year%4 == 0) leap_yaer = true;
	if(year%100 == 0) leap_yaer = false;
	if(year%400 == 0) leap_yaer = true;
	
	int lastDay = 28;
	switch(month) {
	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		lastDay = 31;
		break;
	case 4: case 6: case 9: case 11:
		lastDay = 30;
		break;
	default:
		if(leap_yaer) lastDay = 29;
	}
	
	return lastDay;
}
%>

<%
	Calendar cal = Calendar.getInstance();

	int year = cal.get(Calendar.YEAR);
	String pYear = request.getParameter("year");
	if(pYear != null && pYear.matches("19[7-9]{1}[0-9]{1}|20[0-7]{1}[0-9]{1}")){
		year = Integer.parseInt(pYear);
	}
	int month = cal.get(Calendar.MONTH) + 1;
	String pMonth = request.getParameter("month");
	if(pMonth != null && pMonth.matches("[1-9]{1}|1[0-2]{1}")){
		month = Integer.parseInt(pMonth);
	}
	
	// 선택된 연, 월의 1일
	LocalDate localDate = LocalDate.of(year, month, 1);
	// 상기한 날짜의 요일을 구하는 코드 -> 일~토(0~6)
	DayOfWeek dayOfWeek = localDate.getDayOfWeek();
	int DOW = dayOfWeek.getValue() == 7 ? 0 : dayOfWeek.getValue(); // getValue의 리턴 -> 월~일(1~7)
	
	int lastDay = getLastDayOfMonth(year, month);
	int lastDayOfLastMonth = getLastDayOfMonth(year, month - 1);
	if(month == 1) lastDayOfLastMonth = getLastDayOfMonth(year - 1, 12);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
	$("[name='month']").on('change', function() {
		$(this.form).trigger("submit");
		return true;
	})
	
	$("#lastMonth").on('click', function() {
		let month = parseInt($("[name='month'] option:selected").val());
		if(month != 1){
			$("[name='month']").val(month-1).prop("selected", true);
		}else{
			let year = parseInt($("[name='year'] option:selected").val());
			$("[name='year']").val(year-1).prop("selected", true);
			$("[name='month']").val("12").prop("selected", true);
		}
		$(this.form).trigger("submit");
		return true;
	})
	
	$("#nextMonth").on('click', function() {
		let month = parseInt($("[name='month'] option:selected").val());
		if(month != 12){
			$("[name='month']").val(month+1).prop("selected", true);
		}else{
			let year = parseInt($("[name='year'] option:selected").val());
			$("[name='year']").val(year+1).prop("selected", true);
			$("[name='month']").val("1").prop("selected", true);
		}
		$(this.form).trigger("submit");
		return true;
	})
})
</script>
<title>report/windowCalendar</title>
</head>
<body>
<form method="post">
<table border='1'>
	<tr>
		<td colspan="5">
			<select name="year">
			<%
			for(int i = year - 50; i <= year + 50; i++){
				if(i == year){
			%>
				<option value="<%=i %>" selected><%=i %>년</option>
			<%		
				}else{
			%>
				<option value="<%=i %>"><%=i %>년</option>
			<%		
				}
			}
			%>
			</select>
			<select name="month">
			<%
			for(int i = 1; i <= 12; i++){
				if(i == month){
			%>
				<option value="<%=i %>" selected><%=i %>월</option>
			<%		
				}else{
			%>
				<option value="<%=i %>"><%=i %>월</option>
			<%		
				}
			}
			%>
			</select>
		</td>
		<td><input type="button" id="lastMonth" value="▲"></td>
		<td><input type="button" id="nextMonth" value="▼"></td>
	</tr>
	<tr>
		<td>일</td>
		<td>월</td>
		<td>화</td>
		<td>수</td>
		<td>목</td>
		<td>금</td>
		<td>토</td>
	</tr>
<%
for(int i = 0; i < 5; i++){
%>
	<tr style="text-align:center;">
<%
	for(int k = 1; k <= 7; k++){
		int days = i*7 + k - DOW;
		if(days <= 0){
			days = lastDayOfLastMonth + days;
%>
		<td style="color:grey;"><%=days %></td>
<%		
		}else if(days > lastDay){
			days -= lastDay;
%>
		<td style="color:grey;"><%=days %></td>
<%		
		}else{
%>
		<td><%=days %></td>
<%					
		}
	}
%>	
	</tr>
<%	
}
%>	
</table>
</form>
</body>
</html>