package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/member/memberList.do")
public class MemberListServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	private void makeModel(HttpServletRequest req) {
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		SearchVO searchVO = new SearchVO(searchType, searchWord);
		log.debug("searchType={}",searchType);
		log.debug("searchWord={}",searchWord);
		log.debug("searchVO={}",searchVO);
		
		int currentPage = 1;
		String pageParam = req.getParameter("page");
		if(StringUtils.isNumeric(pageParam)) { //페이지 숫자가 맞으면..
			currentPage = Integer.parseInt(pageParam);
		}
		
		PagingVO<MemberVO> pagingVO = new PagingVO<>(5, 3);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);
		
		List<MemberVO> memberList = service.retrieveMemberList(pagingVO);
		pagingVO.setDataList(memberList);;
		
		req.setAttribute("pagingVO", pagingVO);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String accept = req.getHeader("Accept");
		//검증 할 필요 없는 데이터
		
		makeModel(req);
		
		if(accept.contains("json")) {
			resp.setContentType("application/json;charset=UTF-8");
			PagingVO<MemberVO> pagingVO = (PagingVO) req.getAttribute("pagingVO");
			try(
				PrintWriter out = resp.getWriter();
			) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(out, pagingVO);
			}
			
		} else {
			String viewName = "member/memberList";
			
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		}
		
	}
}