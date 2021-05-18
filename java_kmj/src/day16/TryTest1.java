package day16;

public class TryTest1 {

	public static void main(String[] args) {
		int num1 =1 , num2 = 0;
		/*예외 발생시 catch에서 해당 예외 클래스나 조상 클래스가 있으면 예외를 처리한다
		 * 나누기는 ArithmeticException이 발생할 수 있는 코드이다.
		 * ArithmeticException의 조상 > RuntimeException > Exception*/
		try {
			System.out.println(num1/num2);
		}//Exception은 ArithmeticException의 조상이므로 처리할 수 있다
		catch(Exception e) {
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외 처리 1번 종료");
		try {
			System.out.println(num1/num2);
		}//ArithmeticException은 본인이기 때문에 예외 처리가 가능 하다
		catch(ArithmeticException e) {
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외 처리 2번 종료");
		
		try {
			System.out.println(num1/num2);
		}//RuntimeException은 ArithmeticException의  부모이기 때문에 예외 처리 가능
		catch(RuntimeException e) {
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외 처리 3번 종료");
		try {
			System.out.println(num1/num2);
		}//ClassCastException은 ArithmeticException의 조상이 아니기때문에 불가능
		catch(ClassCastException e) {//ClassCastException은 num1/num2의 오류를 해결할 수 없기 때문에 예외 처리가 되지 않음
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다.");
		}
		System.out.println("예외 처리 4번 종료");
		
		
		System.out.println("프로그램 종료");
	}
	
		
}
