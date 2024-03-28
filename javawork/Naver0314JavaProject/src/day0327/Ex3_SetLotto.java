package day0327;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex3_SetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Set<Integer> setLotto=new TreeSet<Integer>();
		while (true)
		{
			System.out.println("로또를 구매할 금액을 입력하세요.(종료 : 0)");
			int money =sc.nextInt();
			//0이면 종료
			if(money==0)
				break;
			if(money<1000)
			{
				System.out.println("금액이 부족합니다.");
				continue;
			}
			for(int i=0;i<money/1000;i++)
			{
				//6개의 중복되지 않은 로또숫자 구하기 (1~45)
				//기존 값 모두 삭제 후 다시구하기
				setLotto.clear();

				while (true)
				{
					int n=(int)(Math.random()*45)+1;
					setLotto.add(n);
					if(setLotto.size()==6)
						break;
				}
				//출력 
				System.out.println(i+1+"회차 번호 : "+setLotto);

			}
		}
	}

}