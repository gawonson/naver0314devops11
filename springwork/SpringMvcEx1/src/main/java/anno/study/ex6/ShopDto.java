package anno.study.ex6;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor//전체가 포함된 생성자
@NoArgsConstructor//빈 생성자 



public class ShopDto {

	private String sang;

	private int su;

	private int dan;
}
