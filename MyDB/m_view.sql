use my_emp;

/*
가상 테이블 정의   VIEWtest_view
CREATE
    [OR REPLACE]   기본뷰가 있으면 삭제하고 새로 만들겠다.  
    [ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE_참조여러번 사용할 때 }] 뷰데이터 처리 방법 
    [DEFINER = user] DEFINER=  admin@localhost 사용자 정의
    [SQL SECURITY { DEFINER | INVOKER _ 뷰를 호출하는 사람에게 권한 }] 
    VIEW view_name [(column_list)]
    AS select_statement
    [WITH [CASCADED_ 중첩허용하겠다.   | LOCAL_ 중첩 뷰는 허용하지 않는다. ] CHECK OPTION]    
    
1. WITH CASCADED CHECK OPTION은 뷰 조건을 만족하지 않는 데이터의 INSERT/UPDATE를 차단한다. 

2. JOIN VIEW는 기본적으로 수정(INSERT/UPDATE/DELETE)이 불가하며, CHECK OPTION을 통해 예외적으로 제한된 수정만 허용할 수 있다

3. 뷰는 데이터를 복사하지 않고 원본 테이블의 데이터를 기반으로 가상으로 보여주는 객체이다.  
*/

DROP VIEW if exists my_view;
 SELECT  * FROM  my_view;
START TRANSACTION;
select @@autocommit;
SET AUTOCOMMIT = 0;
SELECT * FROM EMP;

CREATE OR REPLACE  
     ALGORITHM = MERGE 
     DEFINER = 'root'@'localhost' 
     SQL SECURITY  INVOKER 
     VIEW  my_view(empno,ename, DEPTNO)
     AS 
	 SELECT EMPNO , ENAME , DEPTNO  
     FROM EMP
     WHERE DEPTNO =  10
     WITH CASCADED CHECK OPTION ; 
     #---> EMP 에서 데이터를 가져와서 뷰의 결과로 제공하고 , 삽입, 삭제, 업데이트할때 VIEW도 검사하겠다. 
    
    COMMIT;
-- Q1)  생성된 뷰를 조회해 보자.  출력을 해보자  
SELECT   *
FROM MY_VIEW;     
     

-- Q2) COUNT(*)를 비교해보자.  _EMP 전체 행 수와 MY_VIEW의 행 수를 비교하여 뷰가 필터된 결과임을 확인해보자.  
SELECT  COUNT(*) FROM EMP;
SELECT  COUNT(*) FROM MY_VIEW;

-- Q3) 데이터를 삭제  한후   원본과 비교 해보자. => 원본삭제, 뷰 삭제도 된다.  
-- EMP에서 DEPTNO가 10인 행을 삭제하면 뷰에도 반영되는 것을 확인 (뷰는 가상 테이블이므로 동기화됨)
DELETE FROM EMP 
WHERE DEPTNO =  10;
SELECT * FROM EMP;
-- Q4)   ROLLBACK 원본과 비교 해보자. => 같이 움직인다. 
-- DELETE 이후 ROLLBACK을 통해 원본도 복원되고 뷰도 함께 복원됨을 확인
ROLLBACK;    

-- Q5) 반대로 뷰에서 삭제 해보자.  
-- MY_VIEW에서 DELETE를 실행하여 뷰를 통해 원본을 간접적으로 삭제 (동기화 확인) 

DELETE FROM MY_VIEW   # => 같이 움직인다. 
WHERE DEPTNO =  10;
    
-- Q6) 조인된 VIEW를 만들어서 데이터를 추가한 후 테이블을 업데이트 확인하자 (추가, 삭제 )
-- EMP와 DEPT를 조인한 뷰에서 데이터를 삽입해보며 조인 뷰의 INSERT 제한을 확인
-- 6-1 생성
CREATE  VIEW JOIN_EMP 
AS
SELECT ENAME, DEPTNO, DNAME
FROM EMP JOIN DEPT USING(DEPTNO);

