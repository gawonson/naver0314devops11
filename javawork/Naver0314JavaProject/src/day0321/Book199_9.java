package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int students=0,score,high=0,hap=0,dap,avg=0;
		int []scoreList=new int[0];
		while(true) {	
			System.out.println();
			System.out.println("=".repeat(30));
			System.out.println("1. 학생수 |2. 점수입력 |3. 점수리스트 |4. 분석 |5.종료");
			System.out.println("=".repeat(30));
			System.out.print("선택>");
			dap=sc.nextInt();
			if(dap==1) {
				System.out.print("학생수> ");
				students=sc.nextInt();
				scoreList=new int [students];
			}
			if(dap==2) {
				for(int i=0;i<students;i++) {
					System.out.printf("scores[%d]:",i);
					score=sc.nextInt();

					scoreList[i]=score;
					hap+=score;
					avg=hap/students;


				}}

			if (dap==3) {

				for(int i=0;i<scoreList.length;i++) {
					System.out.printf("score[%d]: %d\n",i,scoreList[i]);
				}
			}
			if(dap==4) {
				//최고점수 구하기
				for(int i=0;i<scoreList.length;i++)
				{
					for(int j=1;j<scoreList.length;j++) {
						if(scoreList[i]>scoreList[j])
							high=scoreList[i];
					}
				}
				System.out.printf("최고 점수: %d\n평균 점수: %d\n",high,avg);//최고점수 구하기
			}
			if(dap==5) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}