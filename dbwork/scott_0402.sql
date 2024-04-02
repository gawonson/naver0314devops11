--emp 테이블의 구조확인
desc emp;
--전체 컬럼으로 emp  테이블 조회
select * from emp;
--ename, jab 컬럼만 조회/
select ename,job from emp;
--ename, jab 컬럼만 조회, ename 의 오름차순(asc) 또는 내림차순(desc)
select ename, job from emp order by ename asc;--asc인경우 생략가능, 오름차순 출력
select ename, job from emp order by ename desc;--ename의 내림차순 정렬

--job을 조회
select job from emp;

--job 을 조회하는데 같은 직업은 한번만 나오게 오름차순으로 출력
select distinct job from emp order by job asc;
select distinct job from emp order by 1; --컬럼번호는 1번부터, 위와같다

--ename 이 SMITH 인 사람을 조회
select * from emp where ename='SMITH';
select * from emp where ename='ward';--sql 명령어는 대소문자 상관없지만 데이타는 정확히 써야한다
select * from emp where ename='SMITH' OR ENAME='WARD';

--ENAME, SAL 을 조회
SELECT ENAME, SAL FROM EMP;

--컬럼제목을 변경
SELECT ENAME "사 원 명",SAL "급 여" FROM EMP; --제목변경시 공백이 포함되어있을경우 반드시 ""로 묶어져야한다.
SELECT ENAME 사원명,SAL 급여 FROM EMP;--제목 변경시 공백이 없을때에는 ""생략 가능

--여러컬럼을 합해서 하나의 컬럼으로 출력할 경우, 컬럼명을 비교해보세요
SELECT '내이름은'||ENAME||'이고 직업은'||JOB||'입니다' FROM EMP;
SELECT '내이름은'||ENAME||'이고 직업은'||JOB||'입니다' "사원"FROM EMP;

SELECT ENAME||'님의 연봉은'||SAL||'만원입니다' "연봉" FROM EMP;

--연봉이 2000~3000을 출력(조회할 컬럼은 ENAME과 SAL)
SELECT ENAME,SAL FROM EMP WHERE SAL>=2000 AND SAL<=3000;
--BETWEEN 을 이용해서 조회할수도 있다.
SELECT ENAME,SAL FROM EMP WHERE SAL BETWEEN 1000 AND 2000;

--직업이 SALESMAN, MANAGER, CLERK 조회
SELECT ENAME,JOB FROM EMP WHERE JOB='SALESMAN' OR JOB='MANAGER' OR JOB='CLERK';
--IN을 이용해서 여러 직업으로 출력해보자
SELECT ENAME, JOB FROM EMP WHERE JOB IN ('SALESMAN','MANAGER','CLERK');

--MGR이 7902,7839,7788 죄회(컬럼은 ENAME, JOB, MGR) IN 사용
SELECT ENAME, JOB, MGR FROM EMP WHERE MGR IN (7902,7839,7788);--문자는 ''써야하는데 숫자는 필요없음

--MGR 이 null인경우
SELECT * FROM EMP WHERE MGR IS NULL;

--COMM이 NULL인 경우 모든 컬럼 출력
SELECT * FROM EMP WHERE COMM IS NULL;

--COMM이 NULL이 아닌경우(NULL 앞에 NOT)
SELECT * FROM EMP WHERE COMM IS NOT NULL;

--문자 조회시 %,_ 를 이용해서 조회
--ENAME이 A로 시작하는 사람 조회
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE 'A%'; 
--ENAME이 N으로 끝나는 사람
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE '%N';

--이름의 두번째 글자가 A인사람
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE '_A%';
--이름의 세번째 글자가 A 인사람
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE '__A%';

--이름이 S나M으로 시작하는사람
SELECT ENAME, SAL FROM EMP WHERE ENAME LIKE 'S%' OR ENAME LIKE 'M%';

--이름이 S 로 시작하는 사람 중에 연봉이 2000 이상인사람 조회
SELECT ENAME , SAL FROM EMP WHERE ENAME LIKE 'S%' AND SAL>=2000;
--MGR이 7902,7788,7566이 아닌사람
SELECT ENAME , SAL FROM EMP WHERE MGR NOT IN (7902,7788,7566);

--COMM , COMM+1000의 결과 출력
SELECT COMM, COMM+1000 FROM EMP;-- NULL인 경우는 더해도 결과는 NULL

--함수 중 NVL(컬럼명,NULL일경우 초기값)//MYSQL 은 IFNULL이다.
SELECT NVL(COMM,0) ,NVL(COMM,0)+1000 FROM EMP;

