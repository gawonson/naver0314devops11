package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import day0520.dto.FoodDto;

@Controller
public class Form3WriteController {
	@PostMapping("/read3")
	public String read3(
			
				@ModelAttribute FoodDto dto
				//dto Ŭ���� ���� �ʹ� �� ���
				//@ModelAttribute ("fdto") FoodDto dto
				
				/*���±׿��� ���� �̸��� �ڵ����� �о�´�
				 Model �� foodDto ��� �̸����� �����̵ȴ�*/)
			
	
	
	{		 
		return "form3/result3";
	}
}
