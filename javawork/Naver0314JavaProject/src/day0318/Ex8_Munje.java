package day0318;

import java.util.Scanner;

public class Ex8_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		String sang;
		int su, dan, total,dctotal;
		
		System.out.println("상품명?");
		sang=sc.nextLine();
		System.out.println("수량?");
		su=sc.nextInt();
		System.out.println("단가?");
		dan=sc.nextInt();
		total=dan*su;  
		System.out.println(sang+" "+su+"개의 총금액:"+total);
		if (su>=5) {
			dctotal=(int)(dan*su*0.9);
			System.out.println("10프로 할인입니다.");
			System.out.println("10프로 할인된 금액:"+dctotal);
		}

	}

}