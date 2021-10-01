package kr.or.ddit.bokseap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/image2.do")
public class ImageServlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException
	{
		File folder = new File("d:/contents");
		
		File imageFile = new File(folder, req.getParameter("image"));
		//jsp에서 보낸 name의 파라미터값을 가져오기 => req.getParameter("name 이름")
		String mime = getServletContext().getMimeType(imageFile.getName());
		
		resp.setContentType(mime);
		
		FileInputStream fis = new FileInputStream(imageFile);
		byte[] buffer = new byte[1024];
		int count = -1;
		OutputStream os = resp.getOutputStream();
		while((count = fis.read(buffer)) != -1) {
			os.write(buffer, 0, count);
		
		}
		fis.close();
		os.flush();
		os.close();
		
	}
	
}*/