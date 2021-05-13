package day13;

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child(1,2,3);
		c.print();//차일드 메소드가 없지만 부모클래스를 상속받았기 때문에 사용할 수 있음
		c.print2();
		String s;
	}

}
class Parent{
	private int num1;
	protected int num2;
	public int num3;
	
	public void print() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
	}

	public Parent(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public final void menu() {
		System.out.println("메뉴입니다.");
	}

}
class Child extends Parent{
	public int num4;
	
	public Child(int num1, int num2, int num3) {
		super(num1, num2, num3);
	}
	public void print2() {
		System.out.println(getNum1());
		System.out.println(num2);
		System.out.println(num3);
	}
	//오버라이드/오버라이딩
	//접근제한자를 좁힐 수 없다.
	//부모클래스의 메소드가 public이면 private이나 protected로 수정할 수 없다.
	@Override//오버라이드한거를 알려주는 어노테이션 기존 메소드랑 구별하기 좋음. 생략가능
	public void print() {// 부모클래스와 메소드 선언이 같으면됨
		super.print();//super는 부모클래스의 객체정보
		System.out.println("num4 : " + num4);
		
	}//오버로드/오버로딩
	public void print(int num1) {
		super.print();
		System.out.println("num4 : " + num4);
}
	//부모클래스에 있는 menu 메소드가 final이기 때문에 오버라이딩이 안된다
	//public void menu() {}
	}
//final 클래스 String을 통해 자식 클래스를 만들 수 없다
//class SubString extends String{}