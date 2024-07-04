package mycar.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity//create table
@Table(name="mycar")//table name
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {

    @Id//primary key
    @GeneratedValue(strategy= GenerationType.IDENTITY)//auto increment
    private Long num;

    @Column(name = "carname",length = 30)//column name  / name이 변수명이랑 같을경우 생략가능
    private String carname;

    private int carprice;//column 명을 변수명이랑 같게 할 경우 생략 / int 라 길이도 필요없음

    @Column (length = 20)
    private String carcolor;//String은 기본 길이 있으나 주기

    @Column (length = 20)
    private String carguip;

    @Column(length = 100)
    private String carphoto;

    @CreationTimestamp//now()
    @Column(updatable = false)//수정시 컬럼 제외
    private Timestamp writeday;

    @Transient//테이블의 컬럼으로는 생성되지않고 객체에서만 사용가능한 멤버변수
    private int commentcount;//댓글 갯수

    @Transient
    private String message;//하고싶은 말


}
