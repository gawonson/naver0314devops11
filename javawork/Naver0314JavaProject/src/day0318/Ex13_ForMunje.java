package day0318;

import java.util.Scanner;

public class Ex13_ForMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("지수승 구하기");
		System.out.println("3의3승은 "+(int)Math.pow(3, 3));
		System.out.println("2의4승은 "+(int)Math.pow(2, 4));
		
		
		Scanner sc=new Scanner(System.in);
		int x,y,sum=1;
		
		System.out.println("x입력");
		x=sc.nextInt();
		System.out.println("y입력");
		y=sc.nextInt();
		for (int i=1;i<=y;i++) {
			sum*=x;
		}
		System.out.printf("%d의 %d승은 %d입니다.",x,y,sum);
	}

}
