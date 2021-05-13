package accountbook;
/* 가계부 프로그램을 구현하려고 한다. 이 때 필요한 클래스를 만들어 보세요
 * */ 
import java.util.Scanner;

public class AccountBook {

	public static void main(String[] args) {
		
		//카테고리 제공
		do {
			System.out.println("1. 날짜입력");
			System.out.println("2. 수입,지출 기록");
			System.out.println("3. ");
		}while();
		
		//날짜 입력 받음
		System.out.println("기록할 날짜를 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		int date =scan.nextInt();
		scan.close();
		
	}
	
	
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
