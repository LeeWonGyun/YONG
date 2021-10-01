package kr.or.ddit.servlet01;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;
import java.util.*;


//@WebServlet("/01/now.tmpl")
public class TimeServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws IOException, ServletException {
		
		 
//		   1. Mime 설정
		resp.setContentType("text/html;charset=UTF-8");
//		   2. tmpl파일 읽기
		String tmplpath = req.getServletPath();
		InputStream is = getServletContext().getResourceAsStream(tmplpath);
		StringBuffer templSrc = new StringBuffer();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		String temp = null;
		while((temp = reader.readLine()) != null){
			templSrc.append(String.format("%s\n", temp));
		}
		//readLine으로 한번에 한 줄씩 읽어올 수 있다.
//		   3. 데이터 생성
		Calendar cal = Calendar.getInstance();
		Object data = String.format("%tc", cal);
//		   4. 데이터 치환(넣기)
		String html = templSrc.toString().replace("%now%", data.toString());
//		   5. 응답 전송
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.println(html);
		} finally {
			if(out != null)
				out.close();
		}
		
	}
	
}

