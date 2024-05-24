package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
public class MemberService {
	@Autowired
	private MemberMapperInter memInter;
	
	public int getTotalCount() 
	{
		return memInter.getTotalCount();
	}
	public int getIdCheckCount(String searchid) {
		
		return memInter.getIdCheckCount(searchid);
	};
	public void insertMember(MemberDto dto) {
		memInter.insertMember(dto);
	};
	public List<MemberDto> getAllMembers(){
		return memInter.getAllMembers();
	};
	public MemberDto detailMember(int num) {
		
		return memInter.detailMember(num);
	}
	public void updatePhoto(int num, String photo) {
		Map<String, Object> map=new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		memInter.updatePhoto(map);
	};
	public void updateinfo(MemberDto dto) {
		memInter.updateForm(dto);
	}
	public boolean isEqualPassCheck(int num,String passwd)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("passwd", passwd);
		
		memInter.isEqualId(map);
		
		return memInter.isEqualId(map);
	}
	public void deleteMember(int num) {
		memInter.deleteMember(num);
	}
	
}
