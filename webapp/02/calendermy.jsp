<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//jsp를 실행하면 처음부터 request로 받아와야하는데 현재 받을게 없으면 null인 상태.
	String yy = request.getParameter("year");
	String mm = request.getParameter("month");

	//달력만들때 중요한 것은 마지막 날짜이다. 또, 1일이 언제 시작하고 무슨 요일부터 시작하는지
	//인스턴스 변수 생성
	Calendar cal = Calendar.getInstance();

	int h_y = cal.get(Calendar.YEAR);
	int h_m = cal.get(Calendar.MONTH);
	//현재 연도 월 갖고오기
	int year = cal.get(Calendar.YEAR); //2021년
	int month = cal.get(Calendar.MONTH); // 8월 -> 시스템에선 0부터 인식해 0부터 시작하기에 8로 입력해야 9월로 인식함.
	//    int year = 2020;
	//    int month = 11; -> 2020년 12월달의 달력이 나온다.
	
	if(yy != null && mm != null && !yy.equals("") && !mm.equals("")) { //반드시 사용자가 입력했을때에 돌아가는 if문
		//기본값은 2021년 9월로 설정이 되어있다
		year = Integer.parseInt(yy); //둘 다 널이 아니고 공백이 아닐 때에는 그 값을 year에 넣어준다.
		month = Integer.parseInt(mm)-1; //둘 다 널이 아니고 공백이 아닐 때에는 그 값을 month에 넣어준다.
	}
	
	
	
	//요일 얻어오기
	cal.set(year, month, 1); //현재 연 월의 1일날로 캘린더 시점 셋팅
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //바로 쓰게 되면 오늘 (9월 5일을 가져온다)

	//이번 달이 몇 일 까지 있는지 가져오기
	int lastday = cal.getActualMaximum(Calendar.DATE); //지금 시점의 마지막 날을 가져온다.
	
	
	//이전버튼
	int bef_year = year;
	int bef_month = month;
	
	if(month == 0) { //해가 바뀌었다는 것. 이전버튼, 다음버튼 막 누르다보면 0월이 되기 때문에 조건 걸어주기
		bef_year -= 1;
		bef_month = 12;
	}
	
	//다음버튼
	int aft_year = year;
	int aft_month = month+2;
	
	if(aft_month == 13) {
		aft_year = year + 1;
		aft_month = 1;
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
body {
	font-size: 9pt;
	color: #555555;
}

table {
	border-collapse: collapse; /* 셀 사이의 간격을 없애준다*/
}

th, td {
	border: 1px solid #cccccc;
	width: 50px;
	height: 25px;
	text-align: center;
}

caption {
	margin-bottom: 10px;
	font-size: 15px;
}
</style>



<body>
	<form name="frm" method="post" action="calendermy.jsp">
		<select name="year">
			<%
				for(int y1=h_y-121; y1<h_y+79; y1++){
					String chk1 = "";
					
					if(y1 == Integer.parseInt(yy)) { //y1과 yy가 값이 같다면 chk에 selected 글자를 넣겠다
						chk1 = "selected";
					}
			%>
			<option value="<%=y1%>" <%=chk1 %>><%=y1 %>년</option>
			<%
				}
			%>
		</select>
		
		<select name="month">
			<%
				for(int m1 = 1; m1 < 13; m1++){
					String chk2 = "";
					
					if(m1 == Integer.parseInt(mm))
					chk2 = "selected";
					
			%>
			<option value="<%=m1%>" <%=chk2 %>><%=m1 %>월</option>
			<%
				}
			%>
		</select>
		<input type="submit" value="달력보기">
<!-- 		<input type="submit" value="현재년/월보기"> -->
	</form>

	<table>
		<!-- 몇 년 몇 월 이라는걸 보여주기 위해 caption을 사용 -->
		<caption>
		<button type="button" onclick="location='calendermy.jsp?year=<%=bef_year %>&month=<%=bef_month%>'">이전</button> <!-- location => jsp로 넘어가겠다. -->
		<%=year%>년	<%=month + 1%>월	
		<button type="button" onclick="location='calendermy.jsp?year=<%=aft_year %>&month=<%=aft_month%>'">다음</button>
		</caption>
		<!-- month는 0부터 시작하기에 +1을 해줘야 정상적인 해당 월이 나온다. -->

		<tr>
			<th>일</th> <!-- th를 쓰면 가운데정렬이 이뤄지고 글자도 굵어진다. -->
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>

		<tr>
			<!--          <td></td> 숫자가 들어가있지 않은 빈 공간을 만들어준다. -->
			<%
				/* 날짜를 대신해서 눈에 보이지 않지만 1일부터 시작되는 존재를 만들어야한다. 날짜는 날짜대로, 개행해야할 변수 하나 생성  */
				//1일을 출력하기 전 빈칸을 출력하는 반복문
				int count = 0;
				//1일 시작 요일이 다를 때 사용되는 for문 생성 - 날짜 출력하는 반복문
				for (int s = 1; s < dayOfWeek; s++) {
					out.print("<td></td>");
					count++; //위에서 빈 공간이 생길때마다 카운트 증가
				}
				//날짜 출력하는 설정
				for (int d = 1; d <= lastday; d++) {
					count++;

					String color = "#555555";
					if (count == 7) {
						color = "blue";
					} else if (count == 1) {
						color = "red";
					}
					//또한 온전한 숫자가 있을시에도 카운트가 증가한다.
			%>
			<td style="color:<%=color%>"><%=d%></td>
			<%
				//개행처리를 위한 설정
					if (count % 7 == 0) {
						out.print("</tr><tr>"); //tr로 닫고 tr로 열어서 7의 배수 단위로 끊어 밑줄로 내린다
						count = 0; //변수 초기화
					} //확인해보면 날짜는 다른 번째 칸부터 시작되지만 count는 1번쨰 칸부터 실행되고 있어서 빈 공백이어도 7칸마다 줄바꿈이 실행된다.
				}

				//끝나는 구간에 상관없이 7까지 채운다. 수요일 = 4에서 끝난다면 밑으로 가서 count++로 5가 되고, 토요일인 6 까지 내려오게 한다.
				while (count < 7) { //카운터라는 변수를 7까지 증가시킨다.
					out.print("<td></td>");
					count++;
				}
			%>
		</tr>
	</table>
</body>
</html>