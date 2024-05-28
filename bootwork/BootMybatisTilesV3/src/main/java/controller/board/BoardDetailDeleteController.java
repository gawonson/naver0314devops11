package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ReBoardDto;
import data.service.MemberService;
import data.service.ReBoardService;
@RequestMapping("/board")
@Controller
public class BoardDetailDeleteController {
	@Autowired
	private ReBoardService boardService;
	@Autowired
	private MemberService memberService;
	@GetMapping("/detail")
	public String detail(
			@RequestParam int num,
			@RequestParam int currentPage,
			Model model
			) {
		//조회수 증가
		boardService.updateReadcount(num);
		//num 에 해당하는 글 가져오기
		ReBoardDto dto=boardService.getData(num);
		//해당 아이디가 같고있는 프로핑 사진
		
		String profile_photo= memberService.detailMember2(dto.getMyid()).getPhoto();
		System.out.println(profile_photo);
		model.addAttribute("profile_photo",profile_photo);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("dto",dto);
		
		return "board/detailpage";
	}
	@GetMapping("/delete")
	public String deleteBoard(
			@RequestParam int num,
			@RequestParam int currentPage,
			Model model
			) {
		
		boardService.deleteBoare(num);
		
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("num",num);
		return "redirect:./list?num="+num+"&currentPage="+currentPage;
	}
}
