package day0318;

import java.util.Scanner;

public class Ex14_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int score,count,sum;
		count=0;
		sum=0;
		for (int i=1;i<=5;i++) {
			System.out.println("점수는?");
			score=sc.nextInt();
			if(score>100||score<1)
				continue;
			count+=1;			
			sum+=score;
		}
		
		System.out.println("입력한 점수 갯수:"+count);
		System.out.println("총 합계:"+sum);
	}

}
