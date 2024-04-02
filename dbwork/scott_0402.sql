--emp ���̺��� ����Ȯ��
desc emp;
--��ü �÷����� emp  ���̺� ��ȸ
select * from emp;
--ename, jab �÷��� ��ȸ/
select ename,job from emp;
--ename, jab �÷��� ��ȸ, ename �� ��������(asc) �Ǵ� ��������(desc)
select ename, job from emp order by ename asc;--asc�ΰ�� ��������, �������� ���
select ename, job from emp order by ename desc;--ename�� �������� ����

--job�� ��ȸ
select job from emp;

--job �� ��ȸ�ϴµ� ���� ������ �ѹ��� ������ ������������ ���
select distinct job from emp order by job asc;
select distinct job from emp order by 1; --�÷���ȣ�� 1������, ���Ͱ���

--ename �� SMITH �� ����� ��ȸ
select * from emp where ename='SMITH';
select * from emp where ename='ward';--sql ��ɾ�� ��ҹ��� ��������� ����Ÿ�� ��Ȯ�� ����Ѵ�
select * from emp where ename='SMITH' OR ENAME='WARD';

--ENAME, SAL �� ��ȸ
SELECT ENAME, SAL FROM EMP;

--�÷������� ����
SELECT ENAME "�� �� ��",SAL "�� ��" FROM EMP; --���񺯰�� ������ ���ԵǾ�������� �ݵ�� ""�� ���������Ѵ�.
SELECT ENAME �����,SAL �޿� FROM EMP;--���� ����� ������ ���������� ""���� ����

--�����÷��� ���ؼ� �ϳ��� �÷����� ����� ���, �÷����� ���غ�����
SELECT '���̸���'||ENAME||'�̰� ������'||JOB||'�Դϴ�' FROM EMP;
SELECT '���̸���'||ENAME||'�̰� ������'||JOB||'�Դϴ�' "���"FROM EMP;

SELECT ENAME||'���� ������'||SAL||'�����Դϴ�' "����" FROM EMP;

--������ 2000~3000�� ���(��ȸ�� �÷��� ENAME�� SAL)
SELECT ENAME,SAL FROM EMP WHERE SAL>=2000 AND SAL<=3000;
--BETWEEN �� �̿��ؼ� ��ȸ�Ҽ��� �ִ�.
SELECT ENAME,SAL FROM EMP WHERE SAL BETWEEN 1000 AND 2000;

--������ SALESMAN, MANAGER, CLERK ��ȸ
SELECT ENAME,JOB FROM EMP WHERE JOB='SALESMAN' OR JOB='MANAGER' OR JOB='CLERK';
--IN�� �̿��ؼ� ���� �������� ����غ���
SELECT ENAME, JOB FROM EMP WHERE JOB IN ('SALESMAN','MANAGER','CLERK');

--MGR�� 7902,7839,7788 ��ȸ(�÷��� ENAME, JOB, MGR) IN ���
SELECT ENAME, JOB, MGR FROM EMP WHERE MGR IN (7902,7839,7788);--���ڴ� ''����ϴµ� ���ڴ� �ʿ����

--MGR �� null�ΰ��
SELECT * FROM EMP WHERE MGR IS NULL;

--COMM�� NULL�� ��� ��� �÷� ���
SELECT * FROM EMP WHERE COMM IS NULL;

--COMM�� NULL�� �ƴѰ��(NULL �տ� NOT)
SELECT * FROM EMP WHERE COMM IS NOT NULL;

--���� ��ȸ�� %,_ �� �̿��ؼ� ��ȸ
--ENAME�� A�� �����ϴ� ��� ��ȸ
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE 'A%'; 
--ENAME�� N���� ������ ���
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE '%N';

--�̸��� �ι�° ���ڰ� A�λ��
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE '_A%';
--�̸��� ����° ���ڰ� A �λ��
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE '__A%';

--�̸��� S��M���� �����ϴ»��
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE 'S%' OR ENAME LIKE 'M%';

--�̸��� S �� �����ϴ� ��� �߿� ������ 2000 �̻��λ�� ��ȸ
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE 'S%' AND SAL>=2000;
--MGR�� 7902,7788,7566�� �ƴѻ��
SELECT ENAME , SAL FROM EMP WHERE MGR NOT IN (7902,7788,7566);

--COMM , COMM+1000�� ��� ���
SELECT COMM, COMM+1000 FROM EMP;-- NULL�� ���� ���ص� ����� NULL

--�Լ� �� NVL(�÷���,NULL�ϰ�� �ʱⰪ)//MYSQL �� IFNULL�̴�.
SELECT NVL(COMM,0) ,NVL(COMM,0)+1000 FROM EMP;

