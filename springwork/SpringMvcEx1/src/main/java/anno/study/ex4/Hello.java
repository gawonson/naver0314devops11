package anno.study.ex4;

import org.springframework.stereotype.Component;



//component 
//등록 순서 
//1. xml파일의 namespaces에 가서 context 항목 추가 
//2. <context:component-scan base-package=""></context:component-scan> 추가

//@Component//xml에 자동 등록 기능 // 이름 설정 안할시 자동으로 클래스 이름이 id가 된다,(단 첫글자는 소문자)
@Component("h")


public class Hello {
	public void showMessage() {
		System.out.println("Hello class가 가진 method입니다.");
	}
}
