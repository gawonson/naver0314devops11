package member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
@RequiredArgsConstructor
@Repository
public class MemberDao {
	
	//@Autowired
	//자동주입 mysql id와 password 등등..
	@NonNull
	private SqlSession session;
	
	// package이름.class 이름
	private String namespace="member.dao.MemberDao.";
	
	public int getTotalCount() {
		
		return session.selectOne(namespace+"memberTotalCount");
	}
	
	public int getSearchId(String searchid) {
		return session.selectOne(namespace+"selectIdCheck",searchid);
	}
	public void insertMember(MemberDto dto) {
		session.insert(namespace+"insertMember",dto);
	}
	public List<MemberDto> getAllMembers () {
		return session.selectList(namespace+"selectAllMembers");
	}
}
