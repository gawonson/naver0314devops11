package day0327;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import day0325.Student;

/*
 * 1.학생 정보추가	: 이름, 나이, 3과목 점수 입력(numberformatexception||runtimeexception)	
 * 2.학생정보 삭제 : 이름으로 찾아서 삭제 (없을경우 메세지 출력)	
 * 3.전체출력	: 번호,이름,java,spring,html,총점,평균,등급 출력	
 * 4.평균으로 검색: 평균값을 입력하면 그 평균값이상의 학생들만 출력
 * 5.이름으로 검색: 입력한이름을 포함하고 있으면 출력(contains//t/f)
 * 6.저장 후 종료
 */
public class Ex9_VectorMunje {
	List<StudentDto> list=new ArrayList<StudentDto>();
	Scanner sc=new Scanner(System.in);
	static final String FILENAME="d:/naver0314/student.txt";

	Ex9_VectorMunje(){
		studentReadFile();
	}
	//파일 읽기
	public void studentReadFile() {
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;

				String []a=s.split(",");

				StudentDto dto=new StudentDto();

				dto.setName(a[0]);
				dto.setAge(a[1]);
				dto.setJava(Integer.parseInt(a[2]));
				dto.setSpring(Integer.parseInt(a[3]));
				dto.setHtml(Integer.parseInt(a[4]));

				list.add(dto);
			}
			System.out.println("총 "+list.size()+"명의 정보를 불러옵니다.");
			System.out.println("=".repeat(20));

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("읽어올 정보가 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException |NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}
	}
	//파일 저장하기
	public void studentFileSave() {

		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(StudentDto dto:list)
			{
				String s=dto.getName()+","+dto.getAge()+","+dto.getJava()+","+dto.getSpring()+","+dto.getHtml()+"\n";
				fw.write(s);}
			System.out.println("총 "+list.size()+"명의 정보를 저장하였습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}finally {

			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	//메뉴 주기
	public int menu() {
		int num=0;
		System.out.println("1. 학생정보 추가");
		System.out.println("2. 학생정보 삭제");
		System.out.println("3. 전체 학생 출력");
		System.out.println("4. 평균으로 검색");
		System.out.println("5. 이름으로 검색");
		System.out.println("6. 저장 후 종료");
		System.out.println("=".repeat(20));

		System.out.println("번호를 입력하세요  ");
		try{
			num=Integer.parseInt(sc.nextLine());}
		catch(NumberFormatException e)
		{
			System.out.println("숫자를 번호로 입력하세요");
		}
		return num;
	}

	//파일 정보추가
	public void studentAdd() {

		System.out.println("이름을 입력하세요 : ");
		String name=sc.nextLine();
		System.out.println("나이를 입력하세요 : ");
		String age=sc.nextLine();
		System.out.println("JAVA 점수를 입력하세요 : ");
		String java=sc.nextLine();
		System.out.println("SPRING 점수를 입력하세요 :");
		String spring=sc.nextLine();
		System.out.println("HTML 점수를 입력하세요 : ");
		String html=sc.nextLine();
		StudentDto dto=new StudentDto(name,age,Integer.parseInt(java),Integer.parseInt(spring),Integer.parseInt(html));
		list.add(dto);

		System.out.println(list.size()+"번째 학생을 추가하였습니다.");}

	//정보 삭제하기
	public void studentDelete() {
		boolean f= false;
		System.out.println("삭제할 학생의 이름을 입력하세요 : ");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);

			if(dto.getName().equals(name))
			{
				f=true;
				list.remove(i);
				break;
			}
		}if(f)
			System.out.println(name+"학생의 정보를 삭제합니다.");
		else if(!f)
			System.out.println(name+"학생은 명단에 없습니다.");
	}
	//정보 출력하기
	public void studentPrint() {
		System.out.println("**전체 학생 명단**");
		System.out.println("=".repeat(70));
		System.out.println("번호\t이름\t나이\tJAVA\tSPRING\tHTML\t총점\t평균\t등급");
		System.out.println("=".repeat(70));

		for(int i=0;i<list.size();i++)
		{
			StudentDto dto=list.get(i);
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%.2f\t%s\n",(i+1),dto.getName(),
					dto.getAge(),dto.getJava(),dto.getSpring()
					,dto.getHtml(),dto.getTotal(),dto.getAvg(),dto.getGrade());
			//printf안쓰고 소숫점 이하 한자리로 바꾸기
//			NumberFormat nf=NumberFormat.getInstance();
//			nf.setMaximumIntegerDigits(1);
//			nf.format(dto.getAvg())

		}
		System.out.println("=".repeat(70));
	}
	public void studentSearchAvg() {
		//4.평균으로 검색: 평균값을 입력하면 그 평균값이상의 학생들만 출력
		boolean f=false;
		System.out.println("점수를 입력하세요 해당 점수 이상의 학생을 출력합니다.");
		int score=Integer.parseInt(sc.nextLine());

		for(StudentDto dto:list) {

			if(dto.getAvg()>score)
			{
				f=true;
				System.out.println("이름 :"+dto.getName());
				System.out.println("나이 :"+dto.getAge());
				System.out.println("JAVA :"+dto.getJava());
				System.out.println("SPRING :"+dto.getSpring());
				System.out.println("HTML :"+dto.getHtml());
				System.out.println("총점 :"+dto.getTotal());
				System.out.printf("평균 : %.2f\n",dto.getAvg());
				System.out.println("등급 :"+dto.getGrade());
				System.out.println("=".repeat(30));
			}
		}
		if(!f)
			System.out.println("평균이"+score+"점 이상인 학생이 없습니다.");
	}
	public void studentSearchName() {
		boolean f=false;

		System.out.println("이름을 입력하세요 해당 글자를 포함하고 있는 이름을 출력합니다.");
		String name=sc.nextLine();
		for(int i=0;i<list.size();i++) {
			StudentDto dto=list.get(i);
			if(dto.getName().contains(name)) {
				f=true;
				System.out.println("이름 :"+dto.getName());
				System.out.println("나이 :"+dto.getAge());
				System.out.println("JAVA :"+dto.getJava());
				System.out.println("SPRING :"+dto.getSpring());
				System.out.println("HTML :"+dto.getHtml());
				System.out.println("총점 :"+dto.getTotal());
				System.out.printf("평균 : %.2f\n",dto.getAvg());
				System.out.println("등급 :"+dto.getGrade());
				System.out.println("=".repeat(30));
			}
		}
		if(!f)
			System.out.println("이름에"+name+"을 포함한 학생이 없습니다.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_VectorMunje ex=new Ex9_VectorMunje();
		while(true)
		{
			int num=ex.menu();
			switch(num) {
			case 1:
				ex.studentAdd();
				break;
			case 2:
				ex.studentDelete();
				break;
			case 3:
				ex.studentPrint();
				break;
			case 4:
				ex.studentSearchAvg();
				break;
			case 5:
				ex.studentSearchName();
				break;
			case 6:
				ex.studentFileSave();
				System.out.println("=".repeat(20));
				System.out.println("학생 정보를 저장 후 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 번호입니다.");
			}
			System.out.println();
		}
	}
}
