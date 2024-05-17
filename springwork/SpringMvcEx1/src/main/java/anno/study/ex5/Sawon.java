package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;



@Getter
@Component
public class Sawon {
	
	@Value("손가원")
	private String name;
	@Value("강남구")
	private String addr;
	@Value("15")
	private int age;

	
}
