 package enums;

import java.util.Scanner;

public class EnumSeasonTest2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계절을 입력하세요(봄/여름/가을/겨울): ");
		String input = sc.nextLine();
		
		Season season = null;
		
		switch(input) {
		case "봄":
			season = Season.봄;
			break;
		case "여름":
			season = Season.여름;
			break;
		case "가을":
			season = Season.가을;
			break;
		case "겨울":
			season = Season.겨울;
			break;
		default:
			System.out.println("계절이 없습니다.");
		}
		System.out.println("현재 계절은 " + season + "입니다.");
		
		sc.close();
	}
}

