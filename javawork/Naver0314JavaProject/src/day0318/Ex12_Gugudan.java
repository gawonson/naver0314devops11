package day0318;

import java.util.Scanner;

public class Ex12_Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int x;
		System.out.println("구구단?");
		x=sc.nextInt();
		
		if (x<2||x>9) 
		{
			System.out.println("잘못된 숫자입니다.");
		}
		else {
			System.out.printf("** %d단 **\n\n",x);
			for (int i=1;i<=9;i++) 
			{
				System.out.printf("%d X %d = %2d\n",x,i,x*i);
			}
		}
	}
}
