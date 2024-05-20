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

//�޴����� �����Ҷ� ����Ǵ� �ڵ�
@Controller
public class UploadMultiController {
	@GetMapping("/uploadform2")
	public String upload2(
			
			
			) {
		return "upload/uploadform2";
	}
	
	//���� ���� ���� �� ���� ��� ���� 
	@PostMapping("/upload2")
	public String uploadResult
	(
			//1.���� �ޱ�
			@RequestParam String title,
			//2. upload �ޱ�(�������̱� ������ list �������� �ޱ�)
			@RequestParam ("upload") List<MultipartFile> upload,
			//3. http ����
			HttpServletRequest request,
			//4. �������ϱ⶧���� model ����
			Model model
			) 

	{
		//5. ���� �̸��� ���� vector ����
		List<String> filelist=new Vector<>();
		//6. ���� ���� ������ŭ for �������� �ڵ� ����
		for(int i=0;i<upload.size();i++) {
			
			//7. ���� �̸� �������� ����
			String filename=UUID.randomUUID()+".jpg";
			//8. ���� ��� �޾ƿ���
			String filepath=request.getSession().getServletContext().getRealPath("resources/upload");
			
			
			try {
				//9.�ش� ��ο� ���� ����
				upload.get(i).transferTo(new File(filepath+"/"+filename));
				
				//10. �޾ƿ� ���ϵ� �� ����� �̸����� ��� �� ������ vector�� �ֱ�
				filelist.add(filename);
				
				
				
				
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//11. ��¿� �ʿ��� �͵� ������
		model.addAttribute("filelist",filelist);
		model.addAttribute("title",title);
		model.addAttribute("len",upload.size());
		
		return "upload/resultphoto2";
	}
}
