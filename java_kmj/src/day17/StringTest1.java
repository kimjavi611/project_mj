package day17;

import java.util.Scanner;

public class StringTest1 {

	public static void main(String[] args) {
		//charAt()메소드 예제
		Scanner scan = new Scanner(System.in);
		System.out.println("문자를 입력");
		//char op = scan.next().charAt(0);//체이닝 => 리턴타입이 클래스인 경우에 연달아 메소드를 호출하는 것
		//Scanner 클래스에서 제공하는 next()라는 메소드를 통해 콘솔에서 입력받은 문자열을 가져옴
		String str = scan.next();
		//String 클래스에서 제공하는 charAt()이라는 메소드를 통해 0번지에 있는 문자를 가져옴 
		char op = str.charAt(0);
		System.out.println("입력 문자 : " + op);
		scan.close();
		
		
	}

}