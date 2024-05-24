package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import data.dto.MemberDto;


@Mapper
public interface MemberMapperInter {
	@Select("select count(*) from memberdb")
	public int getTotalCount();//interface이기때문에 body없음
	
	@Select("select count(*) from memberdb where myid=#{searchid}")
	public int getIdCheckCount(String searchid);
	
	@Insert("""
			insert into memberdb(name,myid,passwd,addr,hp,email,photo,birthday,gaipday) values(#{name},#{myid},#{passwd},#{addr},#{hp},#{email},#{photo},#{birthday},now())
			""")
	public void insertMember(MemberDto dto);
	@Select("select * from memberdb order by num asc")
	public List<MemberDto> getAllMembers();
	
	@Select("select * from memberdb where num=#{num}")
	public MemberDto detailMember(int num);
	
	@Update("update memberdb set photo=#{photo} where num=#{num}")
	public void updatePhoto(Map<String, Object> map);
	
	@Update("update memberdb set name=#{name}, hp=#{hp}, email=#{email}, addr=#{addr}, birthday=#{birthday} where num=#{num}")
	public void updateForm(MemberDto dto);
	
	@Delete("delete from memberdb where num=#{num}")
	public void deleteMember(int num);
	
	@Select("select count(*) from memberdb where passwd=#{passwd}")
	public boolean isEqualId(Map<String, Object> check);
	
}
