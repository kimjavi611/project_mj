package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
		test();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void test() throws Exception, ArithmeticException{//발생할 수 있는 예외가 여러개일때 , 로 여러개 적어줄 수 있음
		throw new Exception("test 메소드에서 예외 발생");
	}

}
