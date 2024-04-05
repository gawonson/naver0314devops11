package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex1_ShopCartJoin {static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
static final String MYSQL_URL ="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
static final String USERNAME="root";
static final String PASSWORD="1234";

public Ex1_ShopCartJoin() {
	try {
		Class.forName(MYSQL_DRIVER);
		System.out.println("MySQL8 드라이버 성공!");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("MySQL8 드라이버 오류:"+e.getMessage());
	}	
}
public void writeCartJoin() {
	Connection conn=null;
	PreparedStatement psmt=null;
	ResultSet rs=null;

//	String sql="""
//			select 
//			cartnum, username , sangpum, price, color, date_format(guipday,'%Y-%m-%d %HH24:%i') guipday
//			  from shop,cart
//			  where shop.shopnum=cart.shopnum;
//
//					""";
	String sql="""
			select 
	cartnum, username , sangpum, price, color, date_format(guipday,'%Y-%m-%d %HH24:%i') guipday
    from shop
    inner join cart
   on shop.shopnum=cart.shopnum

			""";
	
	
	try {
		conn=DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
		psmt=conn.prepareStatement(sql);
		rs=psmt.executeQuery();
		
		
		System.out.println("\t** 나의 장바구니 **\t");

		System.out.println("시퀀스\t이름\t상품명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
		
		while(rs.next()) {
			
			int con=rs.getInt("cartnum");
			String s=rs.getString("sangpum");
			String u=rs.getString("username");
			int p=rs.getInt("price");
			String c=rs.getString("color");
			String g=rs.getString("guipday");
			System.out.println(con+"\t"+u+"\t"+s+"\t"+p+"\t"+c+"\t"+g);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
			psmt.close();
			conn.close();
		} catch (SQLException|NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Ex1_ShopCartJoin ex1=new Ex1_ShopCartJoin();
	ex1.writeCartJoin();
}

}
