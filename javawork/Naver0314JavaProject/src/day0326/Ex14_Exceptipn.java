package day0326;

import java.util.Date;

public class Ex14_Exceptipn {
	static public void go1() throws NullPointerException,NumberFormatException
	{
		//Date date=null;
		Date date=new Date();
		System.out.println(date.getYear()+1900);
		
		//String a="12a";
		String a="12";
		int n=Integer.parseInt(a);//여기서  NumberFormatException
		System.out.println(n+10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			go1();
		}catch (NullPointerException e) {
			System.out.println("Date 클래스를 생성하고 메서드 호출:"+e.getMessage());
		}
		catch(NumberFormatException e1) {
			System.out.println("문자가 있어서 숫자변환시 오류발생:"+e1.getMessage());
		}finally {
			System.out.println("이 영역은 무조건 실행됩니다.");
		}
		System.out.println("** 정상 종료 **");
	}
}