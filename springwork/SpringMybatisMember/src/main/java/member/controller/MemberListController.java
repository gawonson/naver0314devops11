package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")//공통매핑
public class MemberListController {
	
	//@Autowired
	@NonNull
	private MemberService memberService;

	
	@GetMapping("/list")//그럼 공통매핑 포함하여 /member/list라고 됨
	public String list(Model model) 
	{
		
		int totalCount;//총 갯수
		List<MemberDto> list=memberService.getAllMembers();
		
		
		totalCount=memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "member/memberlist";
	}
	

}
