package day5;

public class Test5_5 {

	public static void main(String[] args) {
		/* 1부터 10사이의 랜덤한 수를 6개 생성하여 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 생성된 랜덤한 수는 중복될 수 있음 */
		//랜덤한 수 6개 생성
		int min =1, max = 10;
		int i, r;
		int arr[] = new int[6];
		for( i = 0 ; i < arr.length ; i += 1) {
			 r = (int)(Math.random() * (max - min + 1) + min);
			arr[i] = r;
		}
		
		for( i = 0 ; i < arr.length ;  i += 1) {
			System.out.print(arr[i] + " ");
		}
		
		
			
		
				
		
	}

}