--위의 SQL문을 컬럼제목을 추가하여 완성하시요
SELECT NVL(COMM,0)COM, NVL(COMM,0)+1000 COM2 FROM EMP ;

--SAL 이 2000-3000이 아닌경우 조회 , 두가지 방법으로
SELECT ENAME, SAL FROM EMP WHERE SAL<2000 OR SAL >3000;
SELECT ENAME , SAL FROM EMP WHERE SAL NOT BETWEEN 2000 AND 3000;

--GROUP 함수 (COUNT , MAX, MIN, AVG, SUM)
SELECT COUNT (*) FROM EMP;--전체 인원수
SELECT MAX (SAL) FROM EMP;--최고 연봉
SELECT MIN (SAL) FROM EMP;--최소 연봉
SELECT SUM (SAL) FROM EMP; --연봉 합계
SELECT AVG(SAL) FROM  EMP;--연봉 평균

--AVG는 소숫점 이하가 많아서 ROUND 혹은 CEIL , FLOOR 등과 같이 많이 사용
--평균을 소숫점 이하 2자리까지만 나오게하기
SELECT ROUND(AVG(SAL),2) FROM EMP;--2073.21 ROUND는 반올림
SELECT CEIL(AVG(SAL)) FROM EMP;--무조건 올림 2074    
SELECT FLOOR(AVG(SAL)) FROM EMP;--무조건 내림 2073

--PPT  57 GROUPBY
--JOB 을 그룹으로 직업별 인원수를 구해조기
SELECT JOB 직업, COUNT(*)인원수 FROM EMP GROUP BY JOB;

--위의 결과에 직업의 오름차순으로 출력
SELECT JOB 직업,COUNT (*) 인원수 FROM EMP GROUP BY JOB ORDER BY  직업; --컬럼명으로 순서 정하기
SELECT JOB 직업,COUNT (*) 인원수 FROM EMP GROUP BY JOB ORDER BY  1; --컬럼명으로 순서 정하기

--위의 결과에 인원수의 오름차순으로 출력
SELECT JOB 직업, COUNT(*) 인원수 FROM EMP GROUP BY  JOB ORDER BY 인원수;
SELECT JOB 직업, COUNT (*) 인원수 FROM EMP GROUP BY JOB ORDER BY 2;

--직업별 인원수와 최고연봉 , 최저연봉, 평균연봉 (무조건 올림)을 구해보시오
SELECT JOB 직업 ,COUNT(*)인원수,MAX(SAL)최고연봉,MIN(SAL)최저연봉,CEIL(AVG(SAL))평균연봉 FROM EMP GROUP BY JOB ;

--HAVING 은 GROUP 절에서 그룹함수를 이용해서 조건을 나태낼경우
--직업별 인원수와 최고 연봉을 구하는데 직업별 인원수가 3명 이상인 경우만 조회를 하시오
SELECT JOB , COUNT (*), MAX(SAL) FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

--오라클에서는 현재날짜를 구할대 SYSDATE, MYSQL은 NOW()
SELECT SYSDATE FROM DUAL;--DUAL은 현재 콘솔에 현재 날짜 출력
--3일 뒤
SELECT SYSDATE+3 FROM DUAL;
--30일 뒤
SELECT SYSDATE+30 FROM DUAL;

--날짜타입을 문자열로 변환 TO_CHAR : 기호 Y,M,D,HH,HH24,MI,SS,AN/PM 등
SELECT TO_CHAR(SYSDATE,'YYYY')FROM DUAL;--2024
SELECT TO_CHAR(SYSDATE,'YEAR') FROM DUAL;--영문자로 나옴 잘 안씀
SELECT TO_CHAR(SYSDATE,'MM')FROM DUAL;--04
SELECT TO_CHAR(SYSDATE,'MONTH') FROM DUAL;--영어/한글로 월이 나옴

--날짜 출력시 기호를 많이 씀 
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD PM HH:MI') FROM DUAL; --AM또는 PM 시간 상관없이 정확한 오전오후 출력
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP에서 HIREDATE( 날짜타입)를 이용해서 출력해보자
SELECT ENAME 이름, TO_CHAR(HIREDATE, 'YYYY-MM-DD')고용일 FROM EMP;

--고용년도가 1987년인 사람 출력
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')=1987;
--고용월이 5월인사람 출력
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY (SELECT 문 안에 또  SELECT 문이 있는경우)
--SCOTT 의 연봉과 같은 연봉을 가진 사람을 구하시오
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

--평균연봉보다 많은사람
SELECT * FROM EMP WHERE SAL>=(SELECT AVG(SAL) FROM EMP);

