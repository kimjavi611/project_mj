package accountbook;

import java.util.Scanner;

public class AccountBookTest {
	
	public static void main(String[] args) {
		AccountBookProgram2 abp = new AccountBookProgram2();
		int menu = 0;
		do {
			abp.insert();
			int submenu = 0;
			Scanner scan = new Scanner(System.in);
			switch(menu) {
			case 1:
				abp.update();
				break;
			case 2:
				abp.delete();
				break;
			case 3:
				abp.printItemListDetail();
				break;
			case 4:
				abp.printItemlistSimple();
				break;
			case 5:
				abp.printItem();
				break;
			case 6:
				abp.printTotal();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
	}
}
