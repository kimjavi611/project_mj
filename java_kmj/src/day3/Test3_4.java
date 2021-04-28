package day3;

import java.util.Scanner;

public class Test3_4 {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자를 입력받아 계산 결과를 출력하는 예제를 switch문으로 작석하세요. */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술연산자를 입력 하세요 : ");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		char op =scan.next().charAt(0);
		
		System.out.println(num1 + op + num2);
		
		switch(op) {
		case '+':
			System.out.println("" + num1 + op + num2 + "=" + (num1 + num2) );
			break;
		case '-':
			System.out.println("" + num1 + op + num2 + "=" + (num1 - num2) );
			break;
		case '*':
			System.out.println("" + num1 + op + num2 + "=" + (num1 * num2) );
			break;
		case '%':
			System.out.println("" + num1 + op + num2 + "=" + (num1 % num2) );
			break;
		case '/':
			System.out.println("" + num1 + op + num2 + "=" + ((double)num1 / num2) );
			break;
		default :
			System.out.println(op + "는 산술연산자가 아닙니다." );
		
		}
		
		scan.close();

	}

}
