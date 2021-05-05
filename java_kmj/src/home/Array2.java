package home;

public class Array2 {

	public static void main(String[] args) {
		/* 정수 num의 약수를 배열에 저장한 후 출력하는 코드를 작성하세요.
		 * 단, 약수의 갯수가 10개를 넘어가는 경우 최대 10개만 출력하면 됩니다.*/
		int num=42;
		int [] arr = new int[10];
		//정수 num의 약수를 배열에 저장
		int i;
		int cnt = 0; //약수를 저장할 변수
		/* 반복횟수 : i가 1부터 num까지 1씩 증가
		 * 규칙성 : num을 i로 나눴을때 나머지가 0이면
		 * 		  배열cnt에 i를 저장 하고
		 * 			cnt를 1씩 늘려서 cnt가 10이면 종료
		 * 반복문종료후 : 배열에 있는 값을 0번지부터 cnt개 출력 */
		for(i=1 ; i <= num ; i+=1) {
			if(num % i == 0) {
				arr[cnt] = i;
				cnt +=1;
				if(cnt == 10) {
					break;
				}
			}
			
		}
		for(i = 0 ; i < cnt ; i+=1) {
			System.out.print(arr[i]+ " ");
		}
	}

}
