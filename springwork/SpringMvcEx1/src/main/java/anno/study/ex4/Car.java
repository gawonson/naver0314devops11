package anno.study.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//xml방식으로  bin 등록


//annotation으로 수정

//tire 을 lombok을 이용해서 주입해보자
@RequiredArgsConstructor //nonnull이 붙은 멤버변수만 생성자로 주입된다.
@Component // id=car
public class Car {
	@Value("아우디")
	private String carName;
	
	@NonNull
	//private Tire tire; //자동으로 찾아서 주입을 시켜줌 , 이번에는 Tire을 구현한 클래스가 2개이므로 모호성으로 인해 오류발생
	private KoreaTire tire; //이 경우는 정확하게 클래스명으로 선언을해야만 오류가 발생하지 않음
	
//	public Car(Tire tire) {
//		// TODO Auto-generated constructor stub
//		this.tire=tire;
//	}
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
	public void carInfo() {
		System.out.println("자동차명 : "+carName);
		System.out.println("타이어 : "+tire.getTireName());
	}
}
