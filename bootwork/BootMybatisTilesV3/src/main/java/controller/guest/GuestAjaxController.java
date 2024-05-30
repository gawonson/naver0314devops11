package controller.guest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.GuestDto;
import data.dto.GuestPhotoDto;
import data.service.GuestService;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;
@RequiredArgsConstructor
@RestController
@RequestMapping("/guest")
public class GuestAjaxController {
	@NonNull
	private GuestService guestService;
	@NonNull
	private MemberService memberService;
	@NonNull
	private NcpObjectStorageService storageService;
	
	private String bucketName="bitcamp-bucket-56";
	private String folerName="guestphoto";
	
	@PostMapping("/addguest")
	public void guestInsert(
			@RequestParam String gcontent,
			@RequestParam(value="upload",required=false) List<MultipartFile> upload,
			HttpSession session) 
	{
		//session 으로부터 로그인 한 아이디를 얻는다
		String myid=(String)session.getAttribute("loginid");
		String writer=memberService.detailMember2(myid).getName();
		//dto에 넣기
		GuestDto dto=GuestDto.builder()
				.writer(writer)
				.myid(myid)
				.gcontent(gcontent)
				.build();
		//db에 일단 작성자, 아이디 , 내용 저장
		guestService.insertGuest(dto);//이때 guestidx로 방금 추가된 시퀀스 값이 들어온다.
		int guestidx=dto.getGuestidx();
		//파일을 클라우드 스토리지에 업로드
		//파일 선택 안했을때
		//파일에서 직접 호출하는경우
		/*
		 * if(upload.get(0).getOriginalFilename().equals("")) { return; }
		 */
		//등록버튼 클릭시 파일도 저장
		//파일을 안올리고 저장버튼 눌렀을경우
		if(upload==null)
			return;
		
		
		//파일 선택했을때
		for(MultipartFile mfile:upload) {
			//스토리지에 저장 후 파일명 얻기
			String photoname=storageService.uploadFile(bucketName, folerName, mfile);
			
			//db에 insett
		GuestPhotoDto pdto=new GuestPhotoDto();
		pdto.setGuestidx(guestidx);
		pdto.setPhotoname(photoname);
		//db에 인서트 사진
		 guestService.insertPhoto(pdto);
		}
	}
	@GetMapping("/datas")
	public List<GuestDto> guestList(){
		//사진을 제외한 방명록 데이터 가져오기
		List<GuestDto> glist=guestService.getAllGuest();
		//각 방명록 글에 첨부된 사진명 photos에 넣기
		for(GuestDto dto:glist) {
			
			dto.setPhotos(guestService.getGuestPhoto(dto.getGuestidx()));
		}
		
		return glist; 
	}
}
