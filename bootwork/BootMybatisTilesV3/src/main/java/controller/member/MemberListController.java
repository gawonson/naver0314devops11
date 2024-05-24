package controller.member;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.MemberDto;
import data.service.MemberService;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MemberListController {
	@NonNull
	private MemberService memberService;
	@GetMapping("/member/list")
	public String memberList(Model model) {
		int totalCount=memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		List<MemberDto>list = memberService.getAllMembers();
		model.addAttribute("list",list);
		return "member/memberlist";
	}
	
	@GetMapping("/member/detail")
	public String memberDetail(
			Model model,
			@RequestParam int num
			) 
	{
		MemberDto dto=memberService.detailMember(num);
		model.addAttribute("dto",dto);
		
		return "member/memberdetail";
	}
	

}
