--ename 이 'A' 나 'S'로 시작하는 사람의 ENAME,SAL,COMM 조회
SELECT ENAME,SAL,COMM FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';

--comm 이 null 이 아닌사람만 조회
select * from emp where comm is not null;

--mgr 이 7698,7566,7782인 사람 조회 (in사용)
select * from emp where mgr in(7698,7566,7782);

--sal 이 2500 부터 3000까지 조회 (and 연산자)
select * from emp where sal >= 2500 and sal <=3000;

--sal 이 2500부터 3000까지 조회(between 사용)
select * from emp where sal between 2500 and 3000;

--job 을 중복처리해서 한번씩만 출력하시오
select distinct job from emp;

--서브쿼리 문제
--ALLEN 의 직업과 같은 직업을 가진 사람들을 조회하시오
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME ='ALLEN');

--SCOTT 의 MRG 과 같은값을 가진 사람의 정보를 조회하시오
SELECT * FROM EMP WHERE MGR =(SELECT MGR FROM EMP WHERE ENAME='SCOTT');
-------------------------------------------------------------------------------
--숫자함수 문자함수 연습
SELECT ABS(-5),ABS(5) FROM DUAL;--ABS :절대값
SELECT CEIL(3.1),CEIL(3.9) FROM DUAL;--CEIL: 무조건 올림
SELECT FLOOR(3.0),FLOOR(3.1),FLOOR(3.9) FROM DUAL;--FLOOR: 무조건 내림
SELECT MOD(7,3),MOD(9,5) FROM DUAL;--MOD: 나머지
SELECT POWER(2,3),POWER(3,3) FROM DUAL; --POWER: 지수승
SELECT ROUND(23.456,2),ROUND(8923,-1),ROUND (4567890,-4) FROM DUAL; --ROUND : 반올림

--문자함수
SELECT CONCAT('HAPPY','DAY') FROM DUAL;--CONCAT: 문자열 더하기 2개밖에 안됨
SELECT 'HAPPY'||'DAY' FROM DUAL;--위와 같다
SELECT INITCAP('HAPPY'),INitCAP('hello') from dual;--initcap: 첫문자만 대문자로
select lower('heLLoDay'),upper('HeLLoDay') from dual;--소문자 대문자
select lower(ename),initcap(ename)from emp; 
select lpad(sal,10,'*') from emp;--lpad: 왼쪽으로 *채우기
select rpad(sal,10,'*') from emp;--lpad: 오른쪽으로 *채우기
select substr('happy day',2,3) from dual;--substr : 2번 인덱스부터 3글자 (첫번째 인덱스는 1) :app 출력
select substr('happy day',-5,3) from dual;--substr : 뒤에서부터 5번째 글자부터 3글자 (첫번째 인덱스는 1,마지막 인덱스는 -1) :y d 출력
select ename, length(ename) 글자수 from emp;--length : 길이, 글자수
select replace('Good Day','o','*') from dual;--o를 *로 출력
select instr('happy','a')from dual;--happy 의 a의 위치:2
select instr('happy','x')from dual;--없으면 0
select instr('have a nice day','nice') from dual;--단어도 가능
select trim('    hello     ') from dual;--trim: 앞뒤 공백 제거

--기타 함수
--nvl 은 널일경우 대체값으로 출력
select nvl(comm,1000) from emp;--null 일 경우 1000으로 출력
--decode: 값에따라 다른 값을 출력할때, 조건연산자와 비슷
select ename 사원명, deptno 부서코드,
decode(deptno,10,'홍보부',20,'교육부',30,'인사부') 부서명 from emp; 

--join : ppt 43페이지
--inner join(내부조인), equi join
--방법 1
select 
    emp.empno, emp.ename, emp.job, dept.dname, dept.loc
from emp,dept
where emp.deptno=dept.deptno;

--방법 2: 두 테이블에 공통적으로 있는 컬럼일경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select 
    empno, ename, job, dname, loc
from emp,dept
where emp.deptno=dept.deptno;

--방법 3 : 테이블명이 너무 길경우 별칭을 사용할수 있다.
select 
    e.empno, e.ename, e.job, d.dname, d.loc
from emp e,dept d
where e.deptno=d.deptno;










