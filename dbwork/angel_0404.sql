-- 자바 연동 연습용 시퀀스 및 테이블 생성
create sequence seq_test nocache;

create table person(
    pnum number(3) constraint pk_pnum primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

-- 5정도 데이터 주기
insert into person values (seq_test.nextval,'이상순','a',34,'2010-12-10');
insert into person values (seq_test.nextval,'강호동','o',27,'2012-12-10');
insert into person values (seq_test.nextval,'유재석','o',66,sysdate);
insert into person values (seq_test.nextval,'손미나','ab',19,'2018-12-10');
insert into person values (seq_test.nextval,'손지영','b',22,'2024-1-10');

commit;

select * from person;

select pnum, pname, upper(pblood) pblood, page, to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;