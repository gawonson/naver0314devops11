package day0327;

public class StudentDto {
	private String name;
	private String age;
	private int java;
	private int spring;
	private int html;
	// 디폴트생성자
	public StudentDto() {
		super();
	}


	//매개변수 있는 생성자
	public StudentDto(String name, String age, int java, int spring, int html) {
		super();
		this.name = name;
		this.age = age;
		this.java = java;
		this.spring = spring;
		this.html = html;
	}
	//setter and getter//
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String a) {
		this.age = a;
	}


	public int getJava() {
		return java;
	}


	public void setJava(int java) {
		this.java = java;
	}


	public int getSpring() {
		return spring;
	}


	public void setSpring(int spring) {
		this.spring = spring;
	}


	public int getHtml() {
		return html;
	}


	public void setHtml(int html) {
		this.html = html;
	}

	//java + spring + html 의 합의 반환하는 메서드(getTotal)
	public int getTotal() {
		return spring+java+html;
	}

	//getTotal()/3.0 으로 나눠서 반환하는 메서드(getAvg)
	public double getAvg() {
		return getTotal()/3.0;

	}

	//반환하는 메서드(getGrade)
	//getAvg()의 값이 90이상이면 "*****", 80이상이면"****",70이상이면 "***",나머지는 "*"
	public String getGrade() {
		if(getTotal()>=90)
			return "*****";
		else if(getTotal()>=80) 
			return "****";
		else if(getTotal()>=70)
			return "***";
		else 
			return "*";
	}
}