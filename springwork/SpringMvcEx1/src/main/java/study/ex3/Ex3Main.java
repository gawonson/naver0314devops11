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
		
		System.out.println("singleton�� ���� ������ �����ص� �ּҰ� ���� \n prototype�� ���� ���� �����Ҷ����� ���ο� �ּҿ� �����ȴ�(��� �ٲ�)");
		
		System.out.println(mc.hashCode());
		System.out.println(mc2.hashCode());
		System.out.println(mc3.hashCode());
	}

}
