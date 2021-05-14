package accountbook;
/* 가계부 프로그램을 구현하려고 한다. 이 때 필요한 클래스를 만들어 보세요
 * */ 


public class AccountBook {
	 //-수입 내역, 지출 내역을 관리하기 위한 가계부 클래스
	//멤버변수 
	//
	//멤버메소드
	/*메뉴를 알려주는 메소드 
	 1. 수입내역 입력
	 2. 지출내역 입력
	 3. 잔액 확인
	 4. 수정
	 5. 종료
	

	*/
	private Item [] arr;//가게부 내역들
	private int count;//저장된 내역들 갯수
	private int total;//내역에 기입된 금액의 총 양
	//타입,날짜,결제방법,카테고리=> 선택하는거 입력받아야함=> 
	/* 기능 : 내역이 주어지면 주어진 내역을 가계부에 저장하는 메소드
	 * 매개변수 : 주어진 내역들 => String type, String date, String paymentType, String category, String contents, int cost  
	 * 리턴타입 : 없음 => void
	 * 메소드명 : accountList
	 */
	public void accountLIst(String type, String date, String paymentType, String category, String contents, int cost) {
		
	}
	
	 /*  기능 : 입력한 내역을 확인하는 메소드
	 *  매개변수 : 입력된 가계부 내역들 => Item[]arr
	 *  리턴타입 : 
	 *  
	 *  기능 : 입력한 내역을 수정하는 메소드
	 *  
	 *  기능 : 입력한 내역을 삭제하는 메소드
	 *  
	 *  기능 : 입력한 내역들의 총 금액(잔액?)을 알려주는 메소드
	 *  
	 *  기능 : */
	
	
	
	
		
		
	
	
	
}


//가계부 => 카테코리  
//날짜, 수입 금액, 수입 내용, 지출 금액, 지출 내용, 총수입액, 총지출액, 잔액 표시 필요
// 기록할 날짜 입력받음
//수입,지출 기록 선택
//분류 : 식비/ 교통 / 건강
//금액 입력
//내용 입력
//총 금액 합산, 출력
// 잔액 표시(원래있던거 + 총 수입 -총 지출)

//클래스 필요? =>  
