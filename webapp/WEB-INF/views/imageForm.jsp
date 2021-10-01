<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   File[] images = (File[])request.getAttribute("images");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<script type="text/javascript">

$(function() {
   let imageArea = $("#imageArea");
   const SRCPTRN = "<%=request.getContextPath()%>/image.do?image=%v";
   $("[name='image']").on('change', function(event) {
      console.log(event);
      console.log(this);//html element 형식으로 접근
      console.log($(this));//j쿼리 방식으로 1번 더 포장
      //this.form.submit();//마찬가지 이벤트가 발생하지 않는다.
      //$(this.form).trigger("submit") //화면전환돼서 나와
      
     let image = $(this).val();
     console.log(image);
     imageArea.empty();
      if(image){ //그릴 이미지가 있을 경우
         let src = SRCPTRN.replace("%v", image);
         let imgTag = $("<img>").attr("src", src)
         imageArea.html(imgTag);
      }
      return true;
   });
   //form태그 중 1번째 폼만 사용하겠다 
   $("form:first").on('submit', function(event) {
      console.log(event);
      let value = $(this.image).val();
      console.log(value);
      let valid = true;
      if(!value){
         console.log("파라미터 누락");
         valid = false;
         $(this.image).focus();
      }
      return valid;
   });
});

</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/image.do">
   <select name="image" required>
      <option value>이미지 선택</option>
   <%
      for(File image : images){
   %>
         <option><%=image.getName() %></option>
   <%      
      }
   %>
   </select>
</form>
<div id="imageArea"></div>
</body>
</html>