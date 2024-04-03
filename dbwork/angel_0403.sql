--������ ����
--�⺻ 1���� 1�� �����ϴ½������� �����ϰ� �⺻��ɾ �ָ��
create sequence seq1 ;
--��ü ������ ��ȸ
select * from seq;

--���� �������� �߻�:nextval
select seq1.nextval from dual;--1�� ����

--10���� 5�� �����ϴ� �������� �����غ���, ĳ���� �⺻ 20�ε� ���ֺ���
create SEQUENCE seq2 start with 10 increment by 5 nocache;

--seq2 ������ �߻����Ѻ���
select seq2.nextval from dual;

--1���� 3������ , ĳ�� 0 , �ƽ�100
CREATE SEQUENCE SEQ3 START WITH 1 INCREMENT BY 3 NOCACHE MAXVALUE 100;

--SEQ3 �� �߻�
SELECT SEQ3.NEXTVAL FROM DUAL;

--������ ����
DROP SEQUENCE SEQ1;
DROP SEQUENCE SEQ2;
DROP SEQUENCE SEQ3;

--���� ���̺��� ����� ������ ����(1����1������(����), CACHE 0)
CREATE SEQUENCE SEQ_TEST NOCACHE;

--������ ���̺� ����
CREATE TABLE HELLO (
 IDX NUMBER(3) PRIMARY KEY, 
 IRUM VARCHAR2(20),
 AGE NUMBER(3)
);

--���̺� ������ ���� : ALTER TABLE
--IRUM �� ���̸� 20���� 30���� �����غ���
ALTER TABLE HELLO MODIFY IRUM VARCHAR2(30);

--ADDR �̶�� �÷��� �߰��غ���(���ڿ� ���̴� 100)
ALTER TABLE HELLO ADD ADDR VARCHAR2(100);

--AGE ��� �÷��� �����غ���
ALTER TABLE HELLO DROP COLUMN AGE;

-- �÷��� ����( ADDR -> ADDRESS)
ALTER TABLE HELLO RENAME COLUMN ADDR TO ADDRESS;

-- �÷� �ΰ� �߰�
ALTER TABLE HELLO ADD BLOOD VARCHAR2 (3);
ALTER TABLE HELLO ADD AGE NUMBER(3);

--�����͸� �߰��غ���
INSERT INTO HELLO (IDX,IRUM) VALUES (seq_test.nextval,'lee');--�����߻�, idx �� pk�̹Ƿ� �ݵ�� ���� �־���Ѵ�.
insert into hello (idx,blood,address) values (seq_test.nextval,'ab','���￪��');
--�÷��� ������ ���̺� �÷� ������� ��簪�� ����Ѵ�

insert into hello values(seq_test.nextval,'����','���ֵ��ֿ���','O',23);


--����
--�̸��� '����'�� ����� �������� b������ �����غ���
update hello set blood ='b' where irum='����';
--idex�� 2���� ����� irum,age �� �����غ���
update hello set irum='��ȣ��',age=35 where idx=2;
update hello set address='���ﰭ��', blood='ab', age=45 where idx=1;
update hello set irum='������', age=43 where idx=6;

--����
delete from hello where idx=1;
--age �� 30�̻��� �����ʹ� ��� ����
delete from hello where age>=30;

--���̺� ����
drop table hello;
--���̺� ���
select * from hello;
 ---------------------------------------------------------------------
 --���ο� ���̺� ���� (���� �������� �߰��ؼ� ����)
create table student (
    num number(3) constraint pk_num primary key ,
    stuname varchar2(20) constraint nn_name not null,
    score number(3) constraint nk_score check(score>=1 and score<=100),
    birthday date
);

--insert �� ������ �߰��ϴµ� ���� ������ �߻����Ѻ���
insert into student (num,stuname) values (1,'��̸�');--����
--ORA-01400: NULL�� ("ANGEL"."STUDENT"."NUM") �ȿ� ������ �� �����ϴ� (num�� not null�̱⶧���� �ʼ� �߰��ؾ���)
insert into student (stuname, score) values ('�̹���',45);--����
--ORA-00001: ���Ἲ ���� ����(ANGEL.PK_NUM)�� ����˴ϴ�(num �� pk �̱⶧���� not null+unique)
insert into student (num,stuname) values (1,'ȫ����');--����
--ORA-02290: üũ ��������(ANGEL.NK_SCORE)�� ����Ǿ����ϴ�( score ������ �����Ͽ��� �������� ����� ���� ���� ����)
insert into student(num,stuname,score) values (2,'��ȣ��',110);--����

