########## 문자열 함수  ############# 
/*
초기값 확인 (1부터 시작하는지, 0부터 시작하는지) , 리턴타입 확인

https://dev.mysql.com/doc/refman/8.4/en/string-functions.html

CONCAT()	문자열 연결	CONCAT(ENAME, '-', JOB) 
SUBSTR(),   SUBSTRING()	문자열 잘라내기	SUBSTR(JOB, 1, 3) 
UPPER()	  대문자 변환	
LOWER()	 소문자 변환	
LENGTH()	바이트 기준 길이	LENGTH('가') ➔ 3
CHAR_LENGTH()	문자 기준 길이	CHAR_LENGTH('가') ➔ 1
REVERSE()	문자열 뒤집기	REVERSE('SMITH') ➔ 'HTIMS'
LEFT()	왼쪽부터 N글자	LEFT(ENAME, 1) ➔ 'S'
RIGHT()	오른쪽부터 N글자	RIGHT(ENAME, 2) ➔ 'TH'
REPLACE()	특정 문자 치환	REPLACE(ENAME, 'A', 'X') ➔ 'XLLEN'
TRIM()	앞뒤 공백 제거	TRIM(' ALLEN ') ➔ 'ALLEN'
LPAD()	왼쪽에 문자 채우기	LPAD(ENAME, 10, '*') ➔ '*****SMITH'
RPAD()	오른쪽에 문자 채우기	RPAD(ENAME, 8, '!') ➔ 'SMITH!!!'
INSTR()	특정 문자 위치 찾기	INSTR(ENAME, 'E') ➔ 2
LOCATE()	특정 문자 위치 찾기	LOCATE('A', ENAME) ➔ 2
DATE_FORMAT()	날짜 포맷 변경	DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일')
GROUP_CONCAT()	그룹 내 문자열 합치기	GROUP_CONCAT(ENAME) ➔ 'SMITH,ALLEN,WARD'
TO_BASE64()	Base64 인코딩	TO_BASE64('abc') ➔ 'YWJj'   ->이메일 인코딩
FROM_BASE64()	Base64 디코딩	FROM_BASE64('YWJj') ➔ 'abc'
WEIGHT_STRING()	정렬용 문자 가중치 반환	ORDER BY WEIGHT_STRING(ENAME)	-> 다국어
*/
use my_emp;
select  *
from emp;
-- Q1. 이름과 직업을 연결해서 하나의 컬럼을 만들어서 사원번호, 결합내용을 별칭으로 출력하자. CONCAT
-- ex): 'SMITH-CLERK', 'ALLEN-SALESMAN', ...  CONCAT(str1,str2,...) 
 SELECT   CONCAT(ENAME,'-', JOB) as res
 FROM EMP; 

-- Q2. 직업의 처음 세글자를 추출해서 출력하자. SUBSTR, SUBSTRING 
-- ex): 'CLE', 'SAL', 'MAN', ...
/*
SUBSTR(str,pos), SUBSTR(str FROM pos), SUBSTR(str,pos,len), SUBSTR(str FROM pos FOR len)
SUBSTRING(str,pos), SUBSTRING(str FROM pos), SUBSTRING(str,pos,len), SUBSTRING(str FROM pos FOR len)
*/
SELECT JOB, SUBSTR(JOB, 1,3)  
FROM EMP;

SELECT JOB, SUBSTRING(JOB, 1,3)  
FROM EMP;

SELECT SUBSTRING('Quadratically',-3,1); 
SELECT SUBSTRING('Quadratically',2);   #2번째 위치 부터 나머지   
SELECT SUBSTR('Quadratically',2);

-- Q3. 사원의 번호, 사원의 이름을 출력하되 사원의 이름의 첫글자만 대문자 나머지 소문자로 출력하자.
  -- CONCAT, UPPER, LOWER, SUBSTR 
-- ex): 'Smith', 'Allen', ...
SELECT  EMPNO, ename,  CONCAT(UPPER(SUBSTR(ENAME,1,1)) , LOWER(SUBSTR(ENAME,2)) ) AS 결과
FROM EMP;

-- Q3-1. INSTR사용
SELECT  EMPNO,  CONCAT(UPPER(SUBSTR(ENAME, INSTR(ENAME, SUBSTR(ENAME, 1, 1)),1)),
						LOWER(SUBSTR(ENAME,2))) AS 결과
FROM EMP;

