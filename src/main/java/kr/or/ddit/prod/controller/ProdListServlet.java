package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;
import kr.or.ddit.vo.SearchVO;

/**
 * 검색 조건 : 상품명, 거래처명, 분류명 세가지 검색 타입으로 검색 가능.
 * 1. 세가지 검색 조건 중 하나만을 사용해서 검색. (이름이면 이름, 거래처면 거래처 등) 회원 목록조회랑 같다.
 * 		동기 요청으로 처리
 * 2. 두 가지 이상의 검색 조건을 동시 사용.
 * 		비동기 요청으로 처리
 * 
 */
@WebServlet("/prod/prodList.do")
public class ProdListServlet extends HttpServlet{
	private ProdService service = new ProdServiceImpl(); //서비스와의 의존관계 설정
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int currentPage = 1;
		String pageParam = req.getParameter("page");
		if(StringUtils.isNumeric(pageParam)) {
			currentPage = Integer.parseInt(pageParam); //pageParam을 int로 바꿔줌.
		}
		//모든 페이징 처리는 위 과정과 거의 비슷하다.
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		SearchVO searchVO = new SearchVO(searchType, searchWord);
		
		PagingVO<ProdVO> pagingVO = new PagingVO<>(5,3);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);
		
		service.retrieveProdList(pagingVO);
		
		req.setAttribute("pagingVO", pagingVO);
		
		String viewName = "prod/prodList"; // => logical view name => 완전한 주소가 아니라 아래 prefix랑 suffix가 합쳐져야 한다. 
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
		}
}
