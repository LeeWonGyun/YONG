package kr.or.ddit.common.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

@WebServlet("/login/logout.do")
public class logoutProcessServlet extends HttpServlet{
	//클라이언트에게서 로그아웃 요청 받음
	//PRG패턴 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) {//최초의 요청인지 확인
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
//		session.removeAttribute("authMember"); //invalidate를 사용함으로써 자동으로 하게 해준다.
		session.invalidate(); //invalidate를 사용함으로 세션을 만료시켰기 때문에 다른 기능은 이후로 사용 불가능.
		String message = URLEncoder.encode("로그아웃 성공", "UTF-8");
		resp.sendRedirect(req.getContextPath() + "/?message=" + message);
		
	}
}
