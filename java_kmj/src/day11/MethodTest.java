package day11;

public class MethodTest {

	public static void main(String[] args) {
		
		int res = sum(1,2); // = 기준 오른쪽을 먼저 작업 =>sum을 먼저 작업 => int res =3이됨
		System.out.println(res);
		
		int[]arr = new int[]{1,2,3,4,5};
		System.out.println(sum2(arr));
		System.out.println(sum3(1,2,3));//sum3는 매개변수를 ...으로 입력해서 값을 입력해도되고, 상수를 만들어서 사용해도된다. 매개변수를 배열로 만듦. 
		System.out.println(sum3(1,2,3,4,5));
		
	}
	public static int sum(int num1,int num2) {
		return num1 +num2;//return은 일을 시킨 위치로 값을 돌려준다 => 일을 시킨 위치 => main의 7번째줄
	}//메소드의 리턴값은 메소드를 호출한 위치로 간다!
	public static int sum2(int[]arr) {
		if(arr==null) {
			return 0;
		}
		int res =0;
		for(int tmp :arr) {
			res +=tmp;
		}
		return res;
	}//p.252 매개변수의 갯수를 모를경우 
	public static int sum3(int ... arr) {
		int res = 0;
		for(int tmp : arr) {
			res += tmp;
		}
		return res;
	}
		
	
}
