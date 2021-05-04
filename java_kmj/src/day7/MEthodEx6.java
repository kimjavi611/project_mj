package day7;

public class MEthodEx6 {

	public static void main(String[] args) {
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 * */
		/* 다음과 같이 출력하는 메소드를 만드세요.
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****   */
		
	}
	/* 주어진 문자를 이용하여 왼쪽으로 붙은 삼각형을 n줄 출력하는 메소드 
	 * 매개변수 : 정수, 문자 char ch, int n
	 * 리턴타입 : 없음 void
	 * 메소드명 : Triangleshape
	 * */
	public static void Triangleshape(char ch, int n) {
		for( int i = 1; i <= 5 ; i += 1) {
			for(int k = 1 ; k <= 5; k += 1) {
				System.out.println(ch);
			}
			System.out.println();
		}	
		
	}
	/* 주어진 문자를 이용하여 오른쪽으로 붙은 삼각형을 n줄 출력하는 메소드 
	 * 매개변수 : 정수, 문자 char ch, int n
	 * 리턴타입 : 없음 void
	 * 메소드명 : Triangleshape2
	 * */
	public static void Triangleshape2(char ch, int n) {
		for( int i = 1; i <= n ; i += 1) {
			for(int k = 1 ; k <= n-i; k += 1) {
				System.out.println(" ");
			}
			for(int k = 1 ; k <= i; k += 1) {
				System.out.println(ch);
			}	
		}	System.out.println();
		
	}
	/* 기능 : 주어진 문자를 이용하여 n줄 삼각형 출력하는데 주어진 삼각형 종류에 맞게 출력하는 메소드
	 * 메개면수 : 문자, n줄, 삼각형 종류 => char ch, int n, Triangleshape shape
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printTriangle */
	public static void printTriangle(char ch, int n, Triangleshape shape) {
		switch(shape) {
		case LEFT_TRIANGLE:
			System.out.println("*");
			
		}
	}
}
enum Triangleshape{LEFT_TRIANGLE, RIGHT_TRIANGLE}
