package kr.or.ddit.servlet06;

import static java.util.Calendar.getInstance;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/asd.do")
public class GetServerTimeServletbok extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 컨텐츠 : text/plain;charset=UTf-8로
		
		String language = req.getParameter("language"); //ko_KR, en_US 등등..
		Locale clientLocale = req.getLocale(); //Accept-Language
		if(language != null && !language.isEmpty()) { //language가 null이 아니고, 공백이 아닐 때
			clientLocale = Locale.forLanguageTag(language);
		}
		Calendar now = getInstance();
		String content = String.format(clientLocale, "%tc", now);
		resp.setContentType("text/plain;charset=UTF-8");
		try(
			PrintWriter out = resp.getWriter();	
		) {
			out.print(content);
		}
	}
}