package accountbook;

import java.util.Scanner;

public class AccountBookProgram {
	AccountBook2 book;
	Scanner scan = new Scanner(System.in);
	
	/* 기능 : 내역을 입력받아 가계부에 저장하는 메소드
	 * 매개변수 : 내역 => 입력받을거라서 > 없음
	 * 리턴타입 : 없음
	 * 메소드명 : contents
	 *  */
	public void contents() {
		System.out.println("<< 가계부를 작성하세요 >>");
		System.out.println("날짜 :  ");
		String date =scan.next();
		System.out.println("타입(수입/ 지출) : ");
		String type = scan.next();
		System.out.println("결제타입 ");
	}
	
	/* 기능 : 수정할 내역을 입력받아 수정내역을 저장하는 메소드
	 * 매개변수 : 
	 * 리턴타입 :
	 * 메소드명 : 
	 * */
	
	int index = scan.nextInt();
	//수정내용입력
	
	//입력된 아이템에서 수정할 번호(index)을 가져와서 수정
	
	/* 기능 : 삭제할 내역을 입력받아 삭제하는 메소드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메소드명 :
	 * */
	
	/* 기능 : 가계부 내역 전체를 확인하는 메소드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메소드명 :
	 * */ 
	
	/* 기능 : 가계부 작성을 종료하는 메소드
	 * 매개변수 :
	 * 리턴타입 :
	 * 메소드명 :
	 * */
}
