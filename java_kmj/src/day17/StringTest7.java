package day17;

import java.util.Scanner;

public class StringTest7 {

	public static void main(String[] args) {
		String str ="1234-567-1564";
		String []arr = str.split("-");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		/* 취미를 한줄로 입력받아 각 취미를 출력하는 코드를 작성하세요 
		 * 예시 :
		 * 취미를 입력하세요(예 : 영화보기, 음악감상, 독서) :  영화보기, 음악감상
		 * 취미리스트
		 * 1. 영화보기
		 * 2. 음악감상
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("취미를 입력하세요(예 : 영화보기, 음악감상, 독서) : ");
		String str1 = scan.nextLine();//nextLiNe은 띄어쓰기, 공백 모두 표현(?) 
		String [] hobbyList = str1.split(", "); 
		for(int i =0 ; i < hobbyList.length; i++) {
			System.out.println((i+1) + "." + hobbyList[i]);
		}
		scan.close();
		
		
		
	}

}
