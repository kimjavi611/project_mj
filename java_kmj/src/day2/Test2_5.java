package day2;

import java.util.Scanner;

public class Test2_5 {

	public static void main(String[] args) {
		/* 정수를 입력받아 6의 배수이면 6의 배수라고 출력하고,
		 * 2의 배수이면 2의 배수라고 출력하고,
		 * 3의 배수이면 3의 배수라고 출력하고.
		 * 2,3,6의 배수가 아니면 2,3,6의 배수가 아닙니다라고 출력하는 코드를 작성하세요.
		 * 단, 6,12와 같이 6의 배수인 경우는 6의 배수입니다라고 하나만 출려되어야합니다.*/
		
		int num = 4;
		if(num % 6 == 0) {
			System.out.println(num + "는 6의 배수");
		} else if(num % 2 == 0 ) {
			System.out.println(num + "는 2의 배수");
		} else if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수");
		} else {
			System.out.println(num + "sms 2,3,6의 배수가 아닙니다.");
		}
		
		
		
		
	}

}
