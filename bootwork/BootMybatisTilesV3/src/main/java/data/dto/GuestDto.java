package data.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("GuestDto")
@Builder
public class GuestDto {
	private int guestidx;
	private String writer;
	private String myid;
	private String gcontent;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm" , timezone="Asia/Seoul")
	private Timestamp writeday;
	//방명록 글에 업로드된 글 하나당 사진 리스트
	List<String> photos;
}
