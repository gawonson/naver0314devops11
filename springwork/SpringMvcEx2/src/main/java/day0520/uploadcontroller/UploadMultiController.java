package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//메뉴에서 선택할때 실행되는 코드
@Controller
public class UploadMultiController {
	@GetMapping("/uploadform2")
	public String upload2(
			
			
			) {
		return "upload/uploadform2";
	}
	
	//선택 파일 저장 및 파일 경로 설정 
	@PostMapping("/upload2")
	public String uploadResult
	(
			//1.제목 받기
			@RequestParam String title,
			//2. upload 받기(여러개이기 때문에 list 형식으로 받기)
			@RequestParam ("upload") List<MultipartFile> upload,
			//3. http 선언
			HttpServletRequest request,
			//4. 보내야하기때문에 model 선언
			Model model
			) 

	{
		//5. 파일 이름들 넣을 vector 선언
		List<String> filelist=new Vector<>();
		//6. 받은 파일 갯수만큼 for 문돌려서 코드 적용
		for(int i=0;i<upload.size();i++) {
			
			//7. 파일 이름 랜덤으로 생성
			String filename=UUID.randomUUID()+".jpg";
			//8. 파일 경로 받아오기
			String filepath=request.getSession().getServletContext().getRealPath("resources/upload");
			
			
			try {
				//9.해당 경로에 파일 저장
				upload.get(i).transferTo(new File(filepath+"/"+filename));
				
				//10. 받아온 파일들 새 경로으 이름으로 모두 다 생성한 vector에 넣기
				filelist.add(filename);
				
				
				
				
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//11. 출력에 필요한 것들 보내기
		model.addAttribute("filelist",filelist);
		model.addAttribute("title",title);
		model.addAttribute("len",upload.size());
		
		return "upload/resultphoto2";
	}
}
