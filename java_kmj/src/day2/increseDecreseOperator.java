package day2;

public class increseDecreseOperator {

	public static void main(String[] args) {
		int num1 = 10 , num2 = 10;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		System.out.println("++num1 = " + ++num1 + ", num2++ = " + num2++);
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		
		num1++;
		++num1;
		//이 떄 num1을 출력하면 얼마가 나올까요?
		//12
		//13
		num1 = 10;
		num2 = 10;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);
		num1++;
		System.out.println("++num1 = " +   num1 + ", num2++ = " +   num2);
		++num2;
		System.out.println("  num1 = " +   num1 + ",   num2 = " + num2);

	}

}
