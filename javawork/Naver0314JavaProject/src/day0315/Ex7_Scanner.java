package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int kor, eng;
		String name;
		System.out.println("국어 점수를 입력하세요");
		kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어점수를 입력하세요");
		eng = Integer.parseInt(sc.nextLine());
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		
		System.out.printf("국어점수는 %d,영어점수는 %d, 이름은 %n입니다",kor,eng,name);
		System.out.printf("총점은 %d,평균은 %3.1f입니다.",kor+eng,(kor+eng)/2.0);
		
			}

}
