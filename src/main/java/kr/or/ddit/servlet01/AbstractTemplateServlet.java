package kr.or.ddit.servlet01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/01/now.tmpl") -> 자식클래스에서 사용
public abstract class AbstractTemplateServlet extends HttpServlet {
	
	protected abstract String getMimeType();
	
	private StringBuffer readTmpl(HttpServletRequest req) throws IOException {
		String tmplpath = req.getServletPath();
		InputStream is = getServletContext().getResourceAsStream(tmplpath);
		StringBuffer templSrc = new StringBuffer();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		String temp = null;
		while((temp = reader.readLine()) != null){
			templSrc.append(String.format("%s\n", temp));
		}
		return templSrc;
	}
	
	protected abstract void makeData(HttpServletRequest req);
	//Request안에 map이 포함되어있다.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super를 없앤다는 것은 내 마음대로 순서를 조정하겠다는 뜻.
//		1. Mime
		String mime = getMimeType();
		resp.setContentType(mime);
//		2. read tmpl
		StringBuffer tmplSrc = readTmpl(req); //후크
//		3. 데이터 생성
		makeData(req);
//		4. 데이터 치환
		StringBuffer html = replaceData(req, tmplSrc);
//		5. 데이터 응답
		PrintWriter out = resp.getWriter();
		out.print(html);
		
	}

	private StringBuffer replaceData(HttpServletRequest req, StringBuffer tmplSrc) {
		String regex = "%(\\w+)%";
		Pattern regexPtrn = Pattern.compile(regex);
		Matcher matcher = regexPtrn.matcher(tmplSrc); //파싱이 되는 대상을 넘긴다.
		StringBuffer html = new StringBuffer();
		while(matcher.find()) {
			String dataName = matcher.group(1);
			Object value = req.getAttribute(dataName);
			String valueStr = Objects.toString(value, "");
			matcher.appendReplacement(html, valueStr);
		}
		matcher.appendTail(html);
		return html;
	}

}
