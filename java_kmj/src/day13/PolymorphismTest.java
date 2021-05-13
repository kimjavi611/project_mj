package day13;

public class PolymorphismTest {

	public static void main(String[] args) {
		//매개변수의 다형성(p.345~)
		// 앞바퀴 2개를 금호로 바꾸고 싶다
		Car2 c = new Car2();
		c.frontLeftTire = new KumhoTire();
		c.frontRightTire = new KumhoTire();
		c.BackLeftTire = new HankookTire();
		c.BackRightTire = new HankookTire();
		//사고 후 앞 왼쪽 바퀴를 한국타이어로 교체
		c.frontLeftTire = new HankookTire();
		boolean isOk1 = confirm(c.frontLeftTire);
		boolean isOk2 = confirm(c.frontRightTire);

	}
	/* 기능 : 타이어에 이상이 있는지 없는지 알려주는 메소드
	 * 매개변수 : 타이어 => Tire t
	 * 리턴타입 : 이상여부 => 참 거짓 => boolean
	 * 메소드명 : confirm
	 * */
	
	public static boolean confirm(Tire t) {
		//타이어 t가 한국타이어면 예외가 발생하지 않고
		//금호타이어면 예외가 발생함
		HankookTire ht =(HankookTire)t; 
		return false;
	}

}
class Car2{
	public Tire frontLeftTire;
	public Tire frontRightTire;
	public Tire BackLeftTire;
	public Tire BackRightTire;
}
class Tire{}

class KumhoTire extends Tire{}
class HankookTire extends Tire{}