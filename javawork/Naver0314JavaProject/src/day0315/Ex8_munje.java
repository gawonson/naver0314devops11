package day0315;

import java.util.Scanner;

public class Ex8_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//선언
		Scanner sc=new Scanner(System.in);
		String name,hp;
		int age,birthYear;
		
		//입력
		System.out.println("이름은?");
		name=sc.nextLine();
		System.out.println("전화번호는?");
		hp = sc.nextLine();
		System.out.println("태어난 년도는?");
		birthYear = sc.nextInt();
		
		//계산
		age= 2024-birthYear;
		
		//출력
		System.out.println(name+","+hp+","+birthYear+","+ age);
		
	}

}
