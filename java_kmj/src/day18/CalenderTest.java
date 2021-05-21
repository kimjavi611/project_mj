package day18;

import java.util.Calendar;

public class CalenderTest {//추상클래스=>new연산자로 객체를 생성 할 수 없음

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);//Calendar.YEAR =1 기울어진거 => 클래스변수 굵은글씨 => 상수 
		//month => 0~11의 값을 가져옴. 
		int month = now.get(Calendar.MONTH) + 1;//now.get(2);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);//숫자를 리턴함 => 요일도 숫자로 표현됨
		String weekStr = "";//숫자를 요일로 바꿔줌
		switch(week) {
		case Calendar.MONDAY : weekStr ="월"; break;
		case Calendar.TUESDAY : weekStr ="화"; break;
		case Calendar.WEDNESDAY : weekStr ="수"; break;
		case Calendar.THURSDAY : weekStr ="목"; break;
		case Calendar.FRIDAY : weekStr ="금"; break;
		case Calendar.SATURDAY : weekStr ="토"; break;
		default: weekStr ="일"; break;
		}
		System.out.println(year + "년" + month + "월" + day + "일" + weekStr + "요일");
		int amPm = now.get(Calendar.AM_PM);//오전_오후
		String amPmStr = amPm == Calendar.AM ? "오전" : "오후";
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.println(amPmStr + " " + hour + "시" + minute + "분" + second + "초");
	}

}
