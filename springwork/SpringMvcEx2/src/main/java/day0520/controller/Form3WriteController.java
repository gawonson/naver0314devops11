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
				//dto 클래스 명이 너무 긴 경우
				//@ModelAttribute ("fdto") FoodDto dto
				
				/*폼태그에서 같은 이름을 자동으로 읽어온다
				 Model 에 foodDto 라는 이름으로 저장이된다*/)
			
	
	
	{		 
		return "form3/result3";
	}
}
