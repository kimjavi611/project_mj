package accountbook;

import java.util.Scanner;

public class AccountBookTest2 {

	public static void main(String[] args) {
		AccountBookProgram2 abp = new AccountBookProgram2();
		int menu = 0;
		int subMenu = 0;
		Scanner scan = new Scanner(System.in);
		do {
			abp.prinMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				abp.insert();
				break;
			case 2:
				abp.update();
				break;
			case 3:
				abp.delete();
				break;
			case 4:
				abp.printSubMenu();
				subMenu =scan.nextInt();
				switch(subMenu) {
				case 1 : 
					abp.printItemListDetail();
					break;
				case 2:
					abp.printItemlistSimple();
					break;
				case 3:
					abp.printItem();
					break;
				case 4:
					abp.printTotal();
				default :
					System.out.println("잘못된 메뉴");
				}
				break;
			case 5:
				System.out.println("그로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴");
			}
			
		}while(menu != 5);

	}

}
