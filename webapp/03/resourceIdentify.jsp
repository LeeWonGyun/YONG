<%@page import="kr.or.ddit.servlet01.DescriptionServlet"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/resourceIdentify.jsp</title>
</head>
<body>
   <h4>자원(Resource)의 종류</h4>
   <pre>
<!-- 자원에 접근하는 방식에 따라 표현 -->
      file system resource : D:\contents\cat1.jpg
      <%=new File("D:/contents/cat1.jpg").length() %>
<!-- web resource : D:\A_TeachingMaterial\6.JspSpring\workspace\webStudy01\webapp\images\cat1.jpg -->
      web resource : localhost:80/webStudy01/images/cat1.jpg <!-- 이렇게 접근한다. , 서버가 없으면 안된다.-->
      <!-- webapp은 가상경로이기 때문에 하드코딩으로 접근할 수 없다. -->
      <%
         URL urlRes = new URL("http://localhost:80/webStudy01/resources/images/cat1.jpg");
         InputStream is = urlRes.openStream();
         out.println(is.available());
         
         is = application.getResourceAsStream("/resources/images/cat1.jpg");
         out.println(is.available());
      %>
      
<!-- class path resource : D:\A_TeachingMaterial\6.JspSpring\workspace\webStudy01\res\kr\or\ddit\images\cat1.jpg -->
<!-- 자원 접근 -> 경로 표기 -> (바뀌지 않는 것 = 변경되는 경로는 사용하지않는다.) -->
      class path resource : kr/or/ddit/images/cat1.jpg
      
      <%
         //cat1.jpg만 적을 시 해당 파일이 있는곳부터 시작하는데 그렇게 되면 servlet01이라는 패키지 안에서 cat1을 찾는다.
         InputStream cpIs =  DescriptionServlet.class.getResourceAsStream("../images/cat1.jpg");  //=>상대경로 방식
//          InputStream cpIs =  DescriptionServlet.class.getResourceAsStream("/kr/or/ddit/images/cat1.jpg");  //=>절대경로 방식
         out.println(cpIs.available());
      %>
      
   </pre>
   <h4>웹 리소스 경로 표기 방식</h4>
   <pre>
      URL(물리적), URI(논리적)
      :웹 상의 자원을 식별하기 위한 식별 체계(URI)
      URN(Naming) => 이름으로 식별 => 같은 이름이 중복이 되면 안되고, 이름을 등록해야한다.
      URC(Contents) => 특성 하나하나로 식별 => 하나의 특성으론 식별성이 없다.
      URL(Locator) => 위치로 식별
      protocol://DN(DomainName)(IPAddress):port/context/depth0...n/file
      
      웹 리소스의 경로 표기 바식
      client side
         절대 경로 : http://localhost:80/webStudy01/images/cat1.jpg, <%=request.getContextPath() %>/images/cat1.jpg
         상대 경로 : 현재 클라이언트가 보유한 주소를 기반으로 자원의 절대 경로를 유추함
      "server" side("절대" 경로) : /images/cat1.jpg
   </pre>
   client side :
   <img src="http://localhost:80/webStudy01/resources/images/cat1.jpg" /><br>
   client side :
   <img src="<%=request.getContextPath() %>/resources/images/cat1.jpg" /><br>
<!--    server side :
   <img src="/images/cat1.jpg" /><br> -->
   <img src="../images/cat1.jpg" /><!-- /로 시작하지 않으면 상대경로 -->
   <img src="<%=request.getContextPath() %>/image.do?image=cat1.jpg"> 
</body>
</html>