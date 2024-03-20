package day0320;

import java.util.Random;
import java.util.Scanner;

public class Ex3_RandomGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 1~100 사이의 난수를 발생한 후 숫자 알아맞추기
		 * 2. 숫자입력시 앞에 횟수 출력(1회...)
		 * 3. 숫자 n 이 난수보다 크면(n 보다 작습니다)
		 * 4. 드디어 숫자를 맞췄을경우 (횟수와 정답을 출력 후)
		 * 5. 계속 숫자맞추기 게임을 하시겠습니까?(y/n)(y 와 y 가 아닌 값주기)
		 * 6. y 를 누르면 다시 난수발생 후 숫자맞추기 시작
		 * 7. y 가 아니면 게임 종료
		 */
		Scanner sc =new Scanner(System.in);
		Random rd=new Random();

		String yn;
		int dap=0;
		int su;
		exit:

			while (true) {
				dap=rd.nextInt(100)+1;
				//System.out.println(dap);
				int count=1;
				System.out.println("**숫자맞추기 게임 시작**");
				while(true) {
					System.out.println(count+"회 : ");
					su= Integer.parseInt(sc.nextLine());
					System.out.println("다시 입력하세요.");
					if (dap>su) {
						System.out.println("입력하신 수보다 큽니다.");
						count++;
					}
					else if (su>dap) {
						System.out.println("입력하신 수보다 작습니다.");
						count++;
					}
					else {

						System.out.printf("맞춘 횟수%d회 답: %d \n정답입니다.",count,dap);
						System.out.println("이어서 하시겠습니까? (y/n)");
						yn = sc.nextLine();
						if(yn.equalsIgnoreCase("y")) {
							continue exit;
						}else
							return;}
				}
			}
	}
}



































//		Scanner sc=new Scanner(System.in);
//		Random rd = new Random();
//		int su;
//		int n = rd.nextInt(100)+1;
//		System.out.println("난수 맞추기");
//		Exit:
//			while(true) 
//			{int count =1;
//
//			su=sc.nextInt();
//			System.out.println(n);
//			if (su>n) {
//				System.out.println("난수보다 큽니다.");
//				count++;
//				continue;}
//			if (su<n) {
//				System.out.println("난수보다 작습니다.");
//				count ++;
//				continue;}
//			if (su==n) {
//				count ++;
//				System.out.printf("횟수: %d\n정답: %d\n정답입니다.",count,n);
//				while(true) {
//					System.out.println("계속 숫자맞추기 게임을 하시겠습니까? (y/n)");
//					String dap = sc.nextLine();
//					if (dap=="y") {
//						continue Exit;
//
//					}
//					else {
//						System.out.println("게임을 종료합니다.");
//						break;
//					}}
//
//			}
//			}
//	}
//}
//
//
//
//
