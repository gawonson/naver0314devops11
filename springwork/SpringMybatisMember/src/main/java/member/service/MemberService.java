package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;

@Service
@AllArgsConstructor//이걸 쓸 경우 다른 변수가 추가되면 안됨 추가될경우 autowired로 해야함.
public class MemberService {

	//@Autowired
	private MemberDao memberDao;
	
	public int getTotalCount() 
	{
		return memberDao.getTotalCount();
	}
	
	public int getSearchId(String searchid) {
		return memberDao.getSearchId(searchid);
	}
	public void insertMember(MemberDto dto) {
		memberDao.insertMember(dto);
	}
	public List<MemberDto> getAllMembers () {
		return memberDao.getAllMembers();
	}
}
