package myown;

public class P182MultimensionalArrayByNewExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] mathScore=new int [2][3];//수학점수를 정수 [2][3]배열로 생성  그림

		for(int i=0;i<mathScore.length;i++) { // i를 0부터1까지 반복
			for(int k=0;k<mathScore[i].length;k++) {//K를 0부터 2까지 반복

				System.out.println("mathScore["+i+"]["+k+"]:"+mathScore[i][k]);//배열에 해당하는 값 출력
			}
		}
		System.out.println();

		//배열의 자리에 해당하는 점수 넣기
		mathScore[0][0]=80;
		mathScore[0][1]=83;
		mathScore[0][2]=85;
		mathScore[1][0]=86;
		mathScore[1][1]=90;
		mathScore[1][2]=92;

		int totalStudent=0;
		int totalMathSum=0;
		for(int i=0;i<mathScore.length;i++) {//학생수 총합 첫번째 반복에서 mathScore0을 가진 3,  mathScore1을 가진 3 더해서 학생수는 6;
			totalStudent+=mathScore[i].length;
			for(int k=0;k<mathScore[i].length;k++) {//각 배열에 해당하는 값 모두 더해서 totalMathSum
				totalMathSum+=mathScore[i][k];
			}
		}

		double totalMathAvg=(double)totalMathSum/totalStudent;// int 형이었던 모든 변수를 double(소수)형태로 나타내기위해 형변환 int/double=double
		System.out.println("전체 학생의 수학 평균 점수:"+totalMathAvg);
		System.out.println();

		int[][]englishScores=new int[2][];//그림
		englishScores[0]=new int [2];
		englishScores[1]=new int[3];

		for(int i=0;i<englishScores.length;i++) {	//배열 출력 i=2, k=3
			for(int k=0;k<englishScores[i].length;k++) {
				System.out.println("englishScores["+i+"]["+k+"]:"+englishScores[i][k]);
			}
		}
		System.out.println();

		englishScores[0][0]=90;
		englishScores[0][1]=91;
		englishScores[1][0]=92;
		englishScores[1][1]=93;
		englishScores[1][2]=94;
		
		totalStudent=0;	
		int totalEnglishSum=0;	
		for(int i=0;i<englishScores.length;i++)
		{
			totalStudent+=englishScores[i].length;
			for(int k=0;k<englishScores[i].length;k++)
			{
				totalEnglishSum+=englishScores[i][k];
			}
		}
		double totalEnglishAvg=(double)totalEnglishSum/totalStudent;
		System.out.println("전체 학생의 영어 평균 점수:"+totalEnglishAvg);
	}

}
