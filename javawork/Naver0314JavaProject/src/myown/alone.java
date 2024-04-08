package myown;

import java.util.Scanner;
class BankApplication{
	static Scanner sc=new Scanner(System.in);
	static Account1[] accountArray=new Account1[100];

	//기본메뉴 메서드
	public void menu() {
		int select;
		while (true) {
			title();
			select=Integer.parseInt(sc.nextLine());

			if(select==1) {
				createAccount();
			}
			else if(select==2) {
				writeAccount();
			}
			else if(select==3) {
				inputAccount();
			}
			else if(select==4) {
				outputAccount();
			}
			else if(select==5) {
				break;
			}
			else {
				System.out.println("잘못입력하였습니다.");
				continue;
			}
		}

	}

	//계좌생성 메서드
	public void createAccount() {
		System.out.println("-".repeat(10));
		System.out.println("계좌생성");
		System.out.println("-".repeat(10));

		String accountNumber,owner;

		int balance;

		System.out.println("계좌번호 : ");
		accountNumber = sc.nextLine();


		System.out.println("계좌주 : ");
		owner = sc.nextLine();


		System.out.println("초기입금액 : ");
		balance = Integer.parseInt(sc.nextLine());


		for(int i=0;i<accountArray.length;i++) {

			if(accountArray[i]==null) {
				Account1 account=new Account1(accountNumber, owner, balance);
				accountArray [i]=account;
				System.out.println("결과: 계좌가 생성되었습니다.");
				System.out.println(accountArray[i]);
				break;
			}
			else if(accountArray[i]!=null&&accountArray[i].getAccountNumber().equals(accountNumber))
			{
				System.out.println("확인바람");
				break;
			}
		}
	}

	//목록출력 메서드
	public void writeAccount() {
		System.out.println("-".repeat(10));
		System.out.println("계좌목록");
		System.out.println("-".repeat(10));

		
		
		for(int i=0;i<accountArray.length;i++) 
		{
			if(accountArray[i]!=null) 
				{
				String raccountNumber = accountArray[i].getAccountNumber();
				String rOwner=accountArray[i].getOwner();
				int rBalance=accountArray[i].getBalance();
				System.out.println(raccountNumber+"\t"+rOwner+"\t"+rBalance);
				}
			else
				break;
		}

	}

	//예금
	public void inputAccount() {
		System.out.println("-".repeat(10));
		System.out.println("예금");
		System.out.println("-".repeat(10));
		
		
	}
	//출금
	public void outputAccount() {
		System.out.println("-".repeat(10));
		System.out.println("출금");
		System.out.println("-".repeat(10));

		System.out.println("계좌번호: ");
		String accontNumber= sc.nextLine();
		System.out.println("출금액: ");
		int balance=Integer.parseInt(sc.nextLine());
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i].getAccountNumber().equals(accontNumber)) {

			}
		}
	}
	//메뉴
	public void title() {
		System.out.println("-".repeat(30));
		System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
		System.out.println("-".repeat(30));
		System.out.println("선택> ");
	}
}
//getter setter private 변수
class Account1{
	private String AccountNumber;
	private String Owner;
	private int balance;
	public Account1(String accountNumber, String owner, int balance) {

		this.AccountNumber = accountNumber;
		this.Owner = owner;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public String getOwner() {
		return Owner;
	}
	public int getBalance() {
		return balance;
	}

	public void setAccountNumber(String accountNumber) {
		this.AccountNumber = accountNumber;
	}
	public void setOwner(String owner) {
		this.Owner = owner;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


}
public class alone{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankApplication bk=new BankApplication();
		bk.menu();
	}
}





