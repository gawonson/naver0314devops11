package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appex3.xml");
		MyCart mc=(MyCart)context.getBean("c");
		mc.showInfo();
		
		System.out.println();
		MyCart mc2=(MyCart)context.getBean("c");
		mc2.showInfo();
		
		System.out.println();
		MyCart mc3=(MyCart)context.getBean("c");
		mc3.showInfo();
		
		System.out.println("singleton인 경우는 여러번 생성해도 주소가 같고 \n prototype인 경우는 새로 생성할때마다 새로운 주소에 생성된다(계속 바뀜)");
		
		System.out.println(mc.hashCode());
		System.out.println(mc2.hashCode());
		System.out.println(mc3.hashCode());
	}

}
