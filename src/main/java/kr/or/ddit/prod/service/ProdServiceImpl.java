package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService{
	private ProdDAO dao = new ProdDAOImpl(); //다오와의 의존관계
		
	@Override
	public ServiceResult createProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVO> retrieveProdList(PagingVO<ProdVO> pagingVO) {
		int totalRecord = dao.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<ProdVO>prodList = dao.selectProdList(pagingVO);
		pagingVO.setDataList(prodList);
		return prodList;
	}

	@Override
	public ProdVO retrieveProd(String prodId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