-- Q3-2 사원의 이름 중 INSTR 사용해서 A글자를 찾아서 전체 소문자로 출력하자. INSTR(ENAME, 'A') > 0
-- INSTR은 특정 패턴을 찾아 비교할 때 사용하는 함수
select instr(ename, 'A') from emp; -- 숫자(해당 문자의 위치)가 반환 되기에 밑 구문처럼 비교연산 사용 가능

select ename, case when instr(ename,'A') > 0 then 
						(lower(ename)) 
				   else ename 
			   end as 결과
from emp;


-- Q4. 사원의 이름, 입사한날짜(0000년도 00월 00일) 출력하자. DATE_FORMAT
-- ex): 'SMITH', '1980년도 12월 17일', ...
 SELECT ENAME, DATE_FORMAT(HIREDATE, '%Y년도 %m월 %d일') AS 입사한날짜
 FROM EMP;
 SELECT ENAME, DATE_FORMAT(HIREDATE, '%mm, %d% %Y') AS 입사한날짜
 FROM EMP;
-- Q5. 사원의 이름을 두번째 글자를 기준으로 내림차순 정렬하자. SUBSTRING, ORDER BY
-- ex): 'CLARK', 'SMITH', 'BLAKE', ...
select ename
from emp
order by substring(ename,2,1) desc;


-- Q6. 사원의 이름과 길이를 출력하자. LENGTH
-- ex): 'SMITH', 5, 'ALLEN', 5, ...

select concat(ename," ", length(ename)) 길이
from emp;

-- Q7. 사원번호, 사원의 이름, 연봉의 별칭으로 하나의 문자열로 출력하자. CONCAT
-- ex): '7369SMITH800', '7499ALLEN1600', ...
select
	concat(empno, ename, format(sal,0)) 결과
    from emp;
-- Q8. 사원의 이름을 역순으로 출력하자. REVERSE
-- ex): 'HTIMS', 'NELLA', 'DRAH', ...
SELECT ENAME, REVERSE(ENAME) 
FROM EMP;

-- Q9. 사원의 이름에서 마지막 두 글자를 추출해서 출력하자. RIGHT
-- ex): 'TH', 'EN', 'RD', ...
SELECT ENAME , RIGHT(ENAME,2) AS "RIGHT", LEFT(ENAME,1) AS "LEFT"
FROM EMP;

-- Q10. 사원의 이름에서 'A' 문자를 'X' 문자로 대체해서 출력하자. REPLACE
-- ex): 'SMITH', 'XLLEN', 'WXRD', ...
SELECT ENAME,  REPLACE(ENAME, 'A','X')
FROM EMP;

-- Q11. 사원의 이름을 대문자로 변환하여 출력하자. UPPER
-- ex): 'SMITH', 'ALLEN', ...

-- Q12. 사원의 이름을 소문자로 변환하여 출력하자. LOWER
-- ex): 'smith', 'allen', ...

-- Q13. 사원의 이름에서 공백을 제거하고 출력하자. TRIM
-- TRIM([{BOTH | LEADING | TRAILING} [remstr] FROM] str), TRIM([remstr FROM] str)
-- ex): 'SMITH', 'ALLEN', ...
select ename, length(ename), trim(ename)
from emp;

SELECT TRIM(LEADING 'xyz' FROM 'barxxyz') as res;  
SELECT TRIM(BOTH 'xyz' FROM 'barxxx1z') as res;
SELECT length(TRIM(TRAILING '' FROM 'barxx1z       ')) as res;

-- Q14. 사원의 이름을 10자리로 맞추고, 나머지 부분을 '*'로 채워 출력하자. LPAD
-- ex): '*****SMITH', '*****ALLEN', ...
SELECT ENAME, LPAD(ENAME, 10,'*') AS "LPAD",  RPAD(ENAME, 10,'*') AS "RPAD"
FROM EMP;
SELECT LPAD('hi',1,'??') AS "L", RPAD('hi',1,'??') AS "R";
#----->  길이를 '1'로 지정하면 원본 문자열을 잘라서 첫번째 문자만 리턴한다. 
SELECT LPAD('hi',0,'??') AS "L", RPAD('hi',0,'??') AS "R";

-- Q15. 사원의 이름에서 'E' 문자의 위치를 찾아 출력하자. INSTR
-- ex): 2, 5, 0, ...

-- Q16. 사원의 이름을 '이름: [ENAME]' 형식으로 출력하자. CONCAT
-- ex): '이름: SMITH', '이름: ALLEN', ...

-- Q17. 사원의 이름과 직업을 '-'로 연결하고, 전체를 대문자로 변환하여 출력하자. CONCAT, UPPER
-- ex): 'SMITH-CLERK', 'ALLEN-SALESMAN', ...
select upper(concat(ename,'-', job))
from emp;

