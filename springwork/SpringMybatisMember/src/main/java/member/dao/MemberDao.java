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
	//�ڵ����� mysql id�� password ���..
	@NonNull
	private SqlSession session;
	
	// package�̸�.class �̸�
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
