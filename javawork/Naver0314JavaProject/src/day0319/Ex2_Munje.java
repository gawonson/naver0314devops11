package day0319;

public class Ex2_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1!=1
		//2!=2
		//3!6... 10까지 출력
		int sum=1;
		for (int i=1;i<=10;i++) {
			sum*=i;
			System.out.printf("%d != %d\n",i,sum);	
		}

	}
}