-- Q18. 사원의 이름을 5자리로 맞추고, 왼쪽에 '#' 문자를 추가하여 출력하자. LPAD
-- ex): '#SMITH', '#ALLEN', ...


-- Q19. 사원의 이름을 8자리로 맞추고, 오른쪽에 '!' 문자를 추가하여 출력하자. RPAD
-- ex): 'SMITH!!!', 'ALLEN!!!', ...
select ename, rpad(ename,8,'!')
from emp;

-- Q20. 사원의 이름이 'SMITH'인 경우 'SMITH'를 대문자로 변환하고, 그렇지 않으면 원래 이름을 출력하자. 
  -- CASE ~ WHEN ~THEN, UPPER 
-- ex): 'SMITH', 'ALLEN', ...
SELECT  CASE WHEN ENAME= 'SMITH' THEN  UPPER(ENAME) 
        ELSE  ENAME
        END  AS  "결과"
FROM EMP;		

-- Q21. 사원의 이름에서 처음으로 나타나는 'A'의 위치를 출력하자. LOCATE  LOCATE(substr,str), LOCATE(substr,str,pos)
-- ex): 2, 0, 3, ...
select ename, locate('A', ename) as 위치
from emp;

-- Q22. 사원의 이름에서 세 번째 글자부터 끝까지 추출하여 출력하자. SUBSTRING
-- ex): 'ITH', 'LEN', 'RD', ...
select ename, substring(ename, 3) as 결과
from emp;

-- Q23. 사원의 이름이 'J'로 시작하는 경우 해당 이름을 대문자로 변환하여 출력하자. UPPER, LIKE
-- ex): 'JONES', 'JAMES', ...
SELECT ENAME, UPPER(ENAME) AS "결과"
FROM EMP
WHERE ENAME LIKE 'J%';

/*
 help replace -> 행의 데이터 교체 키워드를 설명
 키값 조심!
 PRIMARY KEY or a UNIQUEindex -> 테이블에 새로운 행을 삽입할때 (PRIMARY KEY or a UNIQUEindex값이 충돌할 때) 기존 행을 삭제하고 새로운 행을 삽입한다. 
								중복키 처리 방식이 INSERT 하고 다르다.

CASE 1: 데이터 중복되는 경우
새로운 행을 테이블에 삽입 -> 삽입하려는 행에 고유키나 색인키가 중복이 된 값이 있다 -> 기존의 행을 삭제해버림 -> 새로운 행을 테이블에 삽입

CASE 2: 데이터 중복되지 않을 경우
일반 INSERT INTO문 처럼 추가 됨.

                                
REPLACE [LOW_PRIORITY | DELAYED]
    [INTO] tbl_name
    [PARTITION (partition_name [, partition_name] ...)] --특정 파티션에 데이터 교체
    [(col_name [, col_name] ...)]
    { {VALUES | VALUE} (value_list) [, (value_list)] ...
      |
      VALUES row_constructor_list
    }

*/

-- Q24. 사원의 이름에서 모든 'L' 문자를 제거하여 출력하자. REPLACE
-- ex): 'SMITH', 'AEN', 'WARD', ...
select ename, replace(ename, 'L','') as 결과
from emp;


-- Q25. 사원의 이름을 '*'로 감싸서 출력하자. CONCAT
-- ex): '*SMITH*', '*ALLEN*', ...
##################################################번외 편 
-- Q26. BASE64  : 이메일  -> 텍스트 전용 시스템을 통해서 문제 발생될 부분(프린트 할수없는) 의 인코딩 
--  radix-64:   64를 밑수로 사용하는 것   [a-z,A-Z, 0-9] + /   = 64개를 글자 

--  ==> BASE64는  이진 데이터를 radix-64를 기반으로 텍스트 형식으로 인코딩    
--  ==>  데이터 ->  6비트로 나눔   -> radix-64 문자 매핑  

/*
TO_BASE64()   = 인코딩 /  FROM_BASE64() = 디코딩 
   
  BASE64 :  바이너리 데이터 [각 3byte(24bit)씩  4개의 6bit 그룹으로 나눈다.  2^6  = 64 ->  
             6bit 그룹에 2진 데이터를 표현할수 있는]  -> 
             문자열로 리턴 ( 만일 바이너리 데이터가 3의 배수가) 아닌경우 패딩문자 '='가 추가된다.              
   BASE64  :  이진데이터 분류  -> 문자에 매핑 (radix-64)  -> 인코딩 프로세싱(문자열로 리턴) ->  패딩      
 */
