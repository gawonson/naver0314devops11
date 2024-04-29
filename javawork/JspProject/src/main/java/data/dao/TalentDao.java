package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.ShopDto;
import data.dto.TalentDto;
import db.common.MySqlConnect;

public class TalentDao {
	
	MySqlConnect connect=new MySqlConnect();
	
	public void inserttalent(TalentDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into talent(tname,tage,tphoto,theight,thome,tfan)
				values(?,?,?,?,?,?)
				""";
		
		conn=connect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getTname());
			pstmt.setInt(2, dto.getTage());
			pstmt.setString(3, dto.getTphoto());
			pstmt.setInt(4, dto.getTheight());
			pstmt.setString(5, dto.getThome());
			pstmt.setString(6, dto.getTfan());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
	}
	
	
	public List<TalentDto> getTalentDatas(){
		
		List<TalentDto> list=new Vector<TalentDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="""
				select * from talent order by talentidx desc
				""";
		
		conn=connect.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				TalentDto dto=new TalentDto();
				
				dto.setTalentidx(rs.getInt("talentidx"));
				dto.setTname(rs.getString("sname"));
				dto.setTage(rs.getInt("tage"));
				dto.setTphoto(rs.getString("tphoto"));
				dto.setTheight(rs.getInt("theight"));
				dto.setThome(rs.getString("thome"));
				dto.setTfan(rs.getString("tfan"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}

}
