package day0315;

import java.util.Scanner;

public class Ex7_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int kor, eng;
		String name;
		System.out.println("국어점수는?");
		kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어점수는?");
		eng = Integer.parseInt(sc.nextLine());
		
		System.out.println("이름은?");
		name=sc.nextLine();//점수뒤의 엔터를 읽어온다(엔터가 버퍼에 저장되어있는상태)
		
		System.out.println("이름:"+name);
		System.out.printf("국어점수:%d점,영어점수:%d점\n",kor,eng);
		System.out.printf("총점 : %d점,평균: %3.1f점",kor+eng,(kor+eng)/2.0);//결과를 소수점 받을때는 int/double로(숫자에 .0붙이기) int/int는 int로 답 나옴
	}

}
