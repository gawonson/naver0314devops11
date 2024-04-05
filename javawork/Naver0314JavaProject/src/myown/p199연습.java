package myown;

import java.util.Scanner;

public class p199연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Scanner sc =new Scanner(System.in);
				int su,stu=0,score=0;
				int[]scores=new int[0];
				int max=0,total=0;
				double avg=0;
				while(true)
				{System.out.println("-".repeat(45));
				System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("-".repeat(45));
				System.out.print("선택> ");
				su=sc.nextInt();
				if(su==1){
					System.out.print("학생수> ");
					stu=sc.nextInt();
					scores=new int[stu];
				}
				if(su==2)
					for(int i=0;i<stu;i++) {
						System.out.print("scores["+i+"]> ");
						score=sc.nextInt();
						scores[i]=score;
					}
				if(su==3)
				{
					for(int i=0;i<scores.length;i++) {
						System.out.println("score["+i+"]: "+scores[i]);
					}
				}
				if(su==4) {
					for(int i=0;i<scores.length;i++)
					{
						total+=scores[i];
						if(scores[i]>max)
							max=scores[i];
					}
					avg=total/stu;
					System.out.println("최고 점수: "+max);
					System.out.printf("평균 점수: %.1f\n",avg);
				}
				if(su==5) {
					System.out.println("프로그램 종료");
					return;
				}
				}
			
	}

}
