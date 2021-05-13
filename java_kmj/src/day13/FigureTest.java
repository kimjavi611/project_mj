package day13;

import java.util.Scanner;

public class FigureTest {

	public static void main(String[] args) {
		/*Rect r = new Rect(167,255,278,391);
		r.print();
		Circle c = new Circle(5,10,5);
		c.print();*/
		Figure[]arr = new Figure[10];
		int maxCount = 0; //최대로 그린 도형의 갯수
		int pos = 0; //현재 도형의 번호
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("-------------");
			System.out.println("1. 도형 그리기");
			System.out.println("2. 실행 취소");
			System.out.println("3. 다시 실행");
			System.out.println("4. 확인하기");
			System.out.println("5. 종료");
			System.out.println("-------------");
			System.out.println("메뉴 선택 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1 : 
				System.out.println("그릴 도형을 선택하세요(1. 원, 2. 사각형) " );
				int selectFigure = scan.nextInt();
						switch (selectFigure) {
						case 1:
							System.out.print(" 중심점을 입력하세요.(예 : 10 10) : ");
							int x = scan.nextInt();
							int y = scan.nextInt();
							System.out.println("반지름을 입력하세요 : ");
							int r = scan.nextInt();
							arr[pos] = new Circle(x,y,r);
							pos ++;
							maxCount = pos;//새로운 작업을 하면 이전 작업을 불러올 수 없기 때문에 maxCount가 pos값이랑 같아지게됨
							break;
						case 2 :
							System.out.println("좌성점을 입력하세요(예 : 10 10) : ");
							int left =scan.nextInt();
							int up = scan.nextInt();
							System.out.println("우하점을 입력하세요(예 : 10 10) : ");
							int right = scan.nextInt();
							int down = scan.nextInt();
							arr[pos++] =new Rect(left,up,right,down);
							maxCount = pos;
							break;
							
							
						}
					break;
			case 2 : 
				if(pos != 0) {
					pos--;
				}
				break;
			case 3 : 
				if(pos<maxCount) {
					pos++;
				}
				break;
			case 4 : 
				for(int i = 0 ; i < pos ; i++) {
					arr[i].print();
				}
				break;
			case 5 : break;
			}
				
		}while(menu !=5);
		scan.close();
		
	}

}
