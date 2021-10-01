package kr.or.ddit.servlet03;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sampleProcess.do") //server side는 상대경로 ㄴㄴ, form.jsp에 있는 곳에서 파일을 찾으려면 우선 jsp가 있는 03폴더에서 먼저 찾는다.
public class SampleProcessServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String textParam = req.getParameter("textParam");
		String numberParam = req.getParameter("numberParam");
		String radioParam = req.getParameter("radioParam"); //어떠한 라디오버튼도 선택하지않으면 null값이 들어간다.
		String[] checkParam = req.getParameterValues("checkParam"); //다중상속을 하기 때문에 그냥 String만 할 시에는 값 1개만 가져오기 때문에 배열을 선택
		String singleSelect = req.getParameter("singleSelect");
		String[] multiSelect = req.getParameterValues("multiSelect");

		System.out.printf("textParam : %s\n", textParam);
		System.out.printf("numberParam : %s\n", numberParam);
		System.out.printf("radioParam : %s\n", radioParam);
		System.out.printf("checkParam : %s\n", Arrays.toString(checkParam));
		System.out.printf("singleSelect : %s\n", singleSelect);
		System.out.printf("multiSelect : %s\n", Arrays.toString(multiSelect));
		
		Map<String, String[]> parameterMap = req.getParameterMap();
		for(Entry<String, String[]> entry : parameterMap.entrySet()) { //향상된 for문이 collection 일때 사용한다.
			String name = entry.getKey();
			String[] values = entry.getValue();
			System.out.printf("%s : %s\n", name, Arrays.toString(values));
		}
		
		Enumeration<String> names = req.getParameterNames();//Map의 Key만 꺼내올 수 있다.
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] values = req.getParameterValues(name);
			System.out.printf("%s : %s\n", name, Arrays.toString(values));
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get callback");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post callback");
	}
}
