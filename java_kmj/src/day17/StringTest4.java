package day17;

import java.util.Scanner;

public class StringTest4 {

	public static void main(String[] args) {
		//System.out.println("제 이름은 홍길동입니다.".replace("홍길동", "임꺽정"));//원하는 단어, 문자(열), 패턴 등으로 바꿀 수 있다.
		/* 문자열C를 입력받고, 해당 단어에 교체할 문자열A와 문자열B를 입력받아 
		 * 문자열C에 있는 문자열A를 문자열 B로 바꾸는 코드를 작성하세요.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("단어를 입력하세요 : ");
		String strC = scan.next();
		System.out.print("수정할 단어를 입력하세요(예: 수정전단어 수정할단어) : ");
		String strA = scan.next();
		String strB = scan.next();
		if(strC != null && strC.indexOf(strA) != -1) {
			strC = strC.replace(strA, strB);
			System.out.println("바뀐 단어 : " + strC);
		}else {
			System.out.println("단어를 바꿀 수 없습니다.");
		}
		scan.close();

	}
	
}
