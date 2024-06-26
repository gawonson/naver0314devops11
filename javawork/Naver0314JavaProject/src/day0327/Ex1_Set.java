package day0327;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex1_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 *  Set 인터페이스를 구현한 클래스로는 TreeSet 과 HashSet 이 있다.
 *  Set type 의 특징:
 *  1. 중복데이터를 허용하지 않는다
 *  2. 비순차적이다. (내가 넣은 순서대로 나오진 않는다.)
 *  3. TreeSet 은 오름차순으로 들어간다.
 *  4. HashSet 은 순서가 따로 없다.
 */
		//<Integer> :제네릭, 해당 컬렉션에는 Integer type 만 넣을수 있다. 다른 타입을 넣을경우 컴파일 오류 발생
		//Set<Integer> set1= new HashSet<Integer>();// 제네릭은 뒷부분<integer> 생략 가능
		Set<Integer> set1=new TreeSet<Integer>();
		set1.add(100);//JDK5 이전에는 set1.add(new Integer(100))이라고 했어야함 하지만 지금은 자동으로 바뀌어서 들어감
		set1.add(78);
		set1.add(100);
		set1.add(78);
		set1.add(65);
		
		System.out.println("set1의 데이터 갯수 출력 "+set1.size());//3 그 이유는 ? 중복 허용 x
		System.out.println("** 출력 1 **");
		for(int n:set1)//hashset 의 경우 랜덤으로 출력 // treeset 은 오름차순 출력
		{System.out.println(n);}
		System.out.println("** 출력 2 **");
		Iterator<Integer> iter=set1.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
	}

}
