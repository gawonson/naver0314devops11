package day0319;
public class Ex1_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 조건이 아닐때 밑으로 내려감
		//1-100사이의 소수를 모두 출력하고 몇개인지 갯수를 구하라
		int count=0;
		loop:
			for (int i=1;i<=100;i++) {
				for (int j=2;j<i;j++) {
					if (i%j==0) {
						continue loop;
					}
				}
				count++;
				System.out.printf("%3d ",i);
				if(count%5==0)
					System.out.println();
				
			}
		System.out.println();
		System.out.println("소수의 총 갯수 :"+count);
		
		
		
	}

}
