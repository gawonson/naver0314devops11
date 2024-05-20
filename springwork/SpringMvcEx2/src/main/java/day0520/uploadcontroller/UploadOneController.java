package day0520.uploadcontroller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
//�޴����� ���ý� ������ �ڵ�
public class UploadOneController {
	@GetMapping("/uploadform1")
	public String upload1() {
		return "upload/uploadform1";
	}
	
	//������ ���� �������� ����Ǵ� �ڵ�
	@PostMapping("/upload1")
	public String uploadPhoto1(
			@RequestParam String title,
			@RequestParam ("upload") MultipartFile upload,
			//����� ������ �޾ƿö� ���°�
			HttpServletRequest request,
			Model model
			) 
	
	{
		//���� ������ ������ ������Ʈ���� �̹����� ���ε�� ��α��ϱ�
		String realFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realFolder);//�ַܼ� ��� �� Ž���⸦ ��� �̹����� Ȯ�����ּ���^^
		
		//���ε��� ���ϸ��� ���ϱ�
		//���� ������ �̸���� ���� Ȯ���� ���Ե�
		String filename=upload.getOriginalFilename();
		System.out.println(filename);
		//���ÿ� �������� ������ �����ؼ� ���ε��Ұ�� ���� ���ϸ��� ������ ������ �߻��Ѵ�.
		//�׷��� ���� ���ϸ����� ���ε� �غ���
		//uuid�� Ȯ���� ���� �ȵ�
		String fileName=UUID.randomUUID()+".jpg";
		
		//���� ��ο� �ش� ���ϸ����� ���ε��غ���
		try {
			upload.transferTo(new File(realFolder+"/"+fileName));
			//���ε�� ������ ���ٸ�  model�� ����
			model.addAttribute("title",title);
			model.addAttribute("photo",fileName);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload/resultphoto1";
	}
}
