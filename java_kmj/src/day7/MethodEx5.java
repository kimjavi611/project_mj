package day7;

public class MethodEx5 {

	public static void main(String[] args) {
		// *****을 출력하도록 메소드를 생성하여 테스트를 해보세요 
		printchar1('*', 5);
		printchar1('-', 8);
		System.out.println(printchar2('*',5));
		System.out.println(printchar2('*',3)+printchar2('-' ,2));
	}
	/* 기능    : "주어진" 문자(ch)를 "주어진 정수번(count)" 반복해서 출력하는 메소드 
	 * 매개변수 : 문자, 정수번 => char ch, int count 
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printchar1*/
	public static void printchar1(char ch, int count) {
			for(int i = 0 ; i < count ; i += 1  ) {
			System.out.print(ch);
		}
			System.out.println();
	}
	/* 기능    : "주어진" 문자(ch)를 "주어진 정수번(count)" 반복하여 하나의 문자열로 알려주는 메소드 
	 * 매개변수 : 문자, 횟수 => char ch, int count
	 * 리턴타입 : 문자열 => String 
	 * 메소드명 : printchar2
	 * */
	public static String printchar2(char ch, int count) {
		String str = "";
		//문자열 +문자 => 문자열
		for(int i = 0; i <count; i += 1) {
			//i =0 " + '*' => "*"
			//i 
			str=str+ch;
		}
		return str;
	}
}
