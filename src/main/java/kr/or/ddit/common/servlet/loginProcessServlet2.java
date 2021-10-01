//package kr.or.ddit.common.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////@WebServlet("/loginProcess.do")
//public class loginProcessServlet2 extends HttpServlet{
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 클라이언트에서 아이디 비밀번호  파라미터로 받기
//		String mem_id = req.getParameter("mem_id");
//		String mem_pass = req.getParameter("mem_pass");
//		//
//		int sc = HttpServletResponse.SC_OK;
//		// 받은 내용 검증시 필수 파라미터 여부 확인 -> 잘못 전달시 클라이언트 잘못으로 400 에러
//		if(!mem_id.equals(mem_pass)) {
//				sc = HttpServletResponse.SC_BAD_REQUEST;
//				resp.sendError(sc);
//		}
//		// 잘 넘어 왔을 시, 인증여부 아이디와 비밀번호가 서로 같으면 인증 성공, 다르면 실패.
//		if(mem_id.equals(mem_pass)) {
//			req.getRequestDispatcher("/webStudy01/index.jsp").forward(req, resp);
//		}
//		// 성공 시 웰컴페이지 전송, 실패 시 다시 아이디와 비밀번호를 받는 페이지로 이동(loginForm) 실패시 무조건 비번이 잘못되었다고 뜬다. 잘못된 데이터만 입력할 수 있게 아이디는 남길 수 있게
//	}
//}
