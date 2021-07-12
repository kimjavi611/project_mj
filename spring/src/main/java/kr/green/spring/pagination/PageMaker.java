package kr.green.spring.pagination;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria criteria;
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		
		endPage = (int) (Math.ceil(criteria.getPage()/(double) displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;/* 현재 페이지메이커에 마지막 페이지에 컨텐츠의 마지막이 포함되어 있으면 next가 없어야 함 */
		next = endPage * criteria.getPerPageNum() >= totalCount ? false:true;
	}
	public PageMaker() {}
	

	public PageMaker(int totalCount, int displayPageNum, Criteria criteria) {
		super();
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.criteria = criteria;
		calcData();
	}
}