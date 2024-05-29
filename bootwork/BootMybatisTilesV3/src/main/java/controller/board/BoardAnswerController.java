package controller.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.BoardAnswerDto;
import data.service.BoardAnswerService;
import data.service.MemberService;
@RequestMapping("/board")
@RestController//전부다 responsebody 붙인격 전부다 ajax이용한다는 뜻
public class BoardAnswerController {
	@Autowired
	private BoardAnswerService answerService;
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/ainsert")
	public void insertAnswer(@RequestParam int num,@RequestParam String content,HttpSession session)
	{
		//로그인한 아이디 얻기
		String myid=(String)session.getAttribute("loginid");
		//아이디에 해당하는 이름 얻기
		String writer=memberService.detailMember2(myid).getName();
		//dto에 필요한 데이터 넣기
		BoardAnswerDto dto=BoardAnswerDto.builder()
				.myid(myid)
				.writer(writer)
				.content(content)
				.num(num).build();
		
		//db insert
		answerService.insertAnswer(dto);
	};
	
	@GetMapping("/alist")
	public List<BoardAnswerDto> alist(@RequestParam int num)
	{
		return answerService.getAnswerData(num);
	}
	
	@GetMapping("/deleteanswer")
	public void deleteAnswer(@RequestParam int aidx)
	{
		answerService.deleteAnswer(aidx);
	}
		
	
};
