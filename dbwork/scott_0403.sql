--ename �� 'A' �� 'S'�� �����ϴ� ����� ENAME,SAL,COMM ��ȸ
SELECT ENAME,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';

--comm �� null �� �ƴѻ���� ��ȸ
select * from emp where comm is not null;

--mgr �� 7698,7566,7782�� ��� ��ȸ (in���)
select * from emp where mgr in(7698,7566,7782);

--sal �� 2500 ���� 3000���� ��ȸ (and ������)
select * from emp where sal >= 2500 and sal <=3000;

--sal �� 2500���� 3000���� ��ȸ(between ���)
select * from emp where sal between 2500 and 3000;

--job �� �ߺ�ó���ؼ� �ѹ����� ����Ͻÿ�
select distinct job from emp;

--�������� ����
--ALLEN �� ������ ���� ������ ���� ������� ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME ='ALLEN');

--SCOTT �� MRG �� �������� ���� ����� ������ ��ȸ�Ͻÿ�
SELECT * FROM EMP WHERE MGR =(SELECT MGR FROM EMP WHERE ENAME='SCOTT');
-------------------------------------------------------------------------------
--�����Լ� �����Լ� ����
SELECT ABS(-5),ABS(5) FROM DUAL;--ABS :���밪
SELECT CEIL(3.1),CEIL(3.9) FROM DUAL;--CEIL: ������ �ø�
SELECT FLOOR(3.0),FLOOR(3.1),FLOOR(3.9) FROM DUAL;--FLOOR: ������ ����
SELECT MOD(7,3),MOD(9,5) FROM DUAL;--MOD: ������
SELECT POWER(2,3),POWER(3,3) FROM DUAL; --POWER: ������
SELECT ROUND(23.456,2),ROUND(8923,-1),ROUND (4567890,-4) FROM DUAL; --ROUND : �ݿø�

--�����Լ�
SELECT CONCAT('HAPPY','DAY') FROM DUAL;--CONCAT: ���ڿ� ���ϱ� 2���ۿ� �ȵ�
SELECT 'HAPPY'||'DAY' FROM DUAL;--���� ����
SELECT INITCAP('HAPPY'),INitCAP('hello') from dual;--initcap: ù���ڸ� �빮�ڷ�
select lower('heLLoDay'),upper('HeLLoDay') from dual;--�ҹ��� �빮��
select lower(ename),initcap(ename)from emp; 
select lpad(sal,10,'*') from emp;--lpad: �������� *ä���
select rpad(sal,10,'*') from emp;--lpad: ���������� *ä���
select substr('happy day',2,3) from dual;--substr : 2�� �ε������� 3���� (ù��° �ε����� 1) :app ���
select substr('happy day',-5,3) from dual;--substr : �ڿ������� 5��° ���ں��� 3���� (ù��° �ε����� 1,������ �ε����� -1) :y d ���
select ename, length(ename) ���ڼ� from emp;--length : ����, ���ڼ�
select replace('Good Day','o','*') from dual;--o�� *�� ���
select instr('happy','a')from dual;--happy �� a�� ��ġ:2
select instr('happy','x')from dual;--������ 0
select instr('have a nice day','nice') from dual;--�ܾ ����
select trim('    hello     ') from dual;--trim: �յ� ���� ����

--��Ÿ �Լ�
--nvl �� ���ϰ�� ��ü������ ���
select nvl(comm,1000) from emp;--null �� ��� 1000���� ���
--decode: �������� �ٸ� ���� ����Ҷ�, ���ǿ����ڿ� ���
select ename �����, deptno �μ��ڵ�,
decode(deptno,10,'ȫ����',20,'������',30,'�λ��') �μ��� from emp; 

--join : ppt 43������
--inner join(��������), equi join
--��� 1
select 
    emp.empno, emp.ename, emp.job, dept.dname, dept.loc
from emp,dept
where emp.deptno=dept.deptno;

--��� 2: �� ���̺� ���������� �ִ� �÷��ϰ�쿡�� �տ� ���̺���� ���̰� �������� ��������
select 
    empno, ename, job, dname, loc
from emp,dept
where emp.deptno=dept.deptno;

--��� 3 : ���̺���� �ʹ� ���� ��Ī�� ����Ҽ� �ִ�.
select 
    e.empno, e.ename, e.job, d.dname, d.loc
from emp e,dept d
where e.deptno=d.deptno;










