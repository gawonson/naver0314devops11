package study.ex3;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	@NonNull
	private String name;
//	final private String name = null;
	private String phone;

	
//	public Person(String name) {
//		super();
//		this.name = name;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//
//	public String getPhone() {
//		return phone;
//	}
//	

	
}
