package kr.or.ddit.bokseap;
//package kr.or.ddit.servlet02;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/image2.do")
//public class ImageServlet3 extends HttpServlet {
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//	throws IOException, ServletException
//	{
//		File folder = new File("d:/contents");
//		String child = req.getParameter("image");
//		// 
//		if(child == null) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			return;
//		}
//		//가져오는 파라미터값이 없으면 400 에러를 낸다.
//		File imageFile = new File(folder, child);
//		if(!imageFile.exists()) {
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
//		//만약 파일이 존재하지 않는다면 404 에러를 낸다.
//		
//		String mime = getServletContext().getMimeType(imageFile.getName());
//		if(mime == null || !mime.startsWith("image/")) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//		}
//		//mime이 없거나 이미지가 아닌 파일을 요청했을 때 400 에러를 낸다.
//		resp.setContentType(mime);
//		
//		FileInputStream fis = new FileInputStream(imageFile);
//		byte[] buffer = new byte[1024];
//		int count = -1;
//		OutputStream os = resp.getOutputStream();
//		while((count = fis.read(buffer)) != -1) {
//			os.write(buffer, 0, count);
//		}
//		fis.close();
//		os.flush();
//		os.close();
//	}
//}