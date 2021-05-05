package home;

public class Lotto {

	public static void main(String[] args) {
		/* 사용자 번호를 랜덤으로 생성하고(로또번호 자동생성), 
		 * 당첨 번호를 입력하면 당첨 등수를 출력하는 코드를 작성하세요.
		 * - 사용자 번호 : 1 ~45 사이의 수, 중복되지 않음, 6개
		 * - 당첨 번호 : 1 ~ 45 사이의 수, 중복되지 않음, 6개 +1개(보너스번호)
		 * - 1등 : 당첨번호 6개 일치
		 * - 2등 : 당첨번호 5개 +보너스 번호 일치
		 * - 3등 : 당첨번호 5개 일치
		 * - 4등 : 당첨번호 4개 일치
		 * - 5등 : 당첨번호 3개 일치
		 * - 꽝  : 당첨번호 2개 이하
		 *  */
		//컴퓨터가 랜덤으로 중복되지 않는 수 6개를 생성(사용자 번호)
		//=> int [] user = new int[6]
		int [] user = new int[6];
		int min =1, max =45;
		
				
		
		
		
			
		}
		/* 기능 : 배열 arr에 0번지부터 count개 확인해서 num가 있는지 없는지 알려주는 메소드
		 * 매개변수 : int []arr, int count, int num
		 * 리턴타입 : 있다 없다 => boolean
		 * 메소드명 : contains
		 * */
	
	public static boolean contains(int[]arr, int count, int num) {
			for(int i= 0; i<count ; i +=1) {
				if(arr[i] == num) {
					return true;
				}
			}
			return false;
	}
	
		/* 기능 :배열 arr에 min~max까지 랜덤한 수를 생성하여 저장, 중복되지 않음
		 * 매개변수 : int[]arr, int min, int max
		 * 리턴타입 : 없음 => void
		 * 메소드명 : init*/
	public static void init(int[]arr, int min, int max) {
		for(int i = 0 ; i < arr.length ; i+=1) {
			int r =  (int)(Math.random() * (max - min + 1) + min);
			int cnt = 0; 
			if(!contains(arr, cnt, r)) {
				arr[cnt] = r;
				cnt +=1;
			}
		}
	}
	
}
