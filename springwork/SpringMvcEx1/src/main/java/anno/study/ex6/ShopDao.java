package anno.study.ex6;

import org.springframework.stereotype.Component;


import lombok.NonNull;



@Component

public class ShopDao {

	public void insert(ShopDto dto) 
	{
		System.out.println("데이터 추가");
		System.out.println(dto.toString());
	}
	@NonNull
	public void delete(String sang) 
	{
		System.out.println(sang+"상품을 삭제하시겠습니까?");
	}
	@NonNull
	public void update(ShopDto dto) 
	{
		System.out.println("데이터 수정");
		System.out.println(dto);
	}
	
	public void selectAll() 
	{
		System.out.println("전체상품을 출력합니다.");
	}
}
