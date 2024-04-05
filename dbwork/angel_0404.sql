-- �ڹ� ���� ������ ������ �� ���̺� ����
create sequence seq_test nocache;

create table person(
    pnum number(3) constraint pk_pnum primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date
);

-- 5���� ������ �ֱ�
insert into person values (seq_test.nextval,'�̻��','a',34,'2010-12-10');
insert into person values (seq_test.nextval,'��ȣ��','o',27,'2012-12-10');
insert into person values (seq_test.nextval,'���缮','o',66,sysdate);
insert into person values (seq_test.nextval,'�չ̳�','ab',19,'2018-12-10');
insert into person values (seq_test.nextval,'������','b',22,'2024-1-10');

commit;

select * from person;

select pnum, pname, upper(pblood) pblood, page, to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;