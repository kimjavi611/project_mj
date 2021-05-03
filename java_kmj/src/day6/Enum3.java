
package day6;

import java.util.Calendar;

public class Enum3 {

	public static void main(String[] args) {
		//열거형은 아니지만 열거형과 비슷하게 의미전달을 하는 예제
		Calendar now = Calendar.getInstance();//입력한 현재날짜와 시간을 알려줌
		int year = now.get(Calendar.YEAR);//입력한 현재 년도를 알려줌
		//now.get(1)
		int month = now.get(Calendar.MONTH)+1;//입력한 현재 날짜의 월을 알려주는데 0부터 알려줌
		//now.get(2)
		System.out.println(year + "년" + month + "월");
		

	}

}
