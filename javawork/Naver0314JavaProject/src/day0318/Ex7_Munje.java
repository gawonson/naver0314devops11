package day0318;

import java.util.Scanner;

public class Ex7_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		String name;
		int gibon,familysu,totpay;
		System.out.println("이름?");
		name=sc.nextLine();
		System.out.println("기본급?");
		gibon=sc.nextInt();
		System.out.println("가족수?");
		familysu=sc.nextInt();

		if (familysu>=3) {
			totpay=gibon+(familysu*50000);
		}else {
			totpay=gibon+30000;
		}
		System.out.println("이름:"+name);
		System.out.println("기본급:"+gibon+"원");
		System.out.println("가족수:"+familysu+"명");
		System.out.println("실수령액:"+totpay+"원");
	}

}
