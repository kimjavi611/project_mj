package day8;

public class Test8_4 {

	public static void main(String[] args) {
		/* 1~10까지 한줄로 출력되는 코드를 작성하세요.
		   다음과 같이 되도록 코드를 작성하세요.
		   1 2 3 4
		   5 6 7 8 
		   9 10 
		   */ 
		for(int i=1 ;i<= 10 ; i+=1) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int k = 1 ; k <= 10 ; k+=1 ) {
			System.out.print(k+ " "); 
			if(k % 4 == 0) {//4의 배수이면 엔터 
				System.out.println(" ");
			}
		}
		/* 다음과 같이 되도록 코드를 작성하세요.
		   1, 2, 3, 4
		   5, 6, 7, 8 
		   9, 10 */
		System.out.println("\n ----------");
		for(int k = 1 ; k <= 12 ; k+=1 ) {
			System.out.print(k); 
			if(k % 4 == 0) {//4의 배수이면 엔터 
				System.out.println();
			}else{
				System.out.print(",");
			}
			//String str = i % 4 == 0 ? "\n" : ",";
			//System.out.println(str);//조건선택연산자 이용
		}
		/*다음과 같이 출력되도록 코드를 작성하세요
		  2 1 4 3 
		  6 5 8 7 
		  10 9 12 11
		  */
		System.out.println("\n-----------");
		
		/* 2 1 4 3 		1 2 3 4		+1 -1 +1 -1
		 * 6 5 8 7 		5 6 7 8		+1 -1 +1 -1 
		 * 10 9 12 11	9 10 11 12	+1 -1 +1 -1
		 * i가 홀수면 i+1, 짝수면 i-1
		 * */
		System.out.println();
		for(int k = 1 ; k <= 12 ; k+=1 ) {
			if(k % 2 == 0) { 
				System.out.print(k - 1 + " ");
			}else{
				System.out.print(k +1 + " ");
			}
			if( k% 4 == 0) {
				System.out.println();
			}
		}
		
		// (2 1 4 3)+ 4 = 6 5 8 7
		// (2 1 4 3)+ 4*2 = 10 9 12 11
		
		
		// + 4
		// + 4*2
		
	}

}
