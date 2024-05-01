package data.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.mysql.cj.xdevapi.Result;

import data.dto.SawonDto;

import db.common.MySqlConnect;

public class SawonDao {
	MySqlConnect db=new MySqlConnect();
	
	
	//추가
	public void insertSawon(SawonDto dto) {
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		String sql="""
				insert into mysawon (name,buseo,age,addr,photo,gender,birthday) values (?,?,?,?,?,?,?)
				""";
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체 출력
	public List<SawonDto> getAllSawons(){
		List<SawonDto> list = new Vector<SawonDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="""
				select * from mysawon order by name asc
				""";
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				
				SawonDto dto=new SawonDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				
				list.add(dto);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//한개반환
	public SawonDto getData(int num) {
		SawonDto dto=new SawonDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="""
				select * from mysawon where num=?
				""";
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	public void deleteSawon(int num) {
		String sql="""
				delete from mysawon where num=?
				""";

		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	public void updateSawon(SawonDto dto) {
		
		String sql="""
				update mysawon set name=?,buseo=?,age=?,addr=?,photo=?,gender=?,birthday=? where num=?
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			pstmt.setInt(8, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//성별 분석데이터 반환
	public List<Map<String, String>> getGenderAnalysis(){
		List<Map<String, String>> list=new Vector<Map<String,String>>();
		
		String sql="select gender,count(*) count, round(avg(age),1) age from mysawon group by gender";
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				Map<String, String> map=new HashMap<String, String>();
				String gender=rs.getString("gender");
				String count=rs.getString("count");
				String age=rs.getString("age");
				
				//map에 넣기
				map.put("gender", gender);
				map.put("count", count);
				map.put("age", age);
				
				//list에 추가
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
	}
	//부서별 분석데이터 반환
	public List<Map<String , String>> getBuseoAnalysis(){
		List<Map<String , String>> list=new Vector<Map<String, String>>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select buseo, count(*) count, round(avg(age),1) age from mysawon group by buseo";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String count=rs.getString("count");
				String age=rs.getString("age");
				String buseo=rs.getString("buseo");
				
				map.put("buseo", buseo);
				map.put("count", count);
				map.put("age", age);
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
				
				
		return list;
	}
}
