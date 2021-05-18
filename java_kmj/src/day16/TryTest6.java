package day16;

public class TryTest6 {

	public static void main(String[] args) {
		int[]arr =new int[5];
		//int [] arr =null;
		int res = setData2(arr, 0, 10);
		if(res == -1) {
			System.out.println("번지가 잘못");
		}else if(res == 0) {
			System.out.println("배열 생성 안됨");
		}else {
			System.out.println("데이터 저장 성공");
		}
		try {
			setData(arr,-1,10);
			int num = getData(arr, 0);
			System.out.println(num);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	
	}
	/* 기능 	: 정수형 배열 index 번지에 있는 값을 data로 설정하는 메소드
	 * 매개변수 : 정수형배열 index번지 값 => int[]arr, int index int data
	 * 리턴타입 : 없음 => void
	 * 메소드명 : setData
	 * */
	public static void setData(int[]arr, int index, int data) {//일반적으로 메소드에서 적집 예외처리를 하지 않는다
		if(arr == null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		}
		if( index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException(index + "번지는"+ arr.length + "개 짜리 배열에서 유효하지 않은 배열의 번지입니다.");
		}
		arr[index] =data;
		
	}
	
	/* 기능 	: 정수형 배열에 index번지에 있는 값을 가져오는 메소드
	 * 매개변수 : 배열, 번지 int []arr, int index
	 * 리턴타입 : 값 int 
	 * 메소드명 :getData
	 * */ 
	public static int getData(int[]arr, int index) {
		if(arr == null) {
			throw new NullPointerException("배열이 생성되지 않았습니다.");
		}
		if( index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException(index + "번지는"+ arr.length+"개 짜리 배열에서 유효하지않은 배열의 번지입니다.");
		}
		
		return arr[index];
	
	}
	public static int setData2(int[]arr, int index, int data) {//일반적으로 메소드에서 적집 예외처리를 하지 않는다
		if(arr == null) {
			return 0;
		}
		if( index < 0 || index >= arr.length) {
			return -1;
		}
		arr[index] =data;
		return 1;
		
	}
}
