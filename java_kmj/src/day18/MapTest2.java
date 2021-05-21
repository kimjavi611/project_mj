package day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MapTest2 {

	public static void main(String[] args) {
		/* 다음 두 기능을 가진 프로그램을 작성하세요.
		 * 1. 회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 예시 )
		 * 1.회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 회원가입
		 * 아이디 : abc123
		 * 비밀번호 : abc123
		 * 회원가입 되었습니다.
		 * 1.회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 아이디 : abc123
		 * 이미 가입된 회원입니다.
		 * 1.회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 아이디 : abc123
		 * 비밀번호 : abc123
		 * 로그인 성공
		 * 1.회원가입
		 * 2. 로그인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 아이디 : abc123
		 * 비밀번호 : 1234
		 * 로그인 실패
		 * */
		//메뉴 등록 => 입력받음

		Scanner scan = new Scanner(System.in); 
		do {
			System.out.println("선택할 메뉴의 번호를 입력하세요 :");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			System.out.println("메뉴선택 : ");
			Scanner scan1 = new Scanner(System.in);
			int num = scan.nextInt();
			//입력한 번호에 따른 기능
			//1. 회원가입
			switch(num) {
			case 1 : 
				System.out.println("등록할 아이디와 비밀번호를 입력하세요 : ");
				String id = scan.next();
				String pw = scan.next();
				HashMap<String, String> map = new HashMap<String, String>();
				map.put(id,pw);
				//아이디 중복되는지 비교
				
				
			}
			
		
		
		}while(); 
		
		
	}

}

