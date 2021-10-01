package kr.or.ddit.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 전체 페이징 속성을 연산하기 위해, setTotalRecord와 setCurrentPage 호출 필요.
 * 
 */
@Getter
@NoArgsConstructor
public class PagingVO<T> {
	
	public PagingVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}

	private int totalRecord;
	private int screenSize = 10;
	private int blockSize;
	private int currentPage;
	
	private int totalPage;
	private int endRow;
	private int startRow;
	private int endPage;
	private int startPage;
	
	private List<T> dataList;
	
	//단순 키워드 검색용
	private SearchVO searchVO;
	
	public void setSearchVO(SearchVO searchVO) {
		this.searchVO = searchVO;
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (totalRecord + (screenSize-1))/screenSize;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;
		startRow = endRow - (screenSize -1);

		endPage = blockSize * ((currentPage + (blockSize - 1))/blockSize);
		startPage = endPage - (blockSize -1);
	}
	
//	<a href="?page=1">1</a>
	private static final String PAGINGPATTERN = "<a href='#' data-page='%d'>%s</a>";
	private static final String CURRENTPATTERN = "<a href='#'>[%s]</a>";
	public String getPagingHTML() {
		StringBuffer html = new StringBuffer();
		endPage = endPage > totalPage ? totalPage : endPage;
		if(startPage > blockSize) { //이전 페이지
			html.append(String.format(PAGINGPATTERN, (startPage - blockSize), "이전")); 
		}
		for(int page = startPage; page <= endPage; page++) {
			if(page == currentPage) {
				html.append(String.format(CURRENTPATTERN, page));
			} else {
				html.append(String.format(PAGINGPATTERN, page, page));
			}
		}
		if(endPage < totalPage) { //다음 페이지
			html.append(String.format(PAGINGPATTERN, (endPage + 1), "다음"));
		}
		return html.toString();
	}
}