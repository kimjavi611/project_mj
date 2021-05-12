package board;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		/* 다음 메뉴를 가지는 게시글 콘솔 프로그램을 만드세요
			1. 게시글 등록
			2. 게시글 수정
			3. 게시글 삭제
			4. 게시글 목록 확인
			5. 게시글 상세 확인
			6. 프로그램 종료
			*/
		//반복문을 이용하여 메뉴를 출력하고 메뉴를 선택하는 작업
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int max = 10; 
		Board [] board = new Board[max];
		String writer, title, registerDate,contents,type;
		int num; 
		int count = 0; //저장된 게시글의 갯수(등록할 때 저장할 번지)
		Board tmpBoard;
		int views;
		do {
			//메뉴를 출력=>메소드로 만듦
			printMenu();
			//메뉴를 선택
			menu = scan.nextInt();
			//선택된 메뉴에 따라 기능 안내문 출력
			switch(menu) {
			case 1: 
				System.out.println("등록"); 
				//게시글 콘솔에 등록 > 작성자, 작성일, 제목, 내용 필요
				//필요한 변수 선언
				System.out.println("게시글 정보를 입력하세요 : ");
				System.out.println("제목 :");
				title =scan.next();
				System.out.println("작성자 :");
				writer = scan.next();
				System.out.println("작성일 : ");
				registerDate = scan.next();
				System.out.println("내용 : ");
				contents = scan.next();
				//타입은 게시글로 지정, 번호는 배열의 번지를 이용 
				type = "게시글";
				num = count+1;
				
				//입력된 정보를 이용하여 게시글 생성
				tmpBoard = new Board(num, title, contents, writer, registerDate, type);
				//생성된 게시글을 배열에 저장
				board[count] = tmpBoard;
				count  +=1;
				break;
			case 2: 
				//수정할 게시글 번호 입력
				System.out.println("수정할 게시글 번호를 입력하세요 : ");
				num = scan.nextInt();
				//게시글이 존재하고 => num <= count
				//게시글이 삭제되지 않았으면 => board[num-1] != null
				//제목과 내용을 입력받음 => 내용을 수정
				if(board[num] != null && num <= count) {
					System.out.println("제목 : ");
					title = scan.next();
					System.out.println("내용 : ");
					contents = scan.next();
					//board[num-1].setTitle(title);
					//board[num-1].setContents(contents);
					board[num-1].modify(title, contents);//board클래스에서 메소드 만든후 호출
				}else {
					System.out.println("게시글이 없거나 삭제되었습니다.");
				}
				
				break;
			case 3: 
				//삭제할 게시글 선택
				System.out.println("삭제할 게시글 번호를 입력하세요 : ");
				num = scan.nextInt();
				//선택한 게시글 내용 삭제
				//삭제 => 배열 board에서 선택된 num번지를 null로 ?
				if(num <= count) {
					board[num-1] = null;//num번지 삭제
				}
				break;
			case 4: 
				//모든 게시글을 확인
				//반복문
				for(int i = 0; i < count ; i+=1) {//게시글이 삭제된게 있을 수 있어서 배열전체가 아니라 만들어진 게시글 수 만큼 
					if(board[i] != null) {
						//번호 제목 작성자 작성일만 출력
						board[i].summaryPrint();//board클래스에서 가져옴
					}
				}
				break;
			case 5: 
				//상세 내용을 확인할 게시글을 선택
				System.out.println("확인할 게시글 번호를 입력하세요 : ");
				num = scan.nextInt();
					
				//해당 게시글의 내용을 출력
				if(num <= count && board[num-1] != null) {
					//게시글을 확인하면 조회수를 1증가
					//기존 조회수를 가져옴
					//views = board[num-1].getLike();
					
					//기존 조회수에 +1을 해서 다시 업데이트
					//board[num-1].setLike(views+1);
					board[num-1].print();//게시글 조회
					//print를 이용해서 조회수views를 증가시킬수있음 => board클래스의 print메소드
					
				}else {
					System.out.println("해당 게시글이 없거나 삭제되었습니다.");
				}
				break;
			case 6: 
				System.out.println("프로그램 종료"); 
				break;
			default : 
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu !=6);
		//선택할때까지
			//선택한 메뉴가 1이면 게시글 등록이라고 출력
			//선택한 메뉴가 2이면 게시글 수정이라고 출력
			//선택한 메뉴가 3이면 게시글 삭제라고 출력
			//선택한 메뉴거 4이면 게시글 목록 확인이라고 출력
			//선택한 메뉴가 5이면 게시글 상세 확인이라고 출력
			//선택한 메뉴가 6이면 프로그램 종료라고 출력
			//선택한 메뉴가 1~6이 아니면 잘못된 메뉴라고 출력
			scan.close();
	}
	public static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정 ");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록 확인");
		System.out.println("5. 게시글 상세 확인");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴를 선택하세요: ");
	}

}
