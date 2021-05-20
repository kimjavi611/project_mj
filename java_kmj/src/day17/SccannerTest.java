package day17;

import java.util.Scanner;

public class SccannerTest {

	public static void main(String[] args) {
		/* next() : 공백(엔터, 스페이스)을 만나기전까지 문자열을 가져오는 메소드
		 * nextLine() : 처음 만나는 엔터전까지 문자열을 가져오는 메소드
		 * */
		Scanner scan = new Scanner("1234 1234\n4567\n9010\n++++++\n");//System.in은 표준입력 => 문자열을 입력하면 지정된 문자열을 스캔할 수 있음 
		while(scan.hasNext()) {//스캐너에 있는 정보들중에 다음에 올게 있는지 없는지 체크 (다음애가 있는지를 물어보는거)
			String str =scan.nextLine();
			System.out.println(str);
			if(str.length() != 0) {
				System.out.println(str);
			}
		}
		//String str = scan.next();
		/*String str = scan.nextLine();	//1234 1234를 추출 => 공백을 만남(\n) => 1234 1234를 추출하고 공백을 버림
		System.out.println(str);
		System.out.println("------");
		str = scan.nextLine();			//4567을 추출 => 
		System.out.println(str);
		System.out.println("------");
		int num = scan.nextInt();		//9010을 추출 int는 정수만이기 때문에 공백을 두고 9010만 출력
		System.out.println(num);
		System.out.println("-----");
		str = scan.nextLine();			//빈공백을 추출
		System.out.println(str);
		System.out.println("-----");*/
		scan.close();
		
	}

}
