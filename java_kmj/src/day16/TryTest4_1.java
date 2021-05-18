package day16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryTest4_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수와 산술연산자를 입력하세요(예: 1 + 2) : ");
		try {
			int num1 =scan.nextInt();
			
			char op = scan.next().charAt(0); 
			double res = 0.0;
			int num2 = scan.nextInt();
			
			res = calculate(num1, op, num2);
			
			switch(op){
			 case '+' :
				 res = num1 + num2;
				 break;
			 case '-' :
				 res = num1 - num2;
				 break;
			 case '*' :
				 res = num1 * num2;
				 break;
			 case '/' :
				 res = (double)num1 / num2;
				 break;
			 case '%' :
				 res = num1 % num2;
				 break;
			default:
				throw new Exception("잘못된 연산자입니다.");	 
			}
			System.out.println(""+num1 + op + num2 + "=" + res);
			
		}catch(InputMismatchException e) {
		System.out.println("0으로 나눌 수 없습니다.");
		}catch(Exception e) {
		System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료합니다.");
		scan.close();
		
	}
	/* 기능 : 두 정수와 산술연산자가 주어지면 산술 연산 결과를 알려주는 메소드
	* 매개변수 : 두 정수, 산술 연산자 =>int num1,  char op, int num2.
	* 리턴타입 : 산술 연산 결과 => 실수 => double
	* 메소드명 : calculate
	* */
	public static double calculate(int num1, char op, int num2) {
		double res = 0.0;
		switch(op){
		 case '+' :
			 res = num1 + num2;
			 break;
		 case '-' :
			 res = num1 - num2;
			 break;
		 case '*' :
			 res = num1 * num2;
			 break;
		 case '/' :
			 //num2가 0이어도 실수 / 정수 이어서 예외가 자동으로 발생하지 않아서 예외를 발생 시키기 위해 if문과 throw를 사용
			 if(num2 == 0) {
				 throw new ArithmeticException("0으로 나눌 수 없습니다.");
			 }
			 res = (double)num1 / num2;
			 break;
		 case '%' :
			 //num2가 0인 경우 예외가 자동으로 발생되지만 if문과 throw를 쓰는 이유는 예외 메세지를 한글로 하고 싶어서
			 if(num2 == 0) {
				 throw new ArithmeticException("0으로 나눌 수 없습니다.");
			 }
			 res = num1 % num2;
			 break;
		default:
			//잘못된 연산자가 들어오면 예외를 발생시킴
			throw new RuntimeException("잘못된 연산자입니다.");	 //떠넘긴거
		}
		return res;
	}
}
