package day3;

public class swich1 {

	public static void main(String[] args) {
		// switch문을 이용한 홀짝 판별 예제
		
		int num = 4;
		
		switch(num % 2 ) {
		case 0:
			System.out.println("짝수");
			break;
		default:
			System.out.println("홀수");
		}

	}

}
