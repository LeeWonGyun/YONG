////package kr.or.ddit.servlet02;
////
////import java.io.*;
////import javax.servlet.*;
////import javax.servlet.http.*;
////import javax.servlet.annotation.*;
////
//////client의 명령어 : http://localhost/dummy/image.do
//////callback method
////
////@WebServlet("/image.do")
////public class ImageServlet extends HttpServlet{
////   @Override
////   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////    //여기서 만든 if문들은 다 클라이언트 문제의 예시를 들어 400대의 에러를 내보내게 만드는 거야 -- server side 검증
////      String image = req.getParameter("image");
////      if(image == null) {
////         resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
////         return;
////      }
////      
////      File folder = new File("D:/contents");
////      
////      File imageFile = new File(folder, image);
////      if(!imageFile.exists()) {
////         resp.sendError(HttpServletResponse.SC_NOT_FOUND);
////         return;
////      }
////      
////      String mime = getServletContext().getMimeType(imageFile.getName());
////      if(mime == null || !mime.startsWith("image/")) {
////         resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
////         return;
////      }
////      
////      resp.setContentType(mime);
////      
////      FileInputStream fis = new FileInputStream(imageFile);  //inputstream있는 정보의  값을 읽어들이는 거야
////      byte[] buffer = new byte[1024];
////      int count = -1;
////      
////      OutputStream os = resp.getOutputStream();  //내가 만든 값을 폴더로 빼내는 거
////            
////      while((count = fis.read(buffer)) != -1) {
////         os.write(buffer, 0, count);
////      }
////      os.flush();
////      os.close();
////      fis.close();
////   }
////}
//
//package kr.or.ddit.servlet02;
//import javax.servlet.http.*;
//import javax.servlet.*;
//import java.io.*;
//import javax.servlet.annotation.*;
//
////client 의 명령어 : http://localhost/dummy/image.do
////callback method
//
//@WebServlet("/image.do")
//public class ImageServlet2 extends HttpServlet{
//   public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//      
//      File folder = (File) getServletContext().getAttribute("contentFolder");
//      String child = req.getParameter("image");
//      if(child==null) {
//         resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//         return;
//      }
//      File imageFile = new File(folder, child);
//      if(!imageFile.exists()) {
//         resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//         return;
//      }
//      
//      String mime = getServletContext().getMimeType(imageFile.getName());
//      if(mime==null || !mime.startsWith("image/")) {
//         resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//         return;
//      }
//      
//      resp.setContentType(mime);
//      
//      FileInputStream fis = new FileInputStream(imageFile);
//      byte[] buffer = new byte[1024];
//      int count = -1;
//      OutputStream os = resp.getOutputStream();
//      while((count = fis.read(buffer)) != -1){
//         os.write(buffer, 0, count);         
//      }
//      fis.close();
//      os.flush();
//      os.close();
//   }
//}