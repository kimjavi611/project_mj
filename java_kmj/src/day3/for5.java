package day3;

public class for5 {

	public static void main(String[] args) {
		/* 1부터 5까지의 합을 구하는 예제
		 *  반복횟수 : i는 1부터 5까지 1씩 증가
		 *  규칙성 : sum = sum + i를 실행(sum += i)
		 *  		sum = 0
		 *  i = 1	sum = sum0 + 1
		 *  i = 2	sum = sum1 + 2
		 *  i = 3 	sum = sum2 + 3
		 *  i = 4	sum = sum3 + 4
		 *  i = 5	sum = sum4 + 5
		 *  */
		
		/* i + 1 
		 * i + 2 (i + 1)
		 * i + 3
		 * i + 4
		 * i + 5*/
	
		
		int i, sum = 0 ;
		
			
			for(i = 1 ; i <= 5 ; i += 1) {
				sum = sum + i;
				
			}
			System.out.println("1부터 5까지의 합 : " + sum);
		
		

		
	}

}
