use my_emp;
create database test; 
drop database test;                             

/*
	SELECT 컬럼명,,,
    FROM 테이블명;emp

*/

#Q1. 사원테이블의 전체 인원을 출력 해보자.
select *
from EMP;

#Q2. 사원테이블에서 사원의 이름, 사원의 번호를 출력하자.
select ename, empno
from emp;

#Q3. 사원테이블에서 사원의 이름, 봉급, 부서번호를 출력하자.
select ename, sal, deptno
from emp;

#Q4.부서 테이블의 모든 데이터를 출력하자.
select *
from dept;

#Q5. 

#Q7. 부서테이블과 사원테이블의 모든 데이터를 출력
select *
from emp, dept;

#Q8. 사원의 이름, 부서번호, 부서이름을 출력하자.
select ename, deptno, dname  ## Error Code: 1052. Column 'deptno' in field list is ambiguous
from emp, dept; #-->에러 어느 테이블의 deptno를 출력하라는거지?

##CASE1 .으로 명시
select emp.ename, emp.deptno, dname 
from emp, dept;

##CASE2 별칭을 준다
select e.ename, e.deptno, d.dname 
from emp e, dept d;

##CASE3 별칭을 준다
select ename, e.deptno, dname 
from emp as e, dept;

##CASE3-1 별칭을 준다
select e.ename, e.deptno, d.dname 
from emp e, dept d;
/*
	컬럼별칭, 테이블 별칭
	select 컬럼명 [as] 별칭,,,[*]
	from 테이블명 [as] 별칭,,,,;
*/

#Q9. "사원의 이름" , "부서번호", "부서이름"으로 출력하자.
##CASE 1 : 속성명에 공백이 있으면 " "로 묶어야함. 
select e.ename "사원 이름", e.deptno "부서 번호", d.dname "부서 이름" 
from emp e, dept d;

##CASE 2 : as 선택
select e.ename as 사원이름, e.deptno as 부서번호, d.dname 부서이름2
from emp e, dept d;

##CASE 3 : 테이블 별칭과 컬럼 별칭
select emp.ename as 사원이름, emp.deptno as 부서번호, dept.dname as 부서이름3 #공백X 안묶어도 됨
from emp, dept d;

#Q10 사원테이블에서 고유 직업명만 출력하자.
select distinct job
from emp;

/*
	중복 데이터 제거
    select DISTINCT 컬럼명 [as] 별칭 ,,,[*]
    from 테이블명 [as] 별칭,,, ;
    DISTINCT : 지정한 컬럼 값이 완전히 같을 때 중복 제거
				컬럼 1개일때는 해당 컬럼값만 비교하고,
				컬럼 2개이상일때 컬럼들의 조합(두 칼럼값이 일치)이 같아야 중복으로 간주함.
*/

#Q11 사원테이블에서 직업, 부서번호를 고유값으로 출력하자.
select distinct job, deptno
from emp;


## 속성에 4칙 연산을 할 수 있다.
/*
	연산 시 null은 null로 리턴되어 계산되지 않는다. 이런 경우 함수를 사용해야함.
    - IFNULL(null이 있는 컬럼, 초기값)
		IFNULL(expr1, expr2)	-> 둘 중 null값이 없는것이 리턴됨alter
		select ifnull(1, 0);	->1리턴

    - COALESCE()
		coalesce(value....)  -> null이 아닌 첫번째 값을 무조건 반환
        select coalesce(null, 1)	->1리턴
    - WHERE문과 같이 사용 -> IS NULL
*/


#Q12 사원의 이름, 사원의 봉급, 사원의 연봉을 연봉이라고 출력하자.
select ename, sal, sal*12 as 연봉
from emp; 

#Q13 사원의 이름, 사원의 봉급을 출력하되, 봉급 = 봉금 + 커미션을 계산해서 봉급이라고 출력하자.
select ename, sal, comm, sal + comm as 봉급 
from emp;

select ename, sal, comm, sal + ifnull(comm, sal) as 봉급 
from emp;

select ename, sal, comm, sal + ifnull(comm, 0) as 봉급 
from emp;

select ename, sal, comm, sal + ifnull(comm, sal*3) as 봉급 
from emp;


/*
	조건문
	select 컬럼명 [as] 별칭,,,[*]
	from 테이블명 [as] 별칭,,,,;
    where 조건식;  	비교 연산의 결과	IN, NOT IN, IS NULL, IS NOT NULL
    AND , OR
    BETWEEN AND
    날짜비교
    문자열 비교 LIKE
*/
#Q14 사원테이블에서 사원의 봉급이 1000 이상인 사원의 이름, 봉급, 커미션을 출력한다.
select ename, sal, comm
from emp
where sal>=1000;

#Q15 사원테이블에서 커미션이 500이상인 사원 이름, 봉급을 출력하자.
select ename, sal
from emp
where comm>=500 ;

#Q16 커미션이 null이 아닌 사원의 이름 커미션을 출력해보자. <is not null>
select ename, comm
from emp
where comm is not null;

#Q17 부서 번호가 10 또는 20인 사원의 모든 정보를 출력하자.
select *
from emp
where deptno IN(10,20); ## 10 or 20

#Q18 부서 번호가 10 또는 20이 아닌 사원의 모든 정보를 출력하자.
select *
from emp
where deptno NOT IN(10,20);	## !(10 or 20)

#Q19 봉급이 2000이상 5000 이하인 사원의 이름과 직업 봉급을 출력하자. AND
select ename, job, sal
from emp
where sal >=2000 AND sal<=5000;

#Q20 봉급이 2000이상 5000 이하인 사원의 이름과 직업 봉급을 출력하자. BETWEEN AND
select ename, job, sal
from emp
where sal between 2000 and 5000;

-- craete AS문
#Q21 날짜는  수치변환이 가능하다 !! 날짜 데이트를 확인 해보자.
# EMP 테이블의 구조를 확인하자.

desc emp;
# emp 테이블의 모든 내용을 TEST테이블로 생성하자 ->단, 제약조건은 복제가 안됨

create table test            
as
select * from emp;

select * from test;
# Test 구조 확인!!!
desc test;

#EMP테이블에서 사원의 이름과 입사일을 TEST02테이블로 생성하자.
create table test02
as
select ename, hiredate
from emp;
select *
from TEST02;
desc test02;

/*
#EMP테이블에서 사원의 이름과 입사일을 TEST03테이블로 생성하자.
create table test03(사원이름, 입사일) 	##Mysql에서는 컬럼명 지정이 안됨 (오라클에선 가능)
as
select ename, hiredate
from emp;
*/

## 구조만 가지고 오고싶다면? (데이터 없이)
create table test03 like emp;

## Test02에 데이터를 입력해보자.  insert into 테이블이름(컬럼명) values (,,,);
desc test02;

insert into test02
values('111', '1980-01-01');
insert into test02
values('222', '1980/01/01');
insert into test02
values('333', '80-01-01'); #1980 으로 인식
insert into test02
values('444', '80/01/01'); #1980 으로 인식
insert into test02
values('555', '80/1/1'); #1980/01/01 으로 인식

select *
from test02;


## TEST02의 사원들의 입사년도가 1981년 이후의 사원들의 목록을 출력해보자.
## DATE = 년, 월, 일
select *
from test02
where hiredate > '81/01/01';		##연도만 넣으면 연월일이 없어서. 연월일까지가 전부 datetime

















