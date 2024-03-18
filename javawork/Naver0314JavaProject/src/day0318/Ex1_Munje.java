package day0318;

import java.util.Scanner;

public class Ex1_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score;
		String grade;
		
		System.out.println("점수?");
		score = sc.nextInt();
		
		// if 문을 이용해서 점수를 잘못입력했을경우 메서드 종료를 하자
		if(score<1 || score >100)
		{
			System.out.println("잘못된 점수입니다.");
			return; //메인 메서드를 종료 (곧 프로그램이 종료됨)
			
		}
		
		grade=score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F";
		System.out.printf("%d점은 %s학점입니다.",score,grade);
	}
}
