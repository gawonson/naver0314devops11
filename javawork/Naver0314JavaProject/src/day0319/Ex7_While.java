package day0319;

import java.util.Scanner;

import day0318.Ex6_ScoreSwitch;

public class Ex7_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while문을 이용하여 score점수를 입력받은 후
		//0을 입력하면 while문을 빠져나가서 총 갯수와 합계를 구하시오
		//(단,1~100이 아닌 값은 갯수와 합계에서 제외
		Scanner sc=new Scanner(System.in);
		int score,count=0,sum=0;
		while(true) {	
			System.out.println("점수?(종료:0)");
			score=sc.nextInt();
			if(score==0)
				break;
			if(0>score||score>100)
				continue;
			count++;
			sum+=score;
		}
		System.out.printf("입력한 갯수 :%d\n",count);
		System.out.println("총 점수 :"+sum);
	}
}