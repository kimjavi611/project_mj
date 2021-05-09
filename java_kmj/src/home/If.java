package home;

import java.util.Scanner;

public class If {

	public static void main(String[] args) {
		/*국어, 영어, 수학 성적을 입력받아 출력해보세요.
		 * 단, 성적은 0~100점 사이의 실수*/
		//성적을 입력받는다=> 입력하라고 내가 입력하고 입력내용을 스캐너로 받음.
		System.out.println("국어, 영어, 수학 성적을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		double kor, eng, math;
		kor = scan.nextDouble();
		eng = scan.nextDouble();
		math = scan.nextDouble();
		
		System.out.println("국어 성적 : " + kor + "점");
		System.out.println("영어 성적 : " + eng + "점");
		System.out.println("수학 성적 : " + math + "점");
		
		scan.close();
	}

}
