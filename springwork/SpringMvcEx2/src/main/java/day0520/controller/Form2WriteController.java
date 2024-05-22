package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form2WriteController {

	@PostMapping("/read2")
	public String read2
	(
			//�� �±��� name�� ���� ������ �о�ð�� @RequestParam���� ����
			String name,
			String addr,
			int age,
			Model model
			) 
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("addr",addr);

		return "form2/result2";
	}
}