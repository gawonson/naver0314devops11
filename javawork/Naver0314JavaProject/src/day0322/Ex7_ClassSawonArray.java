package day0322;

import java.util.Scanner;

public class Ex7_ClassSawonArray {
	//입력받는 메서드 
	static public void inputSawonArray(Sawon []sa)
	{
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<sa.length;i++)
		{
			System.out.println("사원명은?");
			String name=sc.nextLine();
			System.out.println("기본급은?");
			int gibon=Integer.parseInt(sc.nextLine());
			System.out.println("수당은?");
			int sudang=Integer.parseInt(sc.nextLine());
			
			sa[i]=new Sawon();//초기값이 null 이므로 new 로 생성을 해야 메서드 호출이 가능하다.
			sa[i].setSawon(name, gibon, sudang);
			System.out.println();
			
		}
		
	}
	//출력하는 메서드
	static public void outputSawonArray(Sawon [] sa)
	{
		System.out.println("\t\t[사원 급여 현황]\n");
		System.out.println("번호\t사원명\t기본금\t수당\t실수령액");
		System.out.println("=".repeat(42));
		
		for(int i=0;i<sa.length;i++) {
			System.out.println(i+1+"\t"+sa[i].getName()+"\t"+sa[i].getGibon()
					+"\t"+sa[i].getSudang()+"\t"+sa[i].getNetPay());
		}
	}
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sawon[]sawon=null;
		int inwon;
		Scanner sc=new Scanner(System.in);
		System.out.println("직원 인원수는?");
		inwon=Integer.parseInt(sc.nextLine());
		//인원수만큼 메모리 할당
		sawon=new Sawon[inwon];//인원수만큼 객체 할당, 초기값은 null 따라서 초기값 지정해줘야함(new로 생성)
		
		inputSawonArray(sawon);
		outputSawonArray(sawon);
	}

}
