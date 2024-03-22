package day0322;

class Apple
{
	String msg="Happy Day!!";//인스턴스 멤버변수
	static String massage="오늘은 금요일";//static 멤버변수(=클래스 멤버변수)
}
class Banana
{
	static int kor=100;
	static int eng=80;
	String name="마이클";
}
public class Ex1_Object 
{
	//멤버변수들
	String name="홍길동";//인스턴스 변수
	final static int Max= 100;// static 변수 , final : 상수 지정 (값변경 xx)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static 멤버 메서드는  static 멤버 변수나 멤버 메서드만
		 * 접근가능
		 * 일반 인스턴스 메서드나 변수를 접근하기위해서는 new 로 생성후
		 * 그 변수를 이용해서 호출해야만 한다.
		 */
		//System.out.println(name);//오류발생
		System.out.println(Ex1_Object.Max);
		System.out.println(Max);//같은 클래스일 경우는 앞에 클래스명 생략가능

		//name 을 출력하려면 new 로 생성한 인스턴스 변수가 필요하다.
		Ex1_Object ex = new Ex1_Object();
		//ex 가 인스턴스 변수이다. 이 변수를 이용해야만 name 이 접근 가능
		System.out.println(ex.name);
		//Apple 이 가진 2개의 멤버변수를 출력해보세요

		Apple app=new Apple();// msg 호출을 위한 선언(요놈은 static 이 아니기때문에)
		System.out.println(app.msg);
		System.out.println(Apple.massage);//요놈은 static 이기때문에 바로 호출 가능

		//Banana 클래스의 변수 호출, 합계출력
		Banana banana=new Banana();
		int sum=Banana.kor+Banana.eng;
		System.out.println("영어점수 : "+Banana.eng);
		System.out.println("국어점수 : "+Banana.kor);
		System.out.println("영어점수 + 국어점수 : "+sum);
		System.out.println("이름 : "+banana.name);
	}
}
