package day3;

public class for6 {

	public static void main(String[] args) {
		/* 정수의 약수를 출력하는 코드를 작성하세요.
		 * 예시 
		 * 정수를 입력하세요 : 6
		 * 1 2 3 6
		 * 반복횟수 : i는 1부터 정수까지 1씩 증가 
		 	정수 : num
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 * 		=> num를 i로 나누었을 떄 나머지가 0과 같다면 i를 출력
		 * 반복문 종료 후 : 없음
		 * */
		
		int i;
		int num = 12;
		for(i = 1 ; i <= num ; i += 1 ) {
			if(num % i == 0) {
				System.out.print(i + " ");	
			}
		
		}
		
		
		
		
	
		

	}

}
