package day0322;

class Stu//기능 : 선언과 초기값
{
	String name="이영자";
	String blood="A";
	int age=12;
}
public class Ex6_CallByReference {

	public static void chageStu(Stu s)//기능 : 초기값 변경
	{	
		//주소를 통해서 main 의 s 변수의 값을 직접 변경
		s.blood="O";
		s.age=34;
	}
	public static void main(String[] args) //기능 : 변경된 초기값 불러와 출력
	{
		// TODO Auto-generated method stub
		Stu s=new Stu();
		System.out.println(s.name+","+s.blood+","+s.age);
		chageStu(s);//Call By Reference
		System.out.println("메서드 호출 후 다시출력");
		System.out.println(s.name+","+s.blood+","+s.age);

	}

}
