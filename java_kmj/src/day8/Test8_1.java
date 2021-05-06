package day8;

import java.util.Scanner;

import com.sun.management.UnixOperatingSystemMXBean;

public class Test8_1 {

	public static void main(String[] args) {
		/* 1~9사이의 정수를 입력받아 각 숫자가 몇번 입력됐는지 출력하는 코드를 작성하세요.
		 * -1이 입력되면 입력 종료하고 각 숫자가 몇번 입력됐는지 출력
		 * 예시
		 * 입력 : 1
		 * 입력 : 1
		 * 입력 : 9
		 * 입력 : 3
		 * 입력 : 2
		 * 입력 : -1
		 * 1 : 2번
		 * 2 : 1번
		 * 3 : 1번
		 * 4 : 0번
		 * 5 : 0번
		 * 6 : 0번
		 * 7 : 0번
		 * 8 : 0번
		 * 9 : 1번
		 * */
		
		//1~9사이의 정수를 입력받음 => 1~9까지 랜덤한 숫자를 n번 입력받음 
		
		// 반복문을 이용하여 정수를 입력받음
		int num;//콘솔에서 입력받은 정수를 저장
		int[]arr = new int[10];//배열의 1번지~9번지까지 쓰기위해
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("입력(1~9) : ");
			num = scan.nextInt();
			if(num < 1 || num > 9) {//-1이면 종료 => 1~9 이외의 숫자가 입력되면 종료
				break;
				
			}
			arr[num] += 1;//입력받은 num을 배열arr의 번지에 저장, 
		}
		for(int i =1; i < arr.length ; i +=1 ) {//배열의 0번지 사용안하고 1번지부터 출력하기때문에 'i = 1'부터
			System.out.println(i + " : " + arr[i] + "번");
		}
		
		
		scan.close();
	}

}
