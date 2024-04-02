package myown;

public class p173ArrayCreateByExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1=new int[3];//배열 선언 arr1이라는 배열은 int(정수) 타입의 3개의 배열
		for (int i=0;i<3;i++) //arr1배열을 0번째부터 2번째까지 총 3번 출력
			System.out.print("arr1["+i+"]:"+arr1[i]+",");
		System.out.println();
		//배열의 각 순서에 해당하는 값 넣기
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		
		//새로 넣은 값 출력하기
		for(int i=0;i<3;i++) {
			System.out.print("arr1["+i+"]:"+arr1[i]+",");
			
		}
		System.out.println("\n");//줄넘김
		//배열 선언 arr2이라는 배열은 double(소수) 타입의 3개의 배열
		double[]arr2=new double[3];
		for (int i=0;i<3;i++)//arr2배열을 0번째부터 2번째까지 총 3번 출력
		{
			System.out.print("arr2["+i+"]:"+arr2[i]+",");//출력해보면 각배열의 초기값 0.0
			
		}
		System.out.println();
		//배열의 각 순서의 타입에 맞는 값 넣기
		arr2[0]=0.1;
		arr2[1]=0.2;
		arr2[2]=0.3;
		
		for(int i=0;i<3;i++)//arr2배열을 0번째부터 2번째까지 총 3번 출력
		{
			System.out.print("arr2["+i+"]:"+arr2[i]+",");
		}
		System.out.println("\n");
		
		
		String[]arr3=new String [3];//arr3이라는 String(문자열)타입의 배열 생성
		for(int i=0;i<3;i++) {//arr3배열을 0번째부터 2번째까지 총 3개 출력
			System.out.print("arr3["+i+"]:"+arr3[i]+",");//초기값 null
		}
		System.out.println();
		
		//arr3이라는 배열에 해당하는 값 넣기
		arr3[0]="1월";
		arr3[1]="2월";
		arr3[2]="3월";
		for (int i=0;i<3;i++)//arr3배열 출력
		{
			System.out.print("arr3["+i+"]:"+arr3[i]+",");
		}
	}

}
