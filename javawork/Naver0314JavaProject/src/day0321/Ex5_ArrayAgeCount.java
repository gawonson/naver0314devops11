package day0321;

public class Ex5_ArrayAgeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]memberAges= {12,59,43,22,6,11,29,32,49,51,18,27,16,18,55,24,3,1,5,9};
		int []ageCount=new int[6];
		/*
		 * 연령별 인원수를 구해서 출력하시오
		 * 
		 * 10세미만:3명
		 * 10대:*명
		 * 20대:*명
		 * ...
		 * 50대:*명
		 */
		for(int i=0;i<memberAges.length;i++) 
		{
			ageCount[memberAges[i]/10]++;//int 나누기 int 는 형변환 필요없이 .뒷자리 절삭돼서 int로 

		}

		for(int i=0;i<ageCount.length;i++) {
			if(i==0)
				System.out.println("10세 미만:"+ageCount[i]+"명");
			else
				System.out.println(i+"0대:"+ageCount[i]+"명");
		}

	}

}