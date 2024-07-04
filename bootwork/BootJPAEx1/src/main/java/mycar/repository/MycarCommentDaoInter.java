package mycar.repository;

import mycar.data.MyCarCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MycarCommentDaoInter extends JpaRepository<MyCarCommentDto,Integer> {


    //num에 해당하는 모든 댓글 반환 최신글 맨 위에
    @Query(value = "select * from mycar_comment where num=:num order by idx desc ",nativeQuery = true)
    public List<MyCarCommentDto> getMycarCommentList(long num);

    //
}
