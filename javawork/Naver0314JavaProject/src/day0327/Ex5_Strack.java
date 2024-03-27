package day0327;

import java.util.List;
import java.util.Stack;

public class Ex5_Strack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 인터페이스를 구현한 클래스 중 하나
		//Last In First Out (LIFO) 방식
		Stack<String> stack1=new Stack<String>();
//		List<String> stack1=new Stack<String>();// push 는 오버라이드 메서드가 아님 따라서 리스트로 선언할 경우 오류남 
		stack1.push("사과");
		stack1.push("바나나");
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("딸기");
		
		System.out.println("총 갯수 : "+stack1.size());
		
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop());//마지막으로 추가한 딸기가 먼저 출력됨 내가 넣은 순서에 역순으로 출력됨, 중복 허용.
		}
		
	}

}
