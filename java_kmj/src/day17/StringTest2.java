package day17;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		//equals()예제
		//System.out.println("홍길동".equals("홍길동"));
		/* 두 단어를 입력받아 두 단어가 같은 단어인지 확인하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		System.out.print(" 두 단어를 입력하세요 : ");
		String str1 = scan.next();
		String str2 = scan.next();
		//str1과 str2가 같다면 같은 단어라고 출력하고 다르면 다른 단어라고 출력
		if(str1 != null && str1.equals(str2)) {//null인지 체크하기!
			System.out.println("단어" + " " + str1 + "과 단어" + " " + str2 + "는 같은 단어입니다.");
		}else {
			System.out.println("단어" + " " + str1 + "과 단어" + " " + str2 + "는 다른 단어입니다.");
		}
		scan.close();
	}

}
