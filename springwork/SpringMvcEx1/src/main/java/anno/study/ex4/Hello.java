package anno.study.ex4;

import org.springframework.stereotype.Component;



//component 
//��� ���� 
//1. xml������ namespaces�� ���� context �׸� �߰� 
//2. <context:component-scan base-package=""></context:component-scan> �߰�

//@Component//xml�� �ڵ� ��� ��� // �̸� ���� ���ҽ� �ڵ����� Ŭ���� �̸��� id�� �ȴ�,(�� ù���ڴ� �ҹ���)
@Component("h")


public class Hello {
	public void showMessage() {
		System.out.println("Hello class�� ���� method�Դϴ�.");
	}
}
