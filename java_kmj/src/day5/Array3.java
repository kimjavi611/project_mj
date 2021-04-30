package day5;

public class Array3 {

	public static void main(String[] args) {
		/* 정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력하면 됩니다.
		 * */
		//정수 num의 약수를 배열에 저장
		
		int num = 12 ;
		int i;
		//배열 cnt번지에 i를 저장 
		int arr[] = new int[10];//약수의 갯수가 최대 10개
		int cnt = 0;
		for(i = 1 ; i <= num ; i += 1) {
			if(num % i == 0);
			
			//cnt를 1 증가 후
			cnt += 1;
			if(cnt == 10) {
				break;
			}
				
				
			}
			//배열에 있는 값을 0번지부터 cnt개 출력
			for(i = 0 ; i < cnt ; i+=1){
				System.out.print(arr[i] + " ");
			}
		}
		
		
	}