--���� ���� �������ͷ� ����غ���
insert into student values (3,'�̹���',89,sysdate);--��¥�� �����
insert into student values (4,'�����',100,'2010-12-20');
COMMIT;--COMMIT �� �ϴ� �ϸ� ROLLBACK �� �ȵȴ�.
insert into student values (5,'�չξ�',56,'2019-05-10');
insert into student values(6,'������',98,sysdate);
insert into student values(7,'������',67,'2015-09-12');
insert into student values (8,'��ȣ��',66,'2019-05-03');

COMMIT;
rollback;--������ commit �� ������ DML�۾��� ���� �ѹ�(���ư���)

--MUN�� 5���� �������� �̸��� '�չ̶�', SCORE�� 80 ����
UPDATE STUDENT SET STUNAME='�չ̶�' , SCORE=80 WHERE NUM=5;
--BIRTHDAY �� ���� 5�� ����� ������ �ϰ������� 85�� ����
UPDATE STUDENT SET SCORE=85 WHERE TO_CHAR(BIRTHDAY,'mm')=05;

commit;

--num �� 7�� ������ ����
delete from student where num=7;
--�ѹ� �� ������ Ȯ��
rollback;
--�ٽ� ������ ���� 
delete from student where num=7;
--Ŀ���ϱ�
commit;
--�ٽ� �ѹ� �� ������ Ȯ�� �ϱ�
rollback;--�̹� Ŀ�Ե� �����ʹ� ��ҵ��� �ʴ´�.

--���ʿ��� ���������� �����ϰ�ʹ�.
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--���ο� ���������߰�
alter table student add constraint uq_name unique(stuname) ;

-- ���� �̸��� �����͸� �߰��غ���
--ORA-00001: ���Ἲ ���� ����(ANGEL.UQ_NAME)�� ����˴ϴ�(unique ��������)
insert into student (num,stuname) values (10,'��ȣ��');--�����߻�

select * from student;
--������ ���� �� �������� ���̺��� �������ּ���
drop sequence seq_test;
drop table student;
-------------------------------------------------------------------------

/*
join ������ ���̺� 2�� �����ϱ�
���̺� #1:
            food - foodnum ���� (3)
                   foodname ���ڿ�(20)
                   foodprice ����(7)
                   foodsize ���ڿ�(20)
���̺� #2:
        booking -   bnum pk ����(3)
                    bname ���ڿ�(20) nn
                    bhp ���ڿ� (20) uq
                    foodnum ���� (3) - fk(food �� foodnum) 
                    bookingday date
                    
                    �ܺ�Ű�� ����Ȱ�� booking �� �����Ͱ� �߰��� ���� �߰��� foodnum�� �����Ұ�
                    ex) �Խ����� ����� �ܺ�Ű�� ����Ǿ��ִ´� ����� �޸���� �ش���� �����Ҽ� ���� �Խ��ǵ��� �ִ�.
                    �׷��� ���� food�� �����ϸ� �� �޴��� �߰��� ���� �����͵� �ڵ����� ������Ű���� �� ��� booking�� �ܺ�Ű�� �����Ҷ� on delete cascade�� �ָ�ȴ�.
*/

create table food(
    foodnum number(3) constraint pk_foodnum primary key,
    foodname varchar2(20) ,
    foodprice number(7),
    foodsize varchar2(20)
);
--�޴� ����ϱ�
insert into food values (100,'¥���',9000,'����');
insert into food values (101,'¥���',11000,'�����');
insert into food values (200,'������',15000,'����');
insert into food values (201,'������',20000,'�����');
insert into food values (300,'ĥ������',15000,'��');
insert into food values (301,'ĥ������',30000,'��');
insert into food values (400,'�ع�«��',11000,'����');
commit;
select * from food;

--������ �߰�
create sequence seq_food nocache;

--booking ���̺� ����
create table booking(
    bnum number(3) constraint pk_bnum primary key,
    bname varchar2(20) constraint nn_bname not null,
    bhp varchar2(20) constraint uq_bhp unique,
    foodnum number(3),
    bookingday date
 
);
alter table booking add constraint fk_foodnum foreign key(foodnum) references food(foodnum);

--�������̺� �����͸� �߰��غ���
select * from booking;

