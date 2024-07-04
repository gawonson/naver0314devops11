package mycar.repository;

import jakarta.transaction.Transactional;
import mycar.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//기본적인 JSP interface 기본 crud
public interface MyCarDaoInter extends JpaRepository<MycarDto,Long> {

    //사진을 선택하지 않았을경우는 사진과 구입날짜는 빼고 수정하는것
    //@Query : repository 에 원하는 쿼리를 작성하게 해주는 어노테이션
    //value 속성 : 쿼리 작성부

    @Query(value = """
        update mycar set carname=:carname, carprice=:carprice, carcolor=:carcolor where num=:num
    """,nativeQuery = true)  //nativeQuery : JPA 에서 지정한 규칙을 모두 무시할 수 있는 속성
    @Modifying//@Modifying 은 insert, update, delete 뿐만이 아니라 DDL 구문을 사용할때도 표기를 해줘야한다
    @Transactional//@Transactional은 update, delete 를 할때 표기를 해줘야 정상 실행이 됩니다.
    public void updateMycarNoPhoto(@Param("num") Long num,
                                   @Param("carname") String carname,
                                   @Param("carprice") int carprice,
                                   @Param("carcolor") String carcolor);

    //파라미터를 dto로 받은경우
    @Query(value = """
        update mycar set carname=:#{#dto.carname},carprice=:#{#carprice}, carcolor=:#{#carcolor} where num=:#{#num}
    """,nativeQuery = true)  //nativeQuery : JPA 에서 지정한 규칙을 모두 무시할 수 있는 속성
    @Modifying//@Modifying 은 insert, update, delete 뿐만이 아니라 DDL 구문을 사용할때도 표기를 해줘야한다
    @Transactional//@Transactional은 update, delete 를 할때 표기를 해줘야 정상 실행이 됩니다.
    public void updateMycarNoPhoto(@Param("dto") MycarDto dto);
}
