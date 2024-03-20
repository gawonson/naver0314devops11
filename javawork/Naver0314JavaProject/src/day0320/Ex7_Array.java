package day0320;

public class Ex7_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 */
		int[]data= {12,9,5,-9,103,82,0,-66,56,4};
		int max,min;
		System.out.println(data.length);
		max=min=data[0];// 무조건 첫 데이터를  max min 으로 지정
		
		
		for (int i=1;i<data.length;i++) 
		{
			if(max<data[i]) 
				max=data[i];
			
			if(min>data[i])
				min=data[i];
			
		}
		System.out.println("최대값 :"+max);
		System.out.println("최소값 :"+min);
		
		int pcnt=0,mcnt=0,cnt=0;
		//배열의 양수의 갯수와 음수의 갯수를 구하여 출력
		
		for(int i=0;i<data.length;i++) {
			if (data[i]<0)
				mcnt++;
			if (data[i]>0)
				pcnt++;
			if (data[i]==0)
				cnt++;
		}
		System.out.println("양수의 갯수:"+pcnt);
		System.out.println("음수의 갯수:"+mcnt);
		System.out.println("0의 갯수:"+cnt);
		
		
		
	}

}
