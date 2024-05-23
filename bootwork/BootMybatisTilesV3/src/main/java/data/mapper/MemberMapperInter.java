package data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapperInter {
	@Select("select count(*) from memberdb")
	public int getTotalCount();//interface이기때문에 body없음
}
