package day0404db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_munje{
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL ="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";

	public Ex3_munje() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("MySQL8 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL8 드라이버 오류:"+e.getMessage());
		}	
	}
	static public void showTitle()
	{
		System.out.println("=".repeat(40));
		System.out.println("부서\t인원수\t최고점수\t평균점수");
		System.out.println("=".repeat(40));
	}
	public void writeSawon() {
		//URL , user 명과 , 비번이 모두 맞으면 connection 을 얻는다
		Connection conn=null;//db연결
		Statement stmt=null;//얻을때
		ResultSet rs=null;//select 문일경우에만 필요한 클래스
		String sql= "select buseo, count(*) inwon,max(score) maxscore,ceiling(avg(score)) avgscore from sawon group by buseo";
		try {
			conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			System.out.println("mysql 서버에 연결 성공!");
			showTitle();
			stmt = conn.createStatement();// SQL 을 실행하기위한 statement 얻기
			rs=stmt.executeQuery(sql);//select 문일경우 무조건 executeQuery 문으로 실행
			while(rs.next()) //rs.next() 는 다음레코드로 이동을 하면서 true 를 반환, 그런데 이동할 데이터가 더이상 없으면 false 반환
			{

				String buseo=rs.getString("buseo");
				int inwon =rs.getInt("inwon");
				int maxscore=rs.getInt("maxscore");
				int avgscore=rs.getInt("avgscore");



				System.out.println(buseo+"\t"+inwon+"\t"+maxscore+"\t"+avgscore);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL,USERNAME,PASSWORD 확인:"+e.getMessage());
		}
		finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_munje ex3=new Ex3_munje();
		ex3.writeSawon();
	}
}