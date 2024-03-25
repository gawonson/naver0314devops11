package day0325;
class Parent2
{
	public void job()
	{
		System.out.println("부모클래스에서 해야 할일 처리...");
	}
}
class Sub2 extends Parent2//클래스
{
	@Override
	public void job() {//메서드
		// TODO Auto-generated method stub
		super.job();//같은 이름의 메서드가 현재클래스에 존재하므로 부모가 가진 메서드 호출시 반드시 super 로 호출한다.
		System.out.println("자식 클래스에서 처리해야할 일...");
	}
}
public class Ex6_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub2 s=new Sub2();//클래스 먼저 호출 후
		s.job();//클래스명 +메서드 호출
	}

}
