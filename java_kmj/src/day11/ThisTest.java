package day11;

public class ThisTest {

	public static void main(String[] args) {
		TestA t = new TestA(5);
		t.print();

	}

}
class TestA{
	private int num;
	public TestA(int num) {
		//멤버변수 num에 매개변수 num의 값을 저장
		//메소드에서 우선순위는 멤버변수보다 매개변수가 높다
		//num = num;
		this.num = num;//매개변수와 멤버변수의 이름이 같을 때 멤버변수앞에 객체 this를 사용해준다.
	}
	public void print() {
		System.out.println("num : " + num);
	}
}
