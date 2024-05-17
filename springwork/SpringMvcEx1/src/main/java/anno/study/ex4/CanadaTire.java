package anno.study.ex4;

import org.springframework.stereotype.Component;

@Component // id=canadaTire
public class CanadaTire implements Tire{

	@Override
	public String getTireName() {

		// TODO Auto-generated method stub
		return "캐나다 타이어";
	}
}
