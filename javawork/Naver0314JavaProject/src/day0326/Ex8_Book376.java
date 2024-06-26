package day0326;

//롤 생성
interface Tire{
	void roll();
}
//한국타이어에 롤 넣기
class HankookTire implements Tire{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
	System.out.println("한국타이어가 굴러갑니다.");	
	}
}
//금호타이어에 롤 넣기
class KumhoTire implements Tire{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
	System.out.println("금호타이어가 굴러갑니다.");	
	}
}
//자동차 만들어서 타이어 1,2 생성 후 한국타이어와 금호타이어 배정해주기
class Car
{
	Tire tire1=new HankookTire();
	Tire tire2=new HankookTire();
	
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
public class Ex8_Book376 {
//내 만들어서 내 차가 달릴때 한국타이어끼고 달림
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar=new Car();
		
		myCar.run();
		//금호타이어로 타이어 교체
		myCar.tire1=new KumhoTire();
		myCar.tire2=new KumhoTire();
		
		myCar.run();
	}

}
