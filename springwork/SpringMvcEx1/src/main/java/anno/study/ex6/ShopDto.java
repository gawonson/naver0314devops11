package anno.study.ex6;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor//��ü�� ���Ե� ������
@NoArgsConstructor//�� ������ 



public class ShopDto {

	private String sang;

	private int su;

	private int dan;
}
