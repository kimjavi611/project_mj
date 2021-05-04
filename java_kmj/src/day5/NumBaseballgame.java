package day5;

public class NumBaseballgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} /* 숫자 야구 게임
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
	 int [] com =  new  int [ 3 ]; // 컴퓨터가 랜덤으로 생성 한 숫자를 저장하는 배열
		int [] user =  new  int [ 3 ]; // 사용자가 입력 한 숫자를 저장하는 배열
		int strike; // 스트라이크 갯수
		int ball; // 볼의 갯수
		int cnt =  0 ; // 컴퓨터가 랜덤으로 생성 한 (중복되지 않은) 숫자를 배열에 저장 한 갯수
		int min =  1 , max =  9 ; // 랜덤 숫자 범위
		int r; // 랜덤으로 생성 한 숫자를 표현 변수
		int i, k;
		boolean isDuplicated; // 배열에있는 값이 있는지 확인
		
		
		//컴퓨터가 랜덤으로 중복되지 않은 세 수를 생성
		//베열에 3개 저장될때까지 반복
		while(cnt < 3) {
			//min~max 사이의 랜덤한 숫자를 생성
			r = (int)(Math.random() * (max-min +1) +min);
			isDuplicated = false;
			//랜덤한 숫자와 배열의 0번지부터 cnt개 비교해서 중복여부를 확인
			for(i = 0 ; i <cnt ;  i += 1) {
				//중복체크하여 중복되면 중복됐다고 저장
				//랜덤한 숫자와 배열의 i번지의 값이 같으면 isDuplicated를 true로
				if(i == com[1]) {
					isDuplicated = true;
				}
			}	
			//중복되지 않으면 배열에 저장 후 저장한 갯수(cnt)를 1개 증가
		}	if(!isDuplicate) {
				com[cnt] = r;
				cnt += 1;
					
		}
		//생성한 숫자를 출력(테스트용)
		for (i =  0 ; i < com . length; i += 1 ) {
			system.out.print(com [i] +  "  " );
		}
		system.out.println ();
		
		
		//게임을 시작해서 3S가 나올떄까지 반복
		

		
		do {
			//사용자가 세 수를 입력(중복되지 않는다고 가정)
			
			//볼과 스트라이크 갯수를 셈
			
			//볼과 스트라이크와 아웃을 판별하여 출력
			
		}while(strilke != 3 );
		
		
		
		//com배열과 user배열에서 다른 번지를 비교하여 같은 숫자가 있으면
		//ball를 증가
		//com[0]과 user[1], user[2]와 비교
		//com[1]과 user[0], user[2]를 비교
		//com[2]과 user[0], user[1]를 비교
		for( i = 0; i < com.lenghth; i += 1) {
			for( k=0; k < user.length; k +=1) {
				if(i== k ) {
					continue;
				
				if(com[i] == user[k]) {
					ball+= 1;
					}
				}
				
			}
		}	
}
		
