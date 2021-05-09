package home;

import java.util.Scanner;

public class If2 {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 입력받은 두 정수의 산술 연산 결과를 출력하는 예제
		 * 예시 
		 * 두 정수를 입력하세요 : 1 2
		 * 1 + 2 = 3
		 * 1 - 2 = -1
		 * 1 * 2 = 2
		 * 1 / 2 = 0.5
		 * 1 % 2 = 1
		 * */
		int num, num2;
		System.out.println("두 정수를 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.println(num + " + " + num2 + " = " + (num+num2));
		System.out.println(num + " - " + num2 + " = " + (num-num2));
		System.out.println(num + " * " + num2 + " = " + num*num2);
		System.out.println(num + " / " + num2 + " = " + ((double) num/num2));
		System.out.println(num + " % " + num2 + " = " + (num%num2));
		scan.close();

	}

}
