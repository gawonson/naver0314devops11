package com.bitcamp.study;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.dto.ShopDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		ShopDto dto1=new ShopDto();
		dto1.setSang("머리띠");
		dto1.setPhoto("30.jpg");
		dto1.setPrice(13000);
		dto1.setSu(3);
		
		ShopDto dto2=new ShopDto("머리끈","26.jpg",9000,5);
		model.addAttribute("dto1",dto1);
		model.addAttribute("dto2",dto2);
		
		System.out.println(dto1.toString());
		System.out.println(dto2);
		
		model.addAttribute("msg","Hello SpringFramework!!!");
		model.addAttribute("today",new Date());
		return "home";//포워드
	}*/
	
//	@RequestMapping 써도 되는데 get 이나 post 방식에 따라 @getmapping , @postmapping 이 스프링 버전 5부터 추가됨
	@GetMapping("/")
	public String hello() {
		return "start";
	}
	//Model에 데이터를 저장하고 포워드 파일명을 리턴하는 두가지 방법
	
	@GetMapping("/board/list")//board/list.do 도 이게 호출됨
	//하지만 @GetMapping("/board/list.do")라고 하면 정확하게 그 주소만 됨
	public String hello2(Model model) {
		model.addAttribute("msg","안녕하세요 반가원^^");
		return "result1";
	}
	
	@GetMapping("/guest/list")
	public ModelAndView hello2() {
		ModelAndView mview=new ModelAndView();
		mview.addObject("today",new Date());
		mview.setViewName("result2");
		return mview;
	}
	
}
