package day17;

public class WrpperTest {

	public static void main(String[] args) {
		Integer num1 =1;
		int num2 =2;
		System.out.println(num1 + num2);
		num1 = null;
		System.out.println(num1);
		//num2 = null; //에러 발생 : 기본타입은 null을 저장할 수 없음
		num1 = new Integer(1);
		System.out.println(num1);//생성자를 이용해서 만들 수 있지만 이렇게 하지는 않음. 그냥 저장하면됨 => 더이상 사용되지 않음
		//기본 타입을 객체로 만드는 것을 박싱
		num1= 1;
		//객체를 기본타입으로 만드는 것을 언박싱
		num2=num1;
		System.out.println(num2);
		//문자열을 기본타입으로 변환
		//래퍼클래스.parse래퍼클래스(문자열);
		String str ="1234";//
		num2 = Integer.parseInt(str);
		System.out.println(num2);
			
	}

}
