package day0321;

import java.util.Scanner;

public class Book199_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int students,score,avg,hap=0,a=0,dap;
		int []arr;
		System.out.println("학생 수: ");
		students=sc.nextInt();
		arr=new int[students];
		for(int i=0;i<students;i++) 
		{
			System.out.println((i+1)+"번 학생 점수 입력 :");
			score=sc.nextInt();
			arr[i]=score;
		}
		for(int i=0; i<arr.length;i++) {
			hap+=arr[i];	
		}
		avg=hap/students;

		for(int i=0; i<students;i++) {
			for (int j=1;j<students;j++) {
				if(arr[i]<arr[j])
				{
					a=arr[j];
				}
			}
		}
		System.out.println("-".repeat(30));
		System.out.println("1. 학생수 |  2. 점수리스트 | 3. 분석 | 4. 종료");
		System.out.println("-".repeat(30));
		Loop:	
			while(true) {
				dap=sc.nextInt();
				if (dap==1)
				{
					System.out.print("1.학생수 :"+students);
					System.out.println();
					continue Loop;

				}
				if(dap==2)
				{System.out.println("2. 점수 리스트 ");
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]);
					System.out.print("   ");
					System.out.println();
				}
				System.out.println();
				continue Loop;
				}
				if(dap==3) {
					System.out.println("3. 분석");
					System.out.printf("최댓값 : %d, 평균 : %d",a,avg);
					System.out.println();
					continue Loop;
				}
				if(dap==4)
					System.out.println("종료합니다.");
				break;
			}

	}
}