package day16;

import java.util.Scanner;

public class TryTest4 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술연산 결과를 출력하는 코드를 작성하세요
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요(예 1 + 2) : ");
		try {
			int num1 =scan.nextInt();
			char ch = scan.next().charAt(0);
			int num2 = scan.nextInt();
			if(ch == '+') {
				System.out.println(""+num1 + ch + num2 + "=" + (num1+num2));
			}else if(ch == '-') {
				System.out.println(""+num1 + ch + num2 + "=" + (num1 - num2));
			}else if(ch == '*') {
				System.out.println(""+num1 + ch + num2 + "=" + (num1*num2));
			}else if(ch=='/') {
				System.out.println(""+num1 + ch + num2 + "=" + (double)(num1/num2));
			}else if(ch == '%') {
				System.out.println(""+num1 + ch + num2 + "=" + (num1 % num2));
			}else {
				throw new Exception("잘못된 연산자입니다.");
			}
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료합니다.");
		scan.close();
		
	}
	

}

