package day0327;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex6_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> list1=new Vector<String>();//ArrayList 로 바꿀경우 다 똑같지만 capacity 는 vector 가 가진 메서드이기때문에 인식하지 못함
		//List<String> list2=new Vector<String>(5);//5개가 넘을경우 10개로 할당값 변경
		List<String> list2=new Vector<String>(5,3);//5개가 넘을경우 8개로 할당값 변경(5개 두고 넘을 경우 3개씩 점프)
		
		System.out.println("list1 데이터 갯수 : "+list1.size());
		System.out.println("list2 데이터 갯수 : "+((Vector<String>)list1).capacity());//capacity 는 오버라이드 메서드가 아니고 vector 가 갖고있는 메서드
		
		System.out.println("list2 데이터 갯수 : "+list2.size());
		System.out.println("list3의 할당된 갯수 : "+((Vector<String>)list2).capacity());//capacity 는 오버라이드 메서드가 아니고 vector 가 갖고있는 메서드
		
		String[]str= {"red","blue","green","white","red","yellow","pink"};
		//list1,2 에 배열 데이터 추가
		for(String s:str)
		{
			list1.add(s);
			list2.add(s);
		}
		System.out.println("=".repeat(20));
		System.out.println("list1 데이터 갯수 : "+list1.size());
		System.out.println("list2 데이터 갯수 : "+((Vector<String>)list1).capacity());//capacity 는 오버라이드 메서드가 아니고 vector 가 갖고있는 메서드
		
		System.out.println("list2 데이터 갯수 : "+list2.size());
		System.out.println("list3의 할당된 갯수 : "+((Vector<String>)list2).capacity());//capacity 는 오버라이드 메서드가 아니고 vector 가 갖고있는 메서드
		
		//다양한 출력
		System.out.println(" ** 출력 1 ** ");
		
		for(String s:list1)
		{
			System.out.println(s);
		}
		
		
		System.out.println(" ** 출력 2 ** ");
		
		for(int i=0;i<list1.size();i++)
		
		{
			System.out.println(i+":"+list1.get(i));
		}
		vec
		
		System.out.println(" ** 출력 3 ** ");
		
		Iterator<String> iter=list1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

		
		System.out.println(" ** 출력 4 ** ");
		
		Object []ob=list1.toArray();
		for(Object s:ob) {
			System.out.println((String)s);
		}
	}
}
