--시퀀스 생성
--기본 1부터 1씩 증가하는시퀀스는 생략하고 기본명령어만 주면됨
create sequence seq1 ;
--전체 시퀀스 조회
select * from seq;

--다음 시퀀스값 발생:nextval
select seq1.nextval from dual;--1씩 증가

--10부터 5씩 증가하는 시퀀스를 생성해보기, 캐쉬가 기본 20인데 없애보자
create SEQUENCE seq2 start with 10 increment by 5 nocache;

--seq2 값으로 발생시켜보자
select seq2.nextval from dual;

--1부터 3씩증아 , 캐쉬 0 , 맥스100
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 3 NOCACHE MAXVALUE 100;

--SEQ3 값 발생
SELECT SEQ3.NEXTVAL FROM DUAL;

--시퀀스 제거
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;

--최종 테이블에서 사용할 시퀀스 생성(1부터1씩증가(생략), CACHE 0)
CREATE SEQUENCE SEQ_TEST NOCACHE;

--연습용 테이블 생성
CREATE TABLE HELLO (
 IDX NUMBER(3) PRIMARY KEY, 
 IRUM VARCHAR2(20),
 AGE NUMBER(3)
);

--테이블 구조를 수저 : ALTER TABLE
--IRUM 의 길이를 20에서 30으로 수정해보자
ALTER TABLE HELLO MODIFY IRUM VARCHAR2(30);

--ADDR 이라는 컬럼을 추가해보자(문자열 길이는 100)
ALTER TABLE HELLO ADD ADDR VARCHAR2(100);

--AGE 라는 컬럼을 제거해보자
ALTER TABLE HELLO DROP COLUMN AGE;

-- 컬럼명 변경( ADDR -> ADDRESS)
ALTER TABLE HELLO RENAME COLUMN ADDR TO ADDRESS;

-- 컬럼 두개 추가
ALTER TABLE HELLO ADD BLOOD VARCHAR2 (3);
ALTER TABLE HELLO ADD AGE NUMBER(3);

--데이터를 추가해보기
INSERT INTO HELLO (IDX,IRUM) VALUES (seq_test.nextval,'lee');--에러발생, idx 는 pk이므로 반드시 값을 넣어야한다.
insert into hello (idx,blood,address) values (seq_test.nextval,'ab','서울역삼');
--컬럼명 생략시 테이블 컬럼 순서대로 모든값을 줘야한다

insert into hello values(seq_test.nextval,'이진','제주도애월읍','O',23);


--수정
--이름이 '이진'인 사람의 혈액형을 b형으로 변경해보자
update hello set blood ='b' where irum='이진';
--idex가 2번인 사람의 irum,age 를 수정해보자
update hello set irum='강호동',age=35 where idx=2;
update hello set address='서울강서', blood='ab', age=45 where idx=1;
update hello set irum='전지현', age=43 where idx=6;

--삭제
delete from hello where idx=1;
--age 가 30이상인 데이터는 모두 삭제
delete from hello where age>=30;

--테이블 제거
drop table hello;
--테이블 출려
select * from hello;
 ---------------------------------------------------------------------
 --새로운 테이블 생성 (각종 제약조건 추가해서 생성)
create table student (
    num number(3) constraint pk_num primary key ,
    stuname varchar2(20) constraint nn_name not null,
    score number(3) constraint nk_score check(score>=1 and score<=100),
    birthday date
);

--insert 로 데이터 추가하는데 각종 에러를 발생시켜보자
insert into student (num,stuname) values (1,'김미리');--성공
--ORA-01400: NULL을 ("ANGEL"."STUDENT"."NUM") 안에 삽입할 수 없습니다 (num은 not null이기때문에 필수 추가해야함)
insert into student (stuname, score) values ('이미자',45);--오류
--ORA-00001: 무결성 제약 조건(ANGEL.PK_NUM)에 위배됩니다(num 은 pk 이기때문에 not null+unique)
insert into student (num,stuname) values (1,'홍진주');--오류
--ORA-02290: 체크 제약조건(ANGEL.NK_SCORE)이 위배되었습니다( score 범위를 지정하여서 범위에서 벗어나는 값을 넣지 못함)
insert into student(num,stuname,score) values (2,'강호동',110);--오류

--오류 없는 정상데이터로 출력해보자
insert into student values (3,'이미자',89,sysdate);--날짜는 현재로
insert into student values (4,'김민종',100,'2010-12-20');
COMMIT;--COMMIT 을 일단 하면 ROLLBACK 이 안된다.
insert into student values (5,'손민아',56,'2019-05-10');
insert into student values(6,'강수지',98,sysdate);
insert into student values(7,'김진우',67,'2015-09-12');
insert into student values (8,'강호동',66,'2019-05-03');

COMMIT;
rollback;--마지막 commit 한 이휴의 DML작업에 대한 롤백(돌아가기)

--MUN이 5번인 데이터의 이름을 '손미라', SCORE을 80 수정
UPDATE STUDENT SET STUNAME='손미라' , SCORE=80 WHERE NUM=5;
--BIRTHDAY 의 월이 5인 사람의 점수를 일괄적으로 85로 수정
UPDATE STUDENT SET SCORE=85 WHERE TO_CHAR(BIRTHDAY,'mm')=05;

commit;

--num 이 7인 데이터 삭제
delete from student where num=7;
--롤백 후 데이터 확인
rollback;
--다시 삭제문 실행 
delete from student where num=7;
--커밋하기
commit;
--다시 롤백 후 데이터 확인 하기
rollback;--이미 커밋된 데이터는 취소되지 않는다.

--불필요한 제약조건을 제거하고싶다.
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--새로운 제약조건추가
alter table student add constraint uq_name unique(stuname) ;

