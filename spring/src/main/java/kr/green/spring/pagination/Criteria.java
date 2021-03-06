package kr.green.spring.pagination;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Criteria {
	@Getter
	private int page; 
	@Getter
	private int perPageNum;
	@Getter
	private String search;
	@Getter
	private int type;
	//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.search = "";
		//int는 기본 초기값이 0
		//String은 기본값이 null
		
		this.type = 0;
		
	}
	public Criteria(int page, int perPageNum) {
		setPage(page);
		setPerPageNum(perPageNum);
	}
	//getter and setter
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		//현재 페이지 번호를 음수로 설정하려 할 때
		if(page <= 0) {
			this.page = 1;
		}
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		/* 한 페이지에 컨텐츠 수를 1이상 100이하로 설정
		개발자 설정에 따라 100부분을 수정할 수 있음 */
		if(perPageNum <=0 || perPageNum > 100) {
			this.perPageNum = 10;
		}
		else
			this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}
