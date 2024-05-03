package data.dao;

import java.util.List;
import java.util.Vector;

import data.dto.moneyDto;
import db.common.MySqlConnect;

public class moneyDao {

	MySqlConnect db=new MySqlConnect();
	
	//생성 
	public void firstMoney(moneyDto dto) {
		
	}
	//추가
	public void addMoney(moneyDto dto) {
		
	}
	//전체 출력
	public List<moneyDto> getAllrecord(){
		List<moneyDto> list = new Vector<moneyDto>();
		
		return list;
	}
	//수정
	public void updateMoney(moneyDto dto) {
		
	}
	//상세보기
	public moneyDto getData(int num) {
		moneyDto dto=new moneyDto();
		return dto;
	}
	//
}
