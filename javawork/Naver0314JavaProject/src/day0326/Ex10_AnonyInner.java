package day0326;

abstract class Hello
{
	abstract public void study();
	
}
interface Happy{
	public void insert();
	public void delete();
}
class Kiwi
{//익명 내부클래스 형태
	Hello h=new Hello() {
		
		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("익명 내부클래스에 대해 공부 중");
		}
	};
	Happy ha=new Happy() {
		
		@Override
		public void insert() {
			// TODO Auto-generated method stub
			System.out.println("데이터를 추가합니다.");
		}
		
		@Override
		public void delete() {
			// TODO Auto-generated method stub
			System.out.println("데이터를 삭제합니다.");
			
		}
	};
}
public class Ex10_AnonyInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kiwi k=new Kiwi();
		k.h.study();
		k.ha.insert();
		k.ha.delete();
		
	}
}
