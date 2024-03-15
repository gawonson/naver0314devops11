package day0315;

import java.util.Scanner;

public class Ex12_munjea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		int score;
		String msg;
		String msg90 = "참 잘했어요!!";
		String msg80 = "수고했어요!";
		String msg70 = "조금 더 노력하세요";
		String msg60 = "재시험입니다!";
		
		System.out.println("점수");
		score = sc.nextInt();
		
		msg=score>=90?msg90: //msg=score>=90?"참 잘했어요!!":score>=80?...
			score>=80?msg80:
				score>=70?msg70:
					msg60;
				
		System.out.println(score+"=>"+msg);
				
	}
}

