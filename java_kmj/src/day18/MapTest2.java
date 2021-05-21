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
		int num;
		String id = null;
		String pw = null;
		HashMap<String,String> map = new HashMap<String,String>();
		
		do {
			System.out.println("선택할 메뉴의 번호를 입력하세요 :");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			System.out.println("메뉴선택 : ");
			num = scan.nextInt();
			//입력한 번호에 따른 기능
			//1. 회원가입
			switch(num) {
			case 1 : 
				System.out.print("등록할 아이디와 비밀번호를 입력하세요 : ");
				//아이디 입력
				id = scan.next();
				//가입된 아이디가 아니면 비밀번호 입력 후 아이디와 비밀번호를 저장
				if(!map.containsKey(id)) {
					pw = scan.next();
					map.put(id,pw);
				//가입된 아이디이면 이미 가입된 아이디라고 출력
				}else {
					System.out.print("이미 있는 id입니다.");
				}
				break;
			case 2:
				//아이디 입력
				 System.out.print("아이디를 입력하세요 : ");
				 String id2 = scan.next();
				//비밀번호 입력
				 System.out.print("비밀번호를 입력하세요 : ");
				 String pw2 =scan.next();
				 //아이디와 비밀번호가 일치하는지 확인하여 같으면 로그인 성공
				 //문자열비교 equals()
				 //아이디랑 비밀번ㅎ가 일치하는지 => id랑 id2가 일치하는지 
				 //pw랑 pw2가 일치하는지 확인
				//다르면 로그인 실패라고 출력
				 if(id2.equals(map.get(id)) && pw2.equals(map.get(pw))){
					 System.out.print("로그인 성공");	
				 }else {
					 System.out.print("로그인 실패");
				 }
				 break;
			case 3:
				System.out.print("종료");
				break;
			default:
				System.out.print("잘못된 메뉴입니다.");
			} 
		}while(num == 3); 
		
		
	}

}

