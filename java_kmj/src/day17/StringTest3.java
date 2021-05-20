package day17;

import java.util.Scanner;

public class StringTest3 {

	public static void main(String[] args) {
		//System.out.println("abcdef".indexOf("bc"));//출력하는 문자열의 첫번째 문자의 번지를 알려줌
		//System.out.println("abcdef".indexOf("dc"));
		/* 두 단어 단어 A와 단어 B를 입력받고 단어 A에 단어 B가 있는지 없는지 확인하는 코드를 작성하세요
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 단어를 입력하세요 : ");
		String str1 = scan.next();
		String str2 = scan.next();
		if(str1 != null && str1.indexOf(str2)!= -1 ){//indexOf 1 -1로 나옴// -1아니다 또는 0보다 같거나 크다로 표현해서 비교해야 함
			System.out.println(str1 + "에는 " + str2 + "가 포함되어 있습니다.");
		}else {
			System.out.println(str1 + "에는 " + str2 + "가 포함되어 있지않습니다.");
		}
		if(str1 != null) {
			//문자열의 길이 
			System.out.println(str1 + "의 길이 : " + str1.length());//홈페이지 아이디나 비밀번호 만들때 최소 글자 체크할때 이용할 수 있음
		}
		int[] arr = new int[5];
		System.out.println(arr.length);//배열의 길이 
		scan.close();	
	}

}