-- 같은 이름의 데이터를 추가해보자
--ORA-00001: 무결성 제약 조건(ANGEL.UQ_NAME)에 위배됩니다(unique 제약조건)
insert into student (num,stuname) values (10,'강호동');--오류발생

select * from student;
--연습이 끝난 후 시퀀스랑 테이블은 삭제해주세요
drop sequence seq_test;
drop table student;
-------------------------------------------------------------------------

/*
join 연습용 테이블 2개 생성하기
테이블 #1:
            food - foodnum 숫자 (3)
                   foodname 문자열(20)
                   foodprice 숫자(7)
                   foodsize 문자열(20)
테이블 #2:
        booking -   bnum pk 숫자(3)
                    bname 문자열(20) nn
                    bhp 문자열 (20) uq
                    foodnum 숫자 (3) - fk(food 의 foodnum) 
                    bookingday date
                    
                    외부키로 연결된경우 booking 에 데이터가 추가된 이후 추가된 foodnum은 삭제불가
                    ex) 게시판의 댓글은 외부키로 연결되어있는대 댓글이 달린경우 해당글을 삭제할수 없는 게시판들이 있다.
                    그런데 만약 food를 삭제하면 그 메뉴를 추가한 고객의 데이터도 자동으로 삭제시키고자 할 경우 booking의 외부키를 설정할때 on delete cascade를 주면된다.
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20) ,
    foodprice number(7),
    foodsize varchar2(20)
);
--메뉴 등록하기
insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱배기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱배기');
insert into food values (300,'칠리새우',15000,'소');
insert into food values (301,'칠리새우',30000,'대');
insert into food values (400,'해물짬뽕',11000,'보통');
commit;
select * from food;

--시퀀스 추가
create sequence seq_food nocache;

--booking 테이블 생성
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date
 
);
alter table booking add constraint fk_foodnum foreign key(foodnum) references food(foodnum);

--예약테이블에 데이터를 추가해보자
select * from booking;

insert into booking values(seq_food.nextval, '홍범자','010-2222-3333',101,sysdate);
insert into booking values(seq_food.nextval, '이영자','010-3851-8889',201,sysdate+7);
insert into booking values(seq_food.nextval, '박지민','010-1234-5923',100,sysdate+7);
insert into booking values(seq_food.nextval, '손미나','010-2204-1546',400,sysdate+20);
insert into booking values(seq_food.nextval, '이호리','010-8804-6491',300,sysdate+13);
insert into booking values(seq_food.nextval, '유재석','010-1234-8889',200,sysdate+1);

commit;

--join 으로 두테이블을 조인해서 출력하시요
--bnum,bname,bhp,foodnum,foodname,foodprice,foodsize,bookingday(yyyy-mm0dd)

select 
    bnum,bname,bhp,b.foodnum,foodname,foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday
    from food f,booking b
    where f.foodnum=b.foodnum;

--이무도 예약하지 않은 food 음식이 무엇이 있을까?
select
    bnum,f.foodnum, foodname,foodprice,foodsize
    from food f,booking b
    where f.foodnum=b.foodnum(+) and bnum is null;--301메뉴는 아무도 주문 안함

--food 의 200번 메뉴는 삭제가 될까요?
--ORA-02292: 무결성 제약조건(ANGEL.FK_FOODNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다(100번 메뉴를 주문한 고객이 있으므로 삭제할수 없음)
delete from food where foodnum=200;--오류
--food 의 301번 메뉴는 삭제가 될까요?
delete from food where foodnum=301;--됨 자식테이블에 레코드가 없기때문에 삭제가능

--부모테이블인 food를 삭제해보자
--ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다(자식테이블을 먼저 삭제후 부모테이블을 삭제해야만한다.
drop table food;--오류발생

--연습이 끝난 후 두 테이블을 제거하세요
drop table booking;--자식테이블 먼저 제거
drop table food;--자식테이블 제거 후 부모테이블 제거
drop sequence seq_food;
-----------------------------------------------------------------------------
--on delete cascade 예제
--이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록
--외부키를 설정해보자
--시퀀스 생성
create sequence seq_shop;
--shop,cart
create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
--외부키 설정시 on delete cascade 를 붙이면 부모테이블 삭제시 자식테이블에 추가된 데이터도 같이 삭제됨
create table cart(
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5개의 상품을 등록해보자
insert into shop values (seq_shop.nextval,'블라우스',12000);
insert into shop values (seq_shop.nextval,'조끼',19000);
insert into shop values (seq_shop.nextval,'청바지',25000);
insert into shop values (seq_shop.nextval,'체크코트',99000);
insert into shop values (seq_shop.nextval,'티셔츠',11000);
commit;
select *from shop;

--cart 에 원하는 상품을 담아보자
insert into cart values(seq_shop.nextval,2,3,sysdate);

insert into cart values(seq_shop.nextval,1,2,sysdate);
insert into cart values(seq_shop.nextval,5,1,sysdate);
commit;
select *from cart;

--조인으로 조회하기
select cart_no, s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from cart c , shop s
where s.sang_no = c.sang_no;

--아무도 카트에 담지 않은 상품은?
select cart_no,s.sang_no, sang_name,sang_price
from cart c, shop s
where s.sang_no =c.sang_no(+) and cart_no is null;

--on delete cascade 를 한 경우 카트에 추가된 상품도 삭제 가능하다.
--2번 조끼 상품을 삭제해보자
delete from shop where sang_no=2;

--카트 를 확인해보면 카트에 있던 2번 상품도 사라진것을 확인할수 있다.
select cart_no, s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from cart c , shop s
where s.sang_no = c.sang_no;

-- 테이블 제거는 역시 서브테이블부터 삭제
drop table cart;
drop table shop;
drop sequence seq_shop;
----------------------------------------------------------------------------


















