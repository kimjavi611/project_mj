package day5;

public class Array4 {

	public static void main(String[] args) {
		/* 1 ~ 10 사이의 정수 3개를 핸덤으로 생성하여 배열에 저장한 후
		 * 생성된 값들이 중복되었는지 안되었는지 확인하는 코드를 작성하세요.
		 * 예시 :  
		 * 랜덤 : 3 8 2 
		 * 중복되지 않음
		 * 예시 : 
		 * 랜덤 : 2 8 8
		 * 중복  */ 
		
		int min = 1, max =10;
		int i, k;
		int cnt [] = new int[3];
		System.out.print("랜덤 : "); 
		
			for(i = 0 ; i < cnt.length ; i += 1) {
		 		cnt[i] = (int)(Math.random() * (max - min + 1) + min);
			 	System.out.print(cnt[1] + " ");
		 		//중복되었는지
		 		
		 	}
			System.out.println();
			
			if(cnt[0] == cnt[1] || cnt[0] == cnt[2] || cnt[1] == cnt[2] ) {
				System.out.println("중복");
			}else {
				System.out.println("중복아님");
			}
			boolean isDuplicated = false;
			for(i=0; i<cnt.length-1; i +=1) {
				for(k = i + 1; k < cnt.length; k +=1) {
					if(cnt[i] == cnt[k]) {
						isDuplicated = true;
					}
				}
			}
			if(isDuplicated) {
				System.out.println("중복");
			}else {
				System.out.println("중복아님");
			}
	}

}
