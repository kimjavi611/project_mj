package day2;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		/*국어, 영어, 수학 성적을 입력받아 출력해보세요.
		 * 단, 성적은 0~100점 사이의 실수*/
		
		
				
		double kor, eng, math; //타입이 동일한 경우 ,이용해서 한꺼번에 선언 할 수 있따.
		System.out.print("국어, 영어, 수학 성적을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		
		kor = scan.nextDouble();
		eng = scan.nextDouble();
		math = scan.nextDouble();
		
		System.out.println("국어 : " + kor + "점");
		System.out.println("영어 : " + eng + "점");
		System.out.println("수학 : " + math + "점");
		
		scan.close();
		
			

	}

}
