package day2;

public class Test2_7 {

	public static void main(String[] args) {
		/* 평년의 월의 마지막일수를 출력하는 코드를 작성하세요
		 * 31 : 1 3 5 7 8 10 12
		 * 월이 1월이면 31일이라고 출력
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 예시
		 * 월을 입력하세요 : 2
		 * 2월은 28일까지 있습니다.
		 * */
		
		int month = 11;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println(month + "월은 31일까지 있습니다. ");
		}else if(month == 2) {
			System.out.println(month + "월은 28일까지 있습니다. ");
		}if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "월은 30일까지 있습니다. ");
		}//마지막에 else if로 쓰거나 if로 써도 결과는 같은데 if로 쓰는 이유는? else는 생략이 가능?
		
	

			
		
	}

}
