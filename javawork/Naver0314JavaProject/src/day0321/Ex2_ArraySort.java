package day0321;

public class Ex2_ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두 값을 바꿀경우
		//		int a=10,b=20,temp;
		//		System.out.println("a="+a+",b="+b);
		//		//두 값을 서로 바꾸기
		//		temp=a;
		//		a=b;
		//		b=temp;
		//		System.out.println("a="+a+",b="+b);

		int []arr= {5,8,2,1,10};
		//selection sort
		for (int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++) {

				if(arr[i]>arr[j])//오름차순 정렬
			//if(arr[i]>arr[j])//내림차순 정렬
					
					
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}

		}
		//출력
		for(int a:arr)
		{

			System.out.print(a+"\t");
		}


	}

}
