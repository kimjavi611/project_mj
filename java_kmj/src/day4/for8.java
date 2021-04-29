package day4;

public class for8 {

	public static void main(String[] args) {
		/* a부터 z까지 출력하는 코드를 작성하세요.
		 * 반복횟수 : ch는 'a'부터 ch는 'z'까지 ch는 1씩 증가
		 * 규칙성 : ch를 출력
		 * 반벅문 종료 후 : 없음
		 * */  
		/*char ch = 'a' + 0;
		System.out.println(ch);
		ch = 'a' + 1;
		System.out.println(ch);
		ch = 'a' + 2;
		System.out.println(ch);*/
		
		char ch;
		for(ch = 'a' ; ch <= 'a' + 25 ; ch += 1) {
			System.out.print(ch + " ");
		}
		
		
		/* a부터 z까지 출력하는 코드를 작성하세요.
		 * 반복횟수 : i는 0부터 i는 26보다 작을때까지(25보다 작거나 같을때까지)  i는 1씩 증가
		 * 규칙성 : (char)('a'+ i)를 출력 (char)없으면 문자의 정수값이 찍힘 
		 * 반벅문 종료 후 : 없음
		 * */  
		
		System.out.println();
		int i;
		for(i = 0 ; i < 26 ; i += 1 ) {
			System.out.print((char)('a' + i) + " ");
		}
	}

}
