//package kr.or.ddit.member.controller;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.security.sasl.SaslException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import kr.or.ddit.db.ConnectionFactory;
//import kr.or.ddit.enumpkg.ServiceResult;
//import kr.or.ddit.member.service.MemberService;
//import kr.or.ddit.member.service.MemberServiceImpl;
//import kr.or.ddit.vo.MemberVO;
//
//@WebServlet("/memeber/memberUpdate.do")
//public class MemberUpdateServlet2 extends HttpServlet{
//	private MemberService service = new MemberServiceImpl();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String viewName = "member/memberForm";
//
//		String prefix = "/WEB-INF/views/";
//		String suffix = ".jsp";
//		req.getRequestDispatcher(prefix + viewName + suffix).forward(req, resp);
//	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		req.setCharacterEncoding("UTF-8");
////		1. 파라미터 확보
//		MemberVO member = new MemberVO();
//		req.setAttribute("member", member);
//		
//		Map<String, String[]> parameterMap = req.getParameterMap();
//		try {
//			BeanUtils.populate(member, parameterMap);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			throw new ServletException(e);
//		}
////		2. 검증
//		Map<String, String> errors = new LinkedHashMap<>();
//		req.setAttribute("errors", errors);
//		boolean valid = validate(member, errors);
//		String viewName = null;
//		String message = null;
//		if(valid) {
////			3.1 통과
//			ServiceResult result = service.modifyMember(member);
//			switch(result) {
//			case OK:
//				viewName = "redirect:/";
//				break;
//			default:
//				viewName = "member/memberForm";
//				message = "서버 오류, 잠시 후 다시 하세요";
//			}
//			
//		} else {
//			viewName = "member/memberForm";
//		}
//		req.setAttribute("message", message);
//		if(viewName.startsWith("redirect:")) {
//			viewName = viewName.substring("redirect:".length());
//			resp.sendRedirect(req.getContextPath() + viewName);
//		} else {
//			String prefix = "/WEB-INF/views/";
//			String suffix = ".jsp";
//			req.getRequestDispatcher(prefix + viewName + suffix).forward(req, resp);
//		}
//	}
//	private boolean validate(MemberVO member, Map<String, String> errors) {
//		boolean valid = true;
//		
//		
//		if (StringUtils.isBlank(member.getMemPass())) {
//			valid = false;
//			errors.put("memPass", "회원비밀번호가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemName())) {
//			valid = false;
//			errors.put("memName", "회원명가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemRegno1())) {
//			valid = false;
//			errors.put("memRegno1", "주민번호1가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemRegno2())) {
//			valid = false;
//			errors.put("memRegno2", "주민번호2가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemZip())) {
//			valid = false;
//			errors.put("memZip", "우편번호가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemAdd1())) {
//			valid = false;
//			errors.put("memAdd1", "주소1가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemAdd2())) {
//			valid = false;
//			errors.put("memAdd2", "주소2가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemHometel())) {
//			valid = false;
//			errors.put("memHometel", "집전번가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemComtel())) {
//			valid = false;
//			errors.put("memComtel", "회사전번가(이) 누락되었음.");
//		}
//		if (StringUtils.isBlank(member.getMemMail())) {
//			valid = false;
//			errors.put("memMail", "이메일가(이) 누락되었음.");
//		}
//		return valid;
//	}
//
//}
