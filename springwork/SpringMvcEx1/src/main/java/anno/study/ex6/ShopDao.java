package anno.study.ex6;

import org.springframework.stereotype.Component;


import lombok.NonNull;



@Component

public class ShopDao {

	public void insert(ShopDto dto) 
	{
		System.out.println("������ �߰�");
		System.out.println(dto.toString());
	}
	@NonNull
	public void delete(String sang) 
	{
		System.out.println(sang+"��ǰ�� �����Ͻðڽ��ϱ�?");
	}
	@NonNull
	public void update(ShopDto dto) 
	{
		System.out.println("������ ����");
		System.out.println(dto);
	}
	
	public void selectAll() 
	{
		System.out.println("��ü��ǰ�� ����մϴ�.");
	}
}