SELECT TO_BASE64('abc'), FROM_BASE64(TO_BASE64('abc'));  -- BASE64인코딩 
/*
1. 원본 문자열  'abc' 
2.  이진데이터 분류
      'a    ->  97(ASCII) -> 01100001 (8BIT 이진수)
       b    ->  98(ASCII) -> 01100010 (8BIT 이진수)
       c'   ->  99(ASCII) -> 01100011 (8BIT 이진수)
       ===> 01100001 01100010 01100011   (24bit)
       
3. 6bit씩 나누기    ->  24을 6비트로 계산   -> 그대로 분할  
011000   ->  24 (십진수)  [24	011000   	Y]
010110   ->  22(십진수)   [22	010110	    W]
001001  ->   9(십진수)    [ 9	001001	   J ]
100011  ->  35(십진수)    [ 35 100011  	j] 
*/
# 패딩값 없이 진행 
SELECT TO_BASE64('HELLO, MYSQL');  -- 바이너리 데이터->  radix-64	 -> ASCII  =  BASE64인코딩 
HELP  TO_BASE64;

SELECT LENGTH('A'),LENGTH('TEXT'), LENGTH('가'),LENGTH('한글');  -- 한글기준 3바이트형식
SELECT CHAR_LENGTH('A'), CHAR_LENGTH('TEXT'), CHAR_LENGTH('가'),  CHAR_LENGTH('한글') ;
HELP LENGTH;

-- Q27. LOAD_FILE()  테이블을 이용해서 파일을 로드 해 보자.  
SHOW VARIABLES  LIKE 'secure_file_priv';  #경로 확인    \\  /  \ 
SHOW VARIABLES  LIKE  'max_allowed_packet'; #파일 크기 제한  
SHOW VARIABLES  LIKE  'character_set_filesystem'; #문자 인코딩 변환 확인, 바이트 그대로 처리하겠다.
 -- 경로는 NULL, 파일 크기는 'max_allowed_packet', '67108864' / 1024 = 65536KB / 1024 = 64M  ->전송할 수 있는 최대 패킷 크기
 -- 서버와 클라이언트의 전송 최대 패킷 크기는 64M / LOAD_FILE, BLOB(데이터 타입)


SELECT LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ggomi.png');
SELECT LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\A.TXT');

SELECT LOAD_FILE('D:\\myWork\\MyDB\\Upload\\ggomi.png');
SELECT LOAD_FILE('D:\\myWork\\MyDB\\Upload\\A.txt');

SHOW VARIABLES  LIKE  'NO_AUTO_VALUE_ON_ZERO'; # 컬럼에 AUTO_INCREMENT 0값 저장 안함  

-- Q1. 파일을 생성해서 자동증가 값을 확인 해보자.
DROP TABLE MY_FILE;

CREATE TABLE MY_FILE(
    ID INT AUTO_INCREMENT PRIMARY KEY,  -- 고유값 + NOT NULL
    NAME VARCHAR(20)
);

INSERT INTO MY_FILE VALUES(NULL, '1');
INSERT INTO MY_FILE VALUES('A', '1');

INSERT INTO MY_FILE(NAME) VALUES('3');

SELECT *
FROM MY_FILE;

-- Q2. 파일을 생성해서 테이블에 저장해보자.

CREATE TABLE MY_FILE(
    ID INT AUTO_INCREMENT  PRIMARY KEY,   # NO_AUTO_VALUE_ON_ZERO, PRIMARY KEY(U + NOT NULL)  
    FILE_CONTENT  LONGTEXT -- LONGTEXT : 큰 글자를 입력할 수 있는 문자형타입. 이것보단 BLOB 사용하면 더 빠름
);

DESC MY_FILE;
DESC EMP;

