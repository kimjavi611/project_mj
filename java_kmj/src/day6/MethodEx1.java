package day6;

public class MethodEx1 {

	public static void main(String[] args) {
		// 메소드 예제
		//메소드명(값);
		add(1,2);//3; 동작은 되지만 단순입력이라 의미가 없음
		System.out.println(add(1,2));
		add2(1,2);
		
		printMultiTable(8);
		
		int num1 = 8, num2 =12;
		int res = gcd(num1, num2);
		System.out.println(num1 + "과" + num2 + "의 최대 공약수 : " + res);
		
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 "알려주는" 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 정수의 합 => 정수 => int
	 * 메소드명 : add
	 * */
	public static int add(int num1, int num2) {
		int res = num1 + num2;
		return res;//결과값은 return을 통해서 알려준다.
	}
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 "콘솔에 출력하는" 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 없음 => void
	 * 메소드명 : add2
	 * */
	public static void add2(int num1, int num2) {
		int res = num1 + num2;
		System.out.println(num1 + "+" + num2 + "=" + res);
	}
	/* 기능 : 두 정수와 산술 연산자가 주워지면 두 정수의 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수, 산술연산자 => int num1, int num2, char op(산술연산자)
	 * 리턴타입 : 산술 연산 결과 => 실수(정수/정수=>실수) => double
	 * 메소드명 : calculate
	 * */
	public static double cal(int num1, char op, int num2) { //선언할때 순서가 중요하지는 않음 
		return 0.0;
	}
	/* 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대공약수 => 정수 => int
	 * 매소드명 : gcd */
	public static int gcd(int num1, int num2) { 
		int i, k = 1;
		for(i = 1 ; i <= num2 ; i +=1 ) {
			if(num1 % i == 0 && num2 % i == 0) {
				k = i;// 메소드랑 변수 이름 같아도됨 (int gcd사용해도됨)	
			}
		}
		return k;
	}
	/* 기능 : num단을 출력하는 메소드
	 * 매개변수 : 정수num => int num 
	 * 리턴타입 : 없음 
	 * 메소드명 : printMultiTable*/
	public static void printMultiTable(int num){ 
		int i;
		for(i =1 ; i <= 9 ; i += 1) {
			System.out.println(num+ "X" + i + "=" + (num * i) );
		}
	}
}
