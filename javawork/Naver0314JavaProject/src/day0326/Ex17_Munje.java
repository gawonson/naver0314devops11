package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * score.txt 를 읽어서 총 갯수와 총점, 평균을 구하시오
 * 단,점수에 문자가 있는경우 갯수에서 제외하고 총 점에서도 제외하고 결과 출력출력이 되도록 하기(강제종료 x)
 * 
 * 갯수 :13개
 * 총점 : 990
 * 평균 : 78.99
 */

public class Ex17_Munje {
	//파일 불러오기
	static final String SCORE="d:/naver0314/score.txt";
	static public int count=0,sum=0;
	static public void readScore()

	{

		BufferedReader br=null;
		FileReader fr=null;

		try {
			fr=new FileReader(SCORE);
			br=new BufferedReader(fr);

			while(true)
			{ 
				String line=br.readLine();
				if(line==null)
					break;
				String a[] =line.split("\n");
				//				if(intline<0&&intline>100)
				//				{
				//					sum=+Integer.parseInt(line);
				//					count++;
				//				}
				//				else
				//					continue;

				for(int i=0;i<a.length;i++)
				{
					try{sum+=Integer.parseInt(a[i]);
					count++;}
					catch (NumberFormatException e){	
						System.out.println("안더함");

					}
				}
			}
	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("score 파일이 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readScore();
		System.out.println("갯수:"+count);
		System.out.println("총점:"+sum);
		System.out.println("평균:"+(double)sum/count);
	}
}
