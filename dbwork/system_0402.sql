--���� ����(system ������ ����)
creat user angel identified by a1234;--�����߻�
--�ֽŹ��������� �տ� ���빮�� c##�� �ٿ��� ���������� �ؾ߸� �Ѵ�.
create user c##angel identified by a1234;
--system ������ ������ ���� Ȯ���ϱ�
select username from dba_users;
--c##angel ���� �����ϱ�
drop user c##angel;
--c## ���빮�ڸ� �Ⱥ��̰� ���������� �Ϸ��� ������ �����ؾ��Ѵ�.
alter session set "_ORACLE_SCRIPT"=true;
--angel ������ �����غ��� (����� a1234)
create user angel identified by a1234;
--angel ������ �⺻������ ����(connect(����),resource(���̺����)
grant connect, resource to angel;
--scott/tiger ������ ������� user �� ���� �� �⺻������ �߰����ּ���
select username from dba_users;
grant connect, resource to scott;
commit;--�߰��� ������ Ŀ��, Ŀ�� ���ҽ� �߰��� ������

--emp ���̺��� ���� Ȯ��
desc emp;
select * from emp;