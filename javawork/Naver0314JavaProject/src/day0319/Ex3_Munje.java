package day0319;

public class Ex3_Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(자릿수)xy+yx=121나오는 xy모두 구하기 단 x,y는 한자리수 
		for (int i=1;i<=9;i++) {
			for (int j =1;j<=9;j++) {
				int susik= (i*10+j)+(j*10+i);
				if(susik==121)
					System.out.printf("%d%d+%d%d=121\n",i,j,j,i);
			}
		}
	}
}
