<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link href="<%=request.getContextPath() %>/resources/css/ui.fancytree.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/resources/js/jquery.fancytree.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery.fancytree.ui-deps.js"></script>

<style type="text/css">
   #header{
      height : 100px;
      width : 100%;
      background-color: yellow;
   }
   #left{
      width : 20%;
      height : 500px;
      background-color: aqua;
      float : left;
   }
   #content{
      width : 79%;
      height : 500px;
      float : right;
   }
   #footer{
      width : 100%;
      height : 100px;
      background-color: silver;
      float: left;
   }
</style>
</head>
<body>
   <div id="header">
<%--       <ifram src="<%=request.getContextPath() %>/includee/headerMenu.jsp"></ifram> --%>
      <%
         pageContext.include("/includee/headerMenu.jsp"); //서버사이드 방식으로 들어옴
      %>
   </div>
   
   <div id="left">
<%--       <ifram src="<%=request.getContextPath() %>/includee/leftMenu.jsp"></ifram> --%>
      <jsp:include page="/includee/leftMenu.jsp"></jsp:include>
   </div>
   
   <div id="content">
   
   </div>
   
   <div id="footer">
<%--       <ifram src="<%=request.getContextPath() %>/includee/footer.jsp"></ifram> --%>
      <jsp:include page="/includee/footer.jsp"></jsp:include>
   </div>
</body>
</html>