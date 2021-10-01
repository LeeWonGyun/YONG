<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/servletContextDesc.jsp</title>
</head>
<body>
	<h4>application(ServletContext)</h4>
	<pre>
		: 서블릿 객체가 운영되는 어플리케이션(context)과 container(WAS)에 대한 정보를 가진 객체.
		: 하나의 컨텍스트당 하나씩 운영됨.
		
		1. 서버의 정보를 확인 -> 개발서버와 운영서버가 같지 않을 수 있다.
			<%=application.getServerInfo() %>
			<%=application.getMajorVersion() %>.<%=application.getMinorVersion() %>-> 소수점 앞에 있는것은 메이저 소수점 뒤는 마이너버전
			
		2. logging
			<%	//logging 조건 : message, layout(메세지의 형식), appender(기록), logger(전달자), event level
				application.log("서버 통계 목적으로 남기는 로그"); //log는 클라이언트에 남기는 목적이 아님.
			%>
		3. (*****). 웹 리소스 확보
			<%
				String srcURL = "/resources/images/bear.jpg"; //URL / 논리적 주소
				String srcFileSyetemPath = application.getRealPath(srcURL); //물리적 주소
				
				File srcFile = new File(srcFileSyetemPath);
				String destFolderURL = "/09";
				String destFolderFileSystemPath = application.getRealPath(destFolderURL); //destFolder의 진짜 경로
// 				File destFolder = new File(destFolderFileSystemPath);
// 				File destFile = new File(destFolder, srcFile.getName());
				Path destPath = Paths.get(destFolderFileSystemPath, srcFile.getName());
				String destFileURL = destFolderURL + "/" + srcFile.getName();
				try(
// 					InputStream is = application.getResourceAsStream(srcURL);
					InputStream is = new FileInputStream(srcFile);
// 					OutputStream os = new FileOutputStream(destFile);
				){
					Files.copy(is, destPath);
				}
				String destFile = "/09/bear.jpg"; //데스티네이션 파일 객체 생성-> 인,아웃풋 스트림 -> 복사떠서 파일 생성
				//D:\A_TeachingMaterial\6.JspSpring\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webStudy01\09 로 들어가면 사진 생성되어있는걸 볼 수있다.
				
			%>
			<%=srcURL %>
			<%=srcFileSyetemPath %>
		4. 컨텍스트 파라미터 확보
			<%=application.getInitParameter("contentFolder") %>
	</pre>
	<img src="<%=request.getContextPath() %><%=destFileURL %>" />
</body>
	<form action="<%=request.getContextPath() %>/imageForm.do">
		
	</form>

</html>