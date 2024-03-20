package day0320;

import java.util.Scanner;

public class Ex9_ArraySearchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []members= {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		/*
		 * 이름을 검색(searchName)
		 * 몇번째에 있는지 출력
		 * 반복해서 검색하다가 'q'나 'Q'를 입력시 종료
		 */
		Scanner sc=new Scanner(System.in);
		String searchName;
		int searchIndex;


		while(true) {
			searchIndex=-1;
			System.out.println("이름을 검색하세요");
			searchName=sc.nextLine();
			if(searchName.equalsIgnoreCase("q")) {
				System.out.println("검색을 종료합니다.");
				break;}
			for(int i=0;i<members.length;i++) {
				if(searchName.equals(members[i]))
				{
					searchIndex=i;
					break;}
			}
			if (searchIndex==-1)
				System.out.println(searchName+"님은 멤버명단에 없습니다.");
			else

				System.out.printf("%s님은 %d번째에 있습니다.\n",searchName,(searchIndex+1));}

	}

}

