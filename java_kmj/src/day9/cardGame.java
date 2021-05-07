package day9;

public class cardGame {

	public static void main(String[] args) {
		/* 포커게임 : 실제 포커 게임은 모양과 숫자를 다 따져야 하지만 
		 * 			여기에선 숫자만 고려, 카드는 7장
		 * 			카드는 1~13이 4개씩(하트, 다이아, 세잎, 스페이스) 총52장
		 * -포커 : 같은 숫자가 4개 
		 * -풀하우스 : 트리플 1개 + 페어(투페어) 1 또는 트리플2
		 * -스트레이트 : 연속된 숫자가 5개이상
		 * -트리플 : 같은 숫자가 3개
		 * -투 페어 : 같은 숫자가 2개씩 2개 => 페어가 2개
		 * -페어 : 같은 숫자가 2개
		 * -탑 : 위의 모든 조건이 없는 경우 가장 큰 수
		 * 
		 * */
		 
		/* 배열에 같은 숫자 3개가 있는지 없는지 알려주는 코드를 작성하세요.
		 * */
		/* 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 알려주는 코드를 작성하세요.*/
		//배열에 같은 숫자가 있는지 확인
		
		//카드가 주어지면 해당 카드의 가장 큰 등급을 출력하는 코드를 작성하세요.
		//아래와같이 풀하우스, 트리플, 페어로 판별 가능힌 경우
		//풀하우스 하나만 출력
		//아래는 1풀하우스입니다라고 출력
		int[]arr = new int[] {1,2,2,3,4,5,6,};
		int count =1;//연속된 숫자에 같은숫자의 수
		int res = 0; //같은숫자 있없
		int[]triple = new int[2];
		int num = 0; //같은숫자가 3개있을때 그 숫자를 저장하기 위한 변수
		for(int i = 0; i < arr.length-1 ; i +=1) {
			if(arr[i] == arr[i+1]) {//arr[0] ==arr[1] arr[1]=arr[2]
				count += 1;
				num = arr[i];
			}else{						 
				if(count ==3) {
					triple[res] =num;
					res +=1;
				}
				count =1;
			}
		}
		if(count==3) {
			triple[res] =num;
			res += 1;
		}
		if(res==0) {
			System.out.println("트리플 없음");
		}else {
			for(int i =0 ; i< res; i+=1) {
				System.out.println(triple[i] + " ");
			}
			System.out.println();
		}
		System.out.println("포커 : "+ poker(arr));
		System.out.println("트리플 : " + triple(arr));
		System.out.println("원페어 : " + onePair(arr));
		System.out.println("투페어 : ");
		int[]res2 =twoPair(arr);
		if(res2==null) {
			System.out.println(0);
		}else {
			for(int tmp : res2) {
				System.out.println(tmp + " ");
			}
		}
		System.out.println("풀하우스 : " + fullHouse(arr));
		System.out.println("스트레이트 : " + straight(arr));
		
		
		

	}
	/*포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 	 : 배열이 주어지면 배열에 포커가 있는지 확인하여 있으면 해당 숫자를, 없으면 0을 알려주는 메소드
	 * 		   [배열에 같은 숫자가 4개 있는지 확인하는 메소드]
	 *매개변수 : 배열, [숫자] => int[]card  [int num]
	 *리턴타입 : 포커의 숫자 => 정수 => int
	 *			[있는지 없는지 => "참거짓" => boolean]
	 *메소드명 : poker
	 **/
	public static int poker(int[]card) {

		int count=1; 
		for(int i = 0 ; i < card.length-1 ; i +=1) {
			if(card[i] == card[i+1]) {
				count += 1;
				if(count==4) {
					return card[i];
				}
			}else { 
				count = 1;
			}
			
		}
		return 0;
	}	
	/* 트리플을 확인할 수 있는 메소드를 정리해보세요. 
	 * 트리플이 있다면 해당 트리플의 숫자를 확인할 수 있는 매소드를 만들어야 한다.
	 * 기능 	  : 배열에 트리플이 있으면 해당 트리플의 숫자들을 알려주는 메소드
	 * 			없으면 null을 알려줌
	 * [배열이 주어지면 배열에서 트리플을 찾고 있다면 해당숫자를, 없다면 0을 알려주는 메소드]
	 * 매개변수 : 배열 => int [] card
	 * 리턴타입 : 트리플의 숫자"들" => 정수배열 => int[]  [정수 => int]
	 * 			정수로 사용하는 경우 => 그대로 사용할수 없음 => 예) 01,03 => 0103 =>
	 * 메소드명 : tripleList
	 * */
	public static int[] tripleList(int[]card) {
		int count =1;//연속된 숫자에 같은숫자의 수
		int res = 0;
		int[]triple = new int[2];
		int num = 0; //같은숫자가 3개있을때 그 숫자를 저장하기 위한 변수
		for(int i = 0; i < card.length-1 ; i +=1) {
			if(card[i] == card[i+1]) {//arr[0] ==arr[1] arr[1]=arr[2]
				count += 1;
				num = card[i];
			}else{						 
				if(count ==3) {
					triple[res] =num;
					res +=1;
				}
				count =1;
			}
		}
		if(count==3) {
			triple[res] =num;
			res += 1;
		}
		if(res==0) {
			return null;
		}else if(res ==2) {
			return triple;
		}else {
			int[]tmp = new int[1];
			tmp[0] = triple[0];
			return tmp;
		}
	}
	/* 트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능 	  : 배열에 트리플이 있다면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수 : 배열 int[]card
	 * 리턴타입 : 트리플인 숫자 => 정수 => int
	 * 메소드명 : triple
	 * */
	public static int triple(int[]card) {
		int[]res = tripleList(card);
		//트리플이 아닌 경우
		if(res == null || res.length ==2) {//트리플이 2개면 풀하우스 
			return 0;
		}
		return res[0];
				
	}
	/*페어를 확인할 수 있는 메소드를 정리해보세요. 
	 *페어가 있다면 해당 페어의 숫자들을 알려주고, 
	 *없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 *기능 	 : 배열에 페어가 있다면 해당 숫자를 알려주고 없으면 null을 알려주는 메소드
	 *매개변수 : 배열 => int[]card
	 *리턴타입 : 페어인 숫자들 => 배열 => int[]
	 *메소드명 : pairList
	 **/
	public static int[] pairList(int[]card) {
		int count =1;
		int num = 0;
		int[]pair = new int[3];
		int res = 0;// 페어의 숫자
		for(int i = 0; i < card.length -1; i +=1) {
			if(card[i] == card[i+1]) {
				count+=1;
				num = card[i];
			}else {
				//페어이면
				if(count == 2){
					pair[res] = num;
					res += 1;
				}
				count =1;
			}
		
		}
		if(count == 2){
			pair[num] = num;
			num += 1;
		}
		if(res == 0) {
			return null;
		}else if(res < 3) {
			int[]tmpArr = new int[res];
			for(int i = 0; i <res; i +=1) {
				tmpArr[i] =pair[i];
			}
			return tmpArr;
		}
		return pair;	
	}
	/* 원페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 : 배열에서 페어가 1개인 경우 해당 숫자를 알려주고 없으면 0을 알려주는 메소드 
	 * 매개변수 : 배열 => int[]card
	 * 리턴타입 : 페어의 해당 숫자 => 정수 => int
	 * 메소드명 : onePair
	 * */
	public static int onePair(int[]card) {
		int[]res = pairList(card);
		if(res != null && res.length ==1 ) {
			return res[0];
		}
		return 0;
	}
	
