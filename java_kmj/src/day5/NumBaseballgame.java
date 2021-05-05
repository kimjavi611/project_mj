package day5;

public class NumBaseballgame {

	public static void main(String[] args) {
		/* 숫자 야구 게임
		 *-1 ~ 9 사이의 중복되지 않은 3 개의 정수를 랜덤으로 생성
		 *-B : 숫자는 같고 위치는 다른 경우
		 *-S : 숫자도 있고, 위치가 같은 경우
		 *-O : 일치하는 숫자가 하나도없는 경우
		 * 예시 : 34 5
		 * 입력하세요 : 12 3
		 * 1B
		 * 입력하세요 : 4 5 6
		 * 1B
		 * 입력하세요 : 34 5
		 * 2S
		 * 입력하세요 : 3 5 9
		 * 1S2B
		 * 입력하세요 : 6 7 8
		 * O
		 * 입력하세요 : 34 5
		 * 3S
		 * 정답입니다.
		 * */
		int i, r;
		int [] arr = new int[3];
		int min =1, max = 9;
		for(i = 0 ; i < arr.length ; i += 1) {
			r = (int)(Math.random() * (max - min + 1) + min);
			arr[i] = r;
		}
		
			

	} 
}
		
