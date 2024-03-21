package day0321;

import java.util.Scanner;

public class Ex4_ArrayAlphaCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 영어 문장을 입력하면 알파뱃 기준으로 각각의 갯수를 출려갛시요
		 * CharAt ++,, ignore,.. 
		 * Have a Nice Day!!!
		 * 
		 * A:3 B:0 ...Z:0
		 */

		Scanner sc=new Scanner(System.in);
		String msg;
		int []alpha=new int[26];

		System.out.println("영어문장 입력");
		msg=sc.nextLine();
		//영어문장 출력
		System.out.println(msg);
		for (int i=0;i<msg.length();i++)
		{
			char ch=msg.toUpperCase().charAt(i);//대문자로 바꾸고 ch에 저장
			if(ch>='A'&&ch<='Z')//영어가 아닌것은 제외
				alpha[ch-'A']++;//대문자로 바꾼 값의 아스키코드에서 'A'아스키코드 값 빼주고 다음으로 넘어감
			//alpha는 알파벳 갯수의미 'a'-'a'=0....'e'-'a'=4 

		}
		System.out.println("**알파벳별 갯수 구하기");
		for(int i=0;i<alpha.length;i++)
		{
			System.out.printf("%c:%d\t",(char)'A'+i,alpha[i]);
			if((i+1)%5==0)
				System.out.println();
		}
	}
}