-- 6-2 확인 
SELECT  * FROM JOIN_EMP;
SELECT  COUNT(*) FROM JOIN_EMP;
-- 6-3  추가 
INSERT INTO JOIN_EMP(ENAME, DEPTNO,DNAME) VALUES('길동',50, '서울'); -- 오류 
/*
 조인을 생성해서 INSERT, UPDATE, DELETE 작업시 오류가 나는 이유는?
  1)실행시 어떤 테이블의 데이터를 수정해야 할지 모르겠다. 
  2) 다중테이블은 수정 제한 :  뷰가 조인된 테이블을 INSERT,UPDATE,DELETE할 때는 작업을 제한  
  3) 단일테이블은 뷰생성 / 트리거  / 원본 접근 등 우회한다.  
*/    
    
 SELECT VIEW_DEFINITION FROM INFORMATION_SCHEMA.VIEWS   
 WHERE TABLE_NAME = 'JOIN_EMP';  
    
DESC INFORMATION_SCHEMA.VIEWS   ; -- VIEW의 정보 (IS_UPDATABLE확인하기)
    
SELECT CHECK_OPTION, IS_UPDATABLE FROM INFORMATION_SCHEMA.VIEWS   -- 해당 뷰의 옵션 확인
WHERE TABLE_NAME = 'JOIN_EMP';  
    
 SELECT CHECK_OPTION, IS_UPDATABLE FROM INFORMATION_SCHEMA.VIEWS   
WHERE TABLE_NAME = 'MY_VIEW';   



/*
CHECK_OPTION : WITH CASCADED CHECK OPTION 뷰 생성 시 추가 옵션, CASCADED를 지정하게 되면 뷰와 관련된 모든 중첩된 뷰의 조건까지 체크하도록 한다.

IS_UPDATABLE : 수정 가능 유무를 뜻함. YES는 해당 뷰를 통해 원본을 수정할 수 있다. (RUD)

*** CASCADED, YES 이면 조건에 만족하는 INSERT, UPDATE, 허용이 가능하다.
*/  
    
 ################ 예외를  만들었다.  수정은 조건에 따라 위임  
 -- Q7)  조인된 VIEW를 만들어서 데이터를 추가한 후 테이블을 업데이트 확인 하자 
 -- 7- 1 생성 시 속성을 추가한다. 
   -- [WITH  CHECK OPTION]  : 현재 뷰에서 WHERE 절 조건을 강제로 위임  
   -- [WITH CASCADED | LOCAL   CHECK OPTION]  :   현재 뷰와 연관된 뷰의 WHERE 절 조건강제 위임 

DROP VIEW JOIN_EMP02;

-- JOIN_EMP02생성 시 WITH CASCADED CHECK OPTION, 
-- WHERE DEPTNO > 10 조건을 만족해야 INSERT, UPDATE 할 수 있다.
CREATE  VIEW JOIN_EMP02 
AS
SELECT ENAME, DEPTNO, DNAME
FROM EMP 
		JOIN DEPT USING(DEPTNO)
WHERE DEPTNO  > 10  
 WITH CASCADED CHECK OPTION ; -- 조건에 맞는 업데이트와 추가가 이루어 져야 한다.  

SELECT CHECK_OPTION, IS_UPDATABLE FROM INFORMATION_SCHEMA.VIEWS   -- 해당 뷰의 옵션 확인
WHERE TABLE_NAME = 'JOIN_EMP02';  

SHOW CREATE VIEW  JOIN_EMP02;
 
 SELECT * FROM EMP;
 -- 7-2  업데이트  / 조건에 따라 수정  KING이 DEPTNO > 10 조건을 만족해야 업데이트가 된다.
 UPDATE JOIN_EMP02
 SET ENAME ='길동'
 WHERE ENAME ='KING'; -- KING은 부서번호가 10번. ->CHECK OPTION 위반했다.
 
 SELECT  * FROM  JOIN_EMP02;
 
 SELECT  * FROM EMP;
 
 ROLLBACK;
 
  -- 7-3   : INSERT는 안됨  옵션의 범위에 해당하는 INSERT값을 줘야함
