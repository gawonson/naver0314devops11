package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex17_MunjeAlone {
	//파일 불러오기
	static final String score2="d:/naver0314/00.txt";
	//파일 읽기
	static public int sum=0, count=0;
	static public void readscore2() throws IOException {
		//io 함수 null의 이유는 exception 때문에
		BufferedReader br=null;
		FileReader fr=null;

	//filereader : 파일 읽어오기
		fr=new FileReader(score2);
		//엔터 경계로 데이터 읽어오기 (String 밖에 인식 못함)
		br=new BufferedReader(fr);

		while (true) {
			String lines=br.readLine();
			//한줄씩 파일 읽고 저장하기
			if (lines!=null)
			{
				try {
					sum+=Integer.parseInt(lines);
					count++;}
				catch (NumberFormatException e){

				}
			}
			else 
				break;
		}
	}
	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		try {
			readscore2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {

		}
		catch(NumberFormatException e) {

		}
		
		
		System.out.println("갯수:"+count);
		System.out.println("총점:"+sum);
		System.out.println("평균:"+(double)sum/count);
	}

}
