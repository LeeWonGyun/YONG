package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리용 Persistence Layer 
 *
 */
public interface ProdDAO {
	public int insertProd(ProdVO prod);
	
	public int selectTotalRecord(PagingVO<ProdVO> pagingVO);
	
	public List<ProdVO> selectProdList(PagingVO<ProdVO> pagingVO);
	
	public ProdVO selectProd(String prodId); //아이디가 없으면 널값이 돌아옴
	
	public int updateProd(ProdVO prod);
	
//	public int deleteProd(); //상품에 대해서 자식이 너무 많이 파생이 된다.
}