INSERT INTO JOIN_EMP02 (ENAME, DEPTNO, DNAME) VALUES ('정길', 10, '부산');
 SELECT CHECK_OPTION, IS_UPDATABLE FROM INFORMATION_SCHEMA.VIEWS   
WHERE TABLE_NAME = 'JOIN_EMP02';  


CREATE VIEW JOIN_EMP03
AS
SELECT ENAME, DEPTNO, DNAMEmy_view
FROM EMP JOIN DEPT USING(DEPTNO)
WHERE  EMP.DEPTNO > 10   
WITH  CHECK OPTION ; 
INSERT INTO JOIN_EMP02 (ENAME, DEPTNO, DNAME) VALUES ('정길', 10, '부산');
 
 -- Q8) https://dev.mysql.com/doc/refman/8.4/en/view-updatability.html 을 사용한 실습을 구현해보자.

 /*
	INSERT : 조인 뷰 X -> 원본을 모두 INSERT 해야 한다.
    UPDATE : 조인 뷰 O -> 업데이트 대상 컬럼이 업데이트 가능 테이블에서 올 경우 
    DELETE : 조인 뷰 X -> 병합된 뷰(MERGE)는 가능하지만 조인 뷰는 불가능
 
 */
 
 -- 8-1. VIEW를 생성하자.
CREATE TABLE t1 (x INTEGER);
CREATE TABLE t2 (c INTEGER);

-- 8-2.원본 테이블에서 X컬럼을 SUM(X) AS S를 통해서 VIEW로 생성확인
-- CASE 1 : 집계함수 포함된 뷰 (업데이트 x)
CREATE VIEW vmat 
AS 
SELECT SUM(x) AS s 
FROM t1;

-- 8-3. INSERT를 해보자. ->원본으로 들어오는 데이터의 합을 VIEW의 컬럼에서 계산한 결과 확인
SELECT * FROM T1;
INSERT INTO T1 VALUES(10); 
SELECT * FROM VMAT; -- SUM을 해주는 가상 테이블

-- 8-4. 조인 테이블을 이용한 뷰를 생성 확인
-- CASE 2 : 단순 뷰 생성 _ 업데이트 가능
CREATE VIEW vup 
AS 
SELECT * FROM t2;

-- CASE 3 : 조인 뷰
CREATE VIEW vjoin 
AS 
SELECT * FROM vmat JOIN vup ON vmat.s=vup.c;
 
 SELECT * FROM VJOIN;
 
 DELETE
 FROM T1;
 
 -- 8-4 쿼리를 생각해 보자.
 -- INSERT 가능한지 확인
 INSERT INTO vjoin (c) VALUES (1); -- INSERT x
 INSERT INTO vup (c) VALUES (1); -- 단일 뷰는 INSERT 가능
 
 -- UPDATE 확인 -> JOIN 뷰에서 일부만 업데이트 가능해도 ok
UPDATE vjoin SET c=c+1; -- T2테이블의 C, VUP의 컬럼으로 업데이트 가능
UPDATE vjoin SET x=x+1; -- VMAT의 SUM(X) 집계 포함 -> 업데이트 불가능

/*
-- 허용되는 다중 테이블의 UPDATE 구문 ->VUP 로 업데이트 대상으로 조인
UPDATE vup JOIN (SELECT SUM(x) AS s FROM t1) AS dt ON ...
SET c=c+1;

-- 허용되는 다중 테이블의 UPDATE 구문 -> 파생테이블 집계수정 불가
 UPDATE vup JOIN (SELECT SUM(x) AS s FROM t1) AS dt ON ...
SET s=s+1; -- 파생테이블의 DT는 집계 수정 불가
 */
 
 
 
    