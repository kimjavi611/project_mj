package day5;

public class while2 {

	public static void main(String[] args) {
		/* while문과 continue를 이용한 짝수 출력 예제
		 * */
		int i = 1, num = 10;
		while ( i<= num){
			if(i % 2 != 0) {
				i += 1;
				continue;
			}
			System.out.println(i + " ");
			i += 1;
		} 
		
		 i = 0;
		while ( ++i <= num){
			if(i % 2 != 0) {
				i += 1;
				continue;
			}
			System.out.println(i + " ");
			
		}
	}

}
