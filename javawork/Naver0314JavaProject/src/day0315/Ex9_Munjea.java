package day0315;

import java.util.Scanner;

public class Ex9_Munjea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("금액 입력 :");
		int money = sc.nextInt();
		
		System.out.printf("만원 : %d장\n",money/10000);
		System.out.printf("천원 : %d장\n",(money/1000)%(money/10000));// (money%10000/1000)
		System.out.printf("백원 : %d장\n",(money/100)%(money/1000));
		System.out.printf("십원 : %d장\n",(money/10)%(money/100));
		System.out.printf("일원 : %d장",(money/1)%(money/10));
		
	}

}