	/* 투페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능 :배열에서 페어가 2개인 경우 해당 숫자들을 알려주고 없으면 null을 알려주는 메소드
	 * 매개변수 : 배열 => int[]card
	 * 리턴타입 : 페어의 숫자들 => 정수 배열 => int[]
	 * 메소드명 : twoPair
	 * */
	public static int[] twoPair(int[]card) {
		int[]res = pairList(card);
		if(res == null || res.length ==1) {
			return null;
		}
		return res;
	}
	/* 풀하우스를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능    : 배열에 풀하우스(트리플 한개 + 페어 한개(또는 두개), 혹은 트리플2개)가 있으면 해당 숫자를 알려주고
	 * 			없으면 0을 알려주는 메소드
	 * 			2 2 2 3 3 4 5 => 2
	 * 			2 2 2 9 9 9 10 => 9 
	 * 			풀하우스 => 같은 수의 풀하우스가 나올 수 없다(카드가4장씩 있기때문)
	 * 매개변수 : 배열 => int[]card
	 * 리턴타입 : 풀하우스 숫자 => 정수배열 => int
	 * 메소드명 :fullHouse
	 * */
	public static int fullHouse(int[]card) {
		//트리플2개 이거나 트리플1개 + 페어1개 이거나 트리플1개 +페어2개
		
		int[]triple = tripleList(card);
		//트리플이 없으면 풀하우스가 될 수 없기 때문에 0을 리턴
		if(triple == null) {
			return 0;
		}//트리플이 null이면 메소드가 끝남 =>실행이 안됨
		//트리플이 2개이면 풀하우스
		//tripleList이용
		if( triple.length == 2) {//트리플이 null이면 여기 오기전에 메소드가 끝남 triple == null을 써줘도되고 빼도됨
			if(triple[0] > triple[1]) {
				return triple[0];
			}
			return triple[1];
			
		}
		
		
		//트리플이 2개가 아니면
		//트리플이 1개, 페어가 1개 이상이면 풀하우스
		//triple과 pairList를 이용
		
		//아니면 풀하우스가 아님
		
		int[]pair = pairList(card);
		if(pair != null) {
			return triple[0]; 
		}
		//아니면 풀하우스가 아님
		return 0;
	}
	/* 스트레이트를 확인할 수 있는 메소드를 정리해보세요.
	 * 원래는 마운틴이라고해서 10 11 12 13 A가 있는데 여기에서는 제외,
	 * 백스트레이트라고해서 1 2 3 4 5가 있는데 여기에서는 그냥 5스트레이트로 판단
	 * 기능 	  : 배열에서 스트레이트(연속된 숫자가 5개 이상)가 있으면 스트레이트 중 가장 큰 수를 알려주고
				없으면 0을 알려주는 메소드	
	 * 메개변수 : 배열 => int[]card 
	 * 리턴타입 : 스트레이트 중 가장 큰 수 => 정수 => int
	 * 메소드명 : straight*/
	public static int straight(int[]card) {
		int num = 0;
		int count =1;
		for(int i = 0 ; i < card.length -1 ; i +=1) {
			if(card[i] == card[i+1]) {
				continue; //숫자가 같을 경우 건너뜀
			}
			if(card[i]+1 == card[i+1]) {
				count+=1;
				num = card[i+1];
			}else {
				if(count >=5) {
					return num; //1 2 3 4 5 6 8
				}
				count =1;
			}
			//스트레이트가 마지막숫자를 포함할때 1 2 3 4 5 6 7 
			if(count >=5) {
				return num;
			}
		}
		return 0;
	}
		
}


