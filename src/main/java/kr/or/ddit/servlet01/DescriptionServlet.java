package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿
 * : 웹상에서 발생하는 요청을 받고, 그에 따른 동적인 응답을 생성할 수 있는 객체에 대한 명세서(specification)
 * 
 * 개발 단계
 * 1) HttpServlet의 상속으로 스펙에 따른 객체 정의
 * 2) 컴파일 -> /WEB-INF/classes에 클래스 배포
 * 3) 서블릿 컨테이너에 해당 서블릿을 등록.
 * 		2.5버전 : web.xml에 서블릿을 등록 -> servlet -> servlet-name, servlet-class
 * 		3.X버전 : @WebServlet 어노테이션 사용가능
 * 4) 등록된 서블릿에 url-pattern 매핑
 * 5) restart. 즉, 컨테이너를 재구동 시켜준다.
 * 
 * servlet container : servlet의 lifecycle 관리자 -> 시스템(servlet container)을 호출하면 콜백을 한다.
 * 생성 : 컨테이너가 해당 서블릿에 매핑된 최초의 요청을 받았을 때 생성. load-on-startup 옵션으로 생성 시점을 당길 수 있다. -> init
 * 요청 : 요청의 처리 순서(service-template), request method에 따라 구체적인 작업(doXXX - hookmethod)에서 처리한다.
 * 소멸 : destroy가 callback으로 호출되지만, 호출 구조를 장담할 수 없다.
 *
 * 모델1구조 : 응답과 요청이 하나로
 * 모델2구조 : 응답과 요청이 각각
 */


public class DescriptionServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println(getClass().getName()+"이 생성됨.");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service메소드 호출");
//		super.service(arg0, arg1);
		System.out.println("service메소드 종료");
	} 
	//템플릿 메소드 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// do계열을 override 할 경우에는 super 코드를 없애야한다. 있으면 오류 뜸.
		System.out.println("doGet메소드 호출");
	}
	//호출이 아닌 구체적인 작업을 나타내는 메소드를 후크메소드
	@Override
	public void destroy() {
		super.destroy();
		System.out.println(getClass().getName()+"이 소멸됨.");
	}
}
