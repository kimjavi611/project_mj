package home;

import java.util.Scanner;

public class If3 {

	public static void main(String[] args) {
		/* 국어 성적을 입력받고 국어 과목을 패스했는지 안했는지 확인하는 코드를 작성하세요.
		 * 국어 성정이 60점 미만이면 faill, 국어 성적이 60점 이상이면 Pass
		 * */
		int kor;
		System.out.println("국어 성적을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		kor = scan.nextInt();
		if(kor >= 60) {
			System.out.println("Pass");
		}else {
			System.out.println("Faill");
		}
		
		//조건선택연산자 이용
		
		String result = 90 <= kor && kor<=100 ? "Pass" : "Faill";
		System.out.println("국어 성적은 패스했습니까?" + result);
		
		scan.close();

	}

}
