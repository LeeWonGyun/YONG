package kr.or.ddit.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/login/loginProcess.do")
public class loginProcessServlet extends HttpServlet{
	
	private AuthenticateService service = new AuthenticateServiceImpl();
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String mem_id = req.getParameter("mem_id");
      String mem_pass = req.getParameter("mem_pass");
      MemberVO member = new MemberVO(mem_id, mem_pass);
      
      boolean valid = validate(member);   // 검증 
      String location = null;
      String message = null;
      HttpSession session = req.getSession();
      
      if(valid) {   // valid한 상황과 그렇지않은 상황을 식별
    	  ServiceResult result = service.authenticated(member);
         if(ServiceResult.OK.equals(result)) {   // 인증을 확인하고 성공/실패 식별 
            location = "/index.jsp";   
//            resp.sendRedirect(location); // 로그인 성공시 기존 정보는 필요없다 => redirect로 전송
            session.setAttribute("authMember", member);   // 로그인 세션을 설정 => authMember가 만들어짐  
         }else {
            location = "/login/loginForm.jsp";  
            session.setAttribute("failId", member.getMemId());
            if(ServiceResult.NOTEXIST.equals(result)) {
            	message = "아이디가 잘못됐음. 확인하셈.";
            	
            } else {
            	message = "비밀번호가 잘못됐음. 확인하셈.";
            }
//            req.getRequestDispatcher(dest).forward(req, resp);   // request에 ID정보가 남겨있음. 로그인 실패시 ID는 남겨놓을 것이므로, request를 유지하기위해 Dispatcher로 함. // 이걸로 할꺼면 경로 서버사이드
         }
      }else {
//         resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//         String dest = req.getContextPath() + "/login/loginForm.jsp"; 
         location = "/login/loginForm.jsp";
         message = "아이디나 비번이 누락됐음.";
//         resp.sendRedirect(dest);
      }
      session.setAttribute("message", message);
      resp.sendRedirect(req.getContextPath() + location);
   }


   private boolean validate(MemberVO member) {   // SQL 인젝션 막을 수 있도록 여기서 세팅할 수 있다. 
      boolean valid = true; 
      if(StringUtils.isBlank(member.getMemId())) {   // null체킹, 화이트스페이스 체킹 후 결과를 돌려줌 
         valid = false;
      }
      if(StringUtils.isBlank(member.getMemPass())) {   // null체킹, 화이트스페이스 체킹 후 결과를 돌려줌 
         valid = false;
      }
      return valid; 
   }
   
}