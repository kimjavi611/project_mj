package day17;

import java.util.Scanner;

public class StringTest5 {

	public static void main(String[] args) {
		String str = "안녕하세요";
		System.out.println(str.substring(2));
		//2번지부터 마지막번지까지 부분 문자열 생성
		System.out.println(str);
		//substring은 원본을 수정하는 것이 아니라 새로운 문자열을 생성
		System.out.println(str.substring(2, 3));
		//2번지부터 3번지 전까지인 2번지까지 새로운 부분 문자열을 생성 => 두번째 번지를 포함하지 않음 
		
		/* 주민등록번호를 입력해서 생년월일 부분을 추출하여 년도 월 일을 출력하는 코드를 작성하세요
		 * 예시)
		 * 주민번호를 입력하세요 : 020101-3234567
		 * 2002년 1월 1일
		 * 예시) 
		 * 1902년 1월 1일
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요(-는 생략) : ");//-생략이면 번지수에서 -자리의 번지수를 건너띄고 해야함
		//-포함일때 주민번호 뒷번호의 첫번째자리가 7번째, -생략이면 6번째 
		String birth = scan.next();
		String year = birth.substring(0, 2);
		String month = birth.substring(2, 4);
		String date = birth.substring(4, 6);
		//String gender = str.substring(7,8);
		//char gender = str.charAt(7);
		//if문 이용1)
		/*if(birth.subSequence(6, 7).equals("1") || birth.subSequence(6, 7).equals("2")) {
			year = "19" + year;
		}else if(birth.subSequence(6, 7).equals("3") || birth.subSequence(6, 7).equals("4")) {
			year = "20" + year;
		}*/
		//switch문 이용1)
		
	
		switch(birth.substring(7,8)){
			case "1", "2":
			System.out.println("19" +year);
			break;
			case "3", "4":
			System.out.println("20"+year);
			break;
		
	}
		System.out.println(year + "년" + month + "월" + date + "일");
		//성별 번호에 따라 year앞에 19또는 20을 붙이면 됨	
	}

}
