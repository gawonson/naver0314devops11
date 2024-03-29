package day0325;
//같은 패키지 내에서는 부모가 가진 메서드중 private 를 제외하고 모두 상송을 받는다
class Parent1
{
	void method1()
	{
		System.out.println("부모의 디폴트 메서드");
	}
	protected void method2()
	{
		System.out.println("부모의 protected 메서드");
	}
	private void method3()
	{
		System.out.println("부모의 private 메서드");
	}
	public void method4()
	{
		System.out.println("부모의 public 메서드");
	}
}
//서브클래스 구현
class Sub1 extends Parent1
{
	public void show()
	{
		/*
		 * 현재 클래스에 같은 이름의 메서드가 존재할경우
		 * 부모메서드 호츨시 super. 으로 호출 
		 * 
		 * 같은 이름의 메서드가 없을경우
		 * super 대신 this. 으로 호출해도됨
		 * 
		 * 같은 이름의 메서드를 Override 메서드라 부름
		 */
		this.method1();//default, 부모가 다른 패키지에 있다면 default 도 호출 안됨
		this.method2();//protected
//		this.method3(); private 상속 안됨
		this.method4();//public
		System.out.println("supper 로 호출");
		super.method1();
		super.method2();
		super.method4();
		
	}
}

public class Ex5_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub1 s=new Sub1();
		s.show();
	}

}
