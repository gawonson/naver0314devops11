package study.ex2;

public class Student {
	private String schoolName;
	MyInfo myInfo;


	//MyInfo ������ �����ڷ� ����
	public Student(MyInfo info) {
		// TODO Auto-generated constructor stub
		myInfo=info;
	}

	//�б�����  setter ����
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public  void show() {
		System.out.println(myInfo);//�ڵ����� toString ȣ��
		System.out.println("�б��� : "+schoolName);
	}
}