--���� SQL���� �÷������� �߰��Ͽ� �ϼ��Ͻÿ�
SELECT NVL(COMM,0)COM, NVL(COMM,0)+1000 COM2 FROM EMP ;

--SAL �� 2000-3000�� �ƴѰ�� ��ȸ , �ΰ��� �������
SELECT ENAME, SAL FROM EMP WHERE SAL<2000 OR SAL >3000;
SELECT ENAME , SAL FROM EMP WHERE SAL NOT BETWEEN 2000 AND 3000;

--GROUP �Լ� (COUNT , MAX, MIN, AVG, SUM)
SELECT COUNT (*) FROM EMP;--��ü �ο���
SELECT MAX (SAL) FROM EMP;--�ְ� ����
SELECT MIN (SAL) FROM EMP;--�ּ� ����
SELECT SUM (SAL) FROM EMP; --���� �հ�
SELECT AVG(SAL) FROM  EMP;--���� ���

--AVG�� �Ҽ��� ���ϰ� ���Ƽ� ROUND Ȥ�� CEIL , FLOOR ��� ���� ���� ���
--����� �Ҽ��� ���� 2�ڸ������� �������ϱ�
SELECT ROUND(AVG(SAL),2) FROM EMP;--2073.21 ROUND�� �ݿø�
SELECT CEIL(AVG(SAL)) FROM EMP;--������ �ø� 2074    
SELECT FLOOR(AVG(SAL)) FROM EMP;--������ ���� 2073

--PPT  57 GROUPBY
--JOB �� �׷����� ������ �ο����� ��������
SELECT JOB ����, COUNT(*)�ο��� FROM EMP GROUP BY JOB;

--���� ����� ������ ������������ ���
SELECT JOB ����,COUNT (*) �ο��� FROM EMP GROUP BY JOB ORDER BY  ����; --�÷������� ���� ���ϱ�
SELECT JOB ����,COUNT (*) �ο��� FROM EMP GROUP BY JOB ORDER BY  1; --�÷������� ���� ���ϱ�

--���� ����� �ο����� ������������ ���
SELECT JOB ����, COUNT(*) �ο��� FROM EMP GROUP BY  JOB ORDER BY �ο���;
SELECT JOB ����, COUNT (*) �ο��� FROM EMP GROUP BY JOB ORDER BY 2;

--������ �ο����� �ְ��� , ��������, ��տ��� (������ �ø�)�� ���غ��ÿ�
SELECT JOB ���� ,COUNT(*)�ο���,MAX(SAL)�ְ���,MIN(SAL)��������,CEIL(AVG(SAL))��տ��� FROM EMP GROUP BY JOB ;

--HAVING �� GROUP ������ �׷��Լ��� �̿��ؼ� ������ ���³����
--������ �ο����� �ְ� ������ ���ϴµ� ������ �ο����� 3�� �̻��� ��츸 ��ȸ�� �Ͻÿ�
SELECT JOB , COUNT (*), MAX(SAL) FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

--����Ŭ������ ���糯¥�� ���Ҵ� SYSDATE, MYSQL�� NOW()
SELECT SYSDATE FROM DUAL;--DUAL�� ���� �ֿܼ� ���� ��¥ ���
--3�� ��
SELECT SYSDATE+3 FROM DUAL;
--30�� ��
SELECT SYSDATE+30 FROM DUAL;

--��¥Ÿ���� ���ڿ��� ��ȯ TO_CHAR : ��ȣ Y,M,D,HH,HH24,MI,SS,AN/PM ��
SELECT TO_CHAR(SYSDATE,'YYYY')FROM DUAL;--2024
SELECT TO_CHAR(SYSDATE,'YEAR') FROM DUAL;--�����ڷ� ���� �� �Ⱦ�
SELECT TO_CHAR(SYSDATE,'MM')FROM DUAL;--04
SELECT TO_CHAR(SYSDATE,'MONTH') FROM DUAL;--����/�ѱ۷� ���� ����

--��¥ ��½� ��ȣ�� ���� �� 
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD PM HH:MI') FROM DUAL; --AM�Ǵ� PM �ð� ������� ��Ȯ�� �������� ���
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP���� HIREDATE( ��¥Ÿ��)�� �̿��ؼ� ����غ���
SELECT ENAME �̸�, TO_CHAR(HIREDATE, 'YYYY-MM-DD')����� FROM EMP;

--���⵵�� 1987���� ��� ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')=1987;
--������ 5���λ�� ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY (SELECT �� �ȿ� ��  SELECT ���� �ִ°��)
--SCOTT �� ������ ���� ������ ���� ����� ���Ͻÿ�
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

--��տ������� �������
SELECT * FROM EMP WHERE SAL>=(SELECT AVG(SAL) FROM EMP);

