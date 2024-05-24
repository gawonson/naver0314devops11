package controller.member;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberUpdateController {

	@NonNull
	private MemberService memberService;

	@ResponseBody
	@PostMapping("/upload")
	public Map<String, String> uploadPhoto(@RequestParam("upload") MultipartFile upload,
			@RequestParam int num,
			HttpServletRequest request
			){
		//업로드될 경로
		String savePath=request.getSession().getServletContext().getRealPath("/save");
		//확장자 분리
		String ext=upload.getOriginalFilename().split("\\.")[1];

		//업로드할 파일명
		String photo=UUID.randomUUID()+"."+ext;

		//실제 업로드
		try {
			upload.transferTo(new File(savePath+"/"+photo));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		//db에서 photo수정
		memberService.updatePhoto(num, photo);
		Map<String, String> map=new HashMap<>();
			map.put("photoname", photo);
			return map;
	}
	
	@GetMapping("/updateform")
	public String update(@RequestParam int num,Model model) {
		
		MemberDto dto=memberService.detailMember(num);
		model.addAttribute("dto",dto);
		
		return "member/memberupdateform";
	}
	@PostMapping("/update")
	public String updateinfo(
			@ModelAttribute MemberDto dto
			)
	{
		memberService.updateinfo(dto);
		
		return "redirect:./list";
	}
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteMember( @RequestParam int num,@RequestParam String passwd) {
		
		Map<String, String> list=new HashMap<>();
		boolean b=memberService.isEqualPassCheck(num, passwd);
		
		if(b) {
			memberService.deleteMember(num);
		}
		list.put("status",b?"success":"fail");
		return list;
	}
	
	
	
}