INSERT INTO MY_FILE(FILE_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\A.TXT'));  
         
SELECT ID, FILE_CONTENT  
FROM MY_FILE;

DELETE FROM MY_FILE; -- 테이블의 내용을 삭제. 구조는 그대로
DESC MY_FILE;


-- Q3. 이미지 파일을 생성해서 테이블에 저장해보자.
DROP TABLE MY_IMAGE;

CREATE TABLE MY_IMAGE(
  ID INT AUTO_INCREMENT  PRIMARY KEY, 
  IMG_CONTENT  BLOB
); 

DESC MY_IMAGE;
INSERT INTO MY_IMAGE(IMG_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\A.TXT')),	-- VALUS안에 ,로 나열해서 행으로 삽입
        (LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\GGOMI.PNG'));  

INSERT INTO MY_IMAGE(IMG_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\A.TXT')),  
                   (LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\GGOMI.PNG'));

SELECT IMG_CONTENT
FROM MY_IMAGE;
COMMIT;  -- RUD 명령이 저장됨

DELETE FROM  MY_IMAGE;
COMMIT;


-- -- 문자셋을 확인 해보자. -- --
SHOW VARIABLES LIKE 'character_set%';  -- 문자셋 확인 
SHOW VARIABLES LIKE 'collation%';  -- 정렬 순서, 비교 결정

-- 현재 스키마 및 테이블의 문자셋, 정렬 순서 확인하고 싶다.
SELECT DEFAULT_CHARACTER_SET_NAME, DEFAULT_COLLATION_NAME
FROM information_schema.SCHEMATA -- 테이블 눌렀을 때 i 버튼 (기본정보 확인)
WHERE SCHEMA_NAME = 'my_emp';

-- DB스키마 생성 시 디폴트와 다르게 문자셋, 정렬순을 지정
CREATE DATABASE my_emp_bin
CHARACTER SET utf8mb4
COLLATE utf8mb4_bin;

-- 테이블 생성 시 문자셋, 정렬순을 지정
CREATE TABLE emp_bin (
    empno INT PRIMARY KEY,
    ename VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin	-- 대소문자 다르게 정렬
);



-- Q28)  WEIGHT_STRING(str [AS {CHAR|BINARY}(N)] [flags]) 사용해보자 
-- 이름을 기준으로 언어규칙을 정의해서 정렬할 때 사용  (베트남어, 중국어, 라틴어....)
DESC INFORMATION_SCHEMA.COLLATIONS;
SELECT *
FROM INFORMATION_SCHEMA.COLLATIONS; -- 정렬을 구현하는 코드를 테이블이 가지고 있음

USE INFORMATION_SCHEMA;
SHOW TABLES;

SELECT  ENAME
FROM EMP
ORDER BY WEIGHT_STRING(ENAME);

SELECT ENAME, WEIGHT_STRING(ENAME)
FROM EMP;

-- Q29) EMP구조, 데이터를 가지고 동일한 TEST 테이블 생성하겠다. [키값 제외]
DROP TABLE TEST;
CREATE TABLE  TEST
AS
SELECT  * 
FROM  EMP;


SELECT  *  FROM TEST;
DESC TEST;

DROP TABLE TEST;

-- Q30 )  구조만 복사해보자.  
CREATE TABLE TEST AS
SELECT * 
FROM EMP
WHERE 1=0;  -- 데이터를 복사하지 않고 구조만 복사

-- 30-1 :  중국어 이름 저장 해보자.  
INSERT INTO TEST (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES
(1, '张伟', 'MANAGER', NULL, '2023-08-01', 5000, NULL, 10),
(2, '王芳', 'CLERK', NULL, '2023-08-02', 3000, NULL, 20),
(3, '李娜', 'SALESMAN', NULL, '2023-08-03', 2500, NULL, 30),
(4, '赵强', 'ANALYST', NULL, '2023-08-04', 4000, NULL, 10),
(5, '刘洋', 'MANAGER', NULL, '2023-08-05', 4500, NULL, 20);

SELECT * FROM TEST;

-- 30-2 :   WEIGHT_STRING()을 사용하여 정렬된 결과 확인해 보자.  
SELECT ENAME
FROM TEST
ORDER BY WEIGHT_STRING(ENAME);   #utf8 또는 utf8mb4가 기본 문자셋으로 설정되어 있기 때문에 정렬이 잘된다.  


-- 30-3  : COLLATE를 사용하여 정렬 제어    -> 특정 COLLATE를 적용해 문자열을 정렬한다.  
-- ORDER BY와 함께 사용한다.   / 중국어 데이터를 간체자에 (ZH-CN)에 맞게 정렬해보자.  
-- COLLATE utf8mb4_zh_ci로 구현 할 수 있다. 
SELECT ENAME
FROM TEST
ORDER BY ENAME COLLATE utf8mb4_zh_ci; #---설치가 안되어 있는 경우  

SELECT ENAME
FROM TEST
ORDER BY ENAME COLLATE utf8mb4_unicode_ci;      # unicode_language_id ->유니코드로 정렬. 포함관계 통합코드(모든 언어 포함)가 구현되어있음
 
 -- 30- 4: 목록확인
 SHOW COLLATION LIKE 'utf8mb4%';  
 
 










