insert into booking values(seq_food.nextval, 'ȫ����','010-2222-3333',101,sysdate);
insert into booking values(seq_food.nextval, '�̿���','010-3851-8889',201,sysdate+7);
insert into booking values(seq_food.nextval, '������','010-1234-5923',100,sysdate+7);
insert into booking values(seq_food.nextval, '�չ̳�','010-2204-1546',400,sysdate+20);
insert into booking values(seq_food.nextval, '��ȣ��','010-8804-6491',300,sysdate+13);
insert into booking values(seq_food.nextval, '���缮','010-1234-8889',200,sysdate+1);

commit;

--join ���� �����̺��� �����ؼ� ����Ͻÿ�
--bnum,bname,bhp,foodnum,foodname,foodprice,foodsize,bookingday(yyyy-mm0dd)

select 
    bnum,bname,bhp,b.foodnum,foodname,foodprice,foodsize,to_char(bookingday,'yyyy-mm-dd') bookingday
    from food f,booking b
    where f.foodnum=b.foodnum;

--�̹��� �������� ���� food ������ ������ ������?
select
    bnum,f.foodnum, foodname,foodprice,foodsize
    from food f,booking b
    where f.foodnum=b.foodnum(+) and bnum is null;--301�޴��� �ƹ��� �ֹ� ����

--food �� 200�� �޴��� ������ �ɱ��?
--ORA-02292: ���Ἲ ��������(ANGEL.FK_FOODNUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�(100�� �޴��� �ֹ��� ���� �����Ƿ� �����Ҽ� ����)
delete from food where foodnum=200;--����
--food �� 301�� �޴��� ������ �ɱ��?
delete from food where foodnum=301;--�� �ڽ����̺� ���ڵ尡 ���⶧���� ��������

--�θ����̺��� food�� �����غ���
--ORA-02449: �ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�(�ڽ����̺��� ���� ������ �θ����̺��� �����ؾ߸��Ѵ�.
drop table food;--�����߻�

--������ ���� �� �� ���̺��� �����ϼ���
drop table booking;--�ڽ����̺� ���� ����
drop table food;--�ڽ����̺� ���� �� �θ����̺� ����
drop sequence seq_food;
-----------------------------------------------------------------------------
--on delete cascade ����
--�̹����� �θ����̺��� ������ ������ �������̺��� �����͵� �ڵ����� �����ǵ���
--�ܺ�Ű�� �����غ���
--������ ����
create sequence seq_shop;
--shop,cart
create table shop(
    sang_no number(3) constraint shop_pk_no primary key,
    sang_name varchar2(30),
    sang_price number(10)
);
--�ܺ�Ű ������ on delete cascade �� ���̸� �θ����̺� ������ �ڽ����̺� �߰��� �����͵� ���� ������
create table cart(
    cart_no number(3) constraint cart_pk_no primary key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    constraint cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5���� ��ǰ�� ����غ���
insert into shop values (seq_shop.nextval,'���콺',12000);
insert into shop values (seq_shop.nextval,'����',19000);
insert into shop values (seq_shop.nextval,'û����',25000);
insert into shop values (seq_shop.nextval,'üũ��Ʈ',99000);
insert into shop values (seq_shop.nextval,'Ƽ����',11000);
commit;
select *from shop;

--cart �� ���ϴ� ��ǰ�� ��ƺ���
insert into cart values(seq_shop.nextval,2,3,sysdate);

insert into cart values(seq_shop.nextval,1,2,sysdate);
insert into cart values(seq_shop.nextval,5,1,sysdate);
commit;
select *from cart;

--�������� ��ȸ�ϱ�
select cart_no, s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from cart c , shop s
where s.sang_no = c.sang_no;

--�ƹ��� īƮ�� ���� ���� ��ǰ��?
select cart_no,s.sang_no, sang_name,sang_price
from cart c, shop s
where s.sang_no =c.sang_no(+) and cart_no is null;

--on delete cascade �� �� ��� īƮ�� �߰��� ��ǰ�� ���� �����ϴ�.
--2�� ���� ��ǰ�� �����غ���
delete from shop where sang_no=2;

--īƮ �� Ȯ���غ��� īƮ�� �ִ� 2�� ��ǰ�� ��������� Ȯ���Ҽ� �ִ�.
select cart_no, s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from cart c , shop s
where s.sang_no = c.sang_no;

-- ���̺� ���Ŵ� ���� �������̺���� ����
drop table cart;
drop table shop;
drop sequence seq_shop;
----------------------------------------------------------------------------


















