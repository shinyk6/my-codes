-- students 테이블
-- 1) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정
-- 5) CREATE TABLE에서 열에 기본값 지정  DEFAULT 
-- 6) CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정

--  << 학생 정보를 유지하기 위한 students 테이블 생성 >>- 

CREATE DATABASE  STUDENTS;
USE STUDENTS;
DROP TABLE STUDENTS;
-- Q1) CREATE TABLE로 새 테이블 만들기
create table students(
	student_id int,
    student_number varchar(10),
    first_name varchar(50),
    last_name varchar(50),
    middle_name varchar(50),
    birthday date,
    gender enum('M','F'),
    paid_flag bool
);

desc students;
-- Q1-1. 데이터 입력
insert into students
values
(1, '1', '1', '1', '1', now(), 'M', true),
(2, '1', '1', '1', '1', now(), 'F', 0),
(3, '1', '1', '1', '1', now(), 'F', false),
(4, '1', '1', '1', '1', now(), 'M', true);

-- Q1-2. 전체 내용 확인
select * 
from students;

#################################################
-- Q2) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정 _ 식별키
-- 테이블당 하나만 지정할 수 있다. (단일키, 복합키) = u+nn
create table students02(
	student_id		int,
    student_number	varchar(10),
    first_name 		varchar(50),
    last_name 		varchar(50),
    middle_name 	varchar(50),
    birthday 		date,
    gender 			enum('M','F'),
    paid_flag 		bool,
    primary key(student_id)
);

desc students02;
-- Q2-1. 데이터 입력
-- 중복데이터 x + not null = PK

insert into students02
values
(1, '1', '1', '1', '1', now(), 'M', true),
(2, '1', '1', '1', '1', now(), 'F', 0),
(3, '1', '1', '1', '1', now(), 'F', false),
(4, '1', '1', '1', '1', now(), 'M', true);

-- Q1-2. 전체 내용 확인
select * 
from students02;

-- Q2-3. PK확인
insert into students02
values (1, '1', '1', '1', '1', now(), 'M', true);

-- Q2-4. 정보를 확인해보자.
SHOW CREATE TABLE students02; 

 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
 FROM information_schema.TABLE_CONSTRAINTS  
WHERE TABLE_SCHEMA = 'students'  AND TABLE_NAME = 'students02'; 

-- Q3. PK 복합키를 확인 해보자. 
create table students03(
	student_id		int,
    student_number	varchar(10),
    primary key(student_id, student_number)
);
desc students03;

-- Q3-1. 데이터를 입력해보자. 
insert into students03
values (1, 1), (1, 2), (1, 3), (1, 4);

insert into students03
values (2, 1), (2, 2), (2, 3), (2, 4);

insert into students03
values (3, 1), (3, 2), (3, 3), (3, null); -- Error : 1048

insert into students03
values (1, '1'), (1, '2'), (1, '3'), (1, '4'); -- Error : 1062

select *
from students03;

-- Q3-2. 제약조건을 확인하자.
 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
 FROM information_schema.TABLE_CONSTRAINTS  
WHERE TABLE_SCHEMA = 'students'  AND TABLE_NAME = 'students03'; 

desc information_schema.TABLE_CONSTRAINTS;


-- Q4. 자동 증가 구현하는 제약조건을 확인 해보자. 	PK도 걸고 자동증가도 걸자
create table students04(
	student_id		int	auto_increment, -- null값이어도 자동증가해줌
    student_number	varchar(10),
    primary key(student_id) 
);
desc students04;

insert into students04(student_number)
values (10), (20), (30), (40);

select *
from students04;

-- Q4-1. 테이블 수정하자 -> 자동증가 초기값 100으로 
alter table students04
auto_increment = 100;

insert into students04(student_number)
values (10), (20), (30), (40);


-- 번외편 https://dev.mysql.com/doc/refman/8.4/en/innodb-auto-increment-handling.html
CREATE TABLE t1 (
c1 INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
c2 CHAR(1)
) ENGINE = INNODB;

desc t1;

INSERT INTO t1 (c1,c2) VALUES (1,'a'), (NULL,'b'), (5,'c'), (NULL,'d');
INSERT INTO t1 (c1,c2) VALUES (11,'a'), (NULL,'b'), (15,'c'), (NULL,'d');

select * from t1;

show table status like 't1';
show table status like 'students04';

-- t1 테이블의 DROP PRIMARY KEY를 사용해서 키값을 삭제하자.
alter table t1
DROP PRIMARY KEY; -- Error : auto_increment걸려있어서 

alter table t1 modify column c1 int;  -- 자동 증가 속성 해제 = 컬럼 수정(재정의)
alter table t1 DROP PRIMARY KEY; -- 삭제

-- Q5. 자동 증가 구현하는 제약조건을 확인 해보자. 	PK도 걸고 자동증가도 걸자. 기본값도 지정하자.
create table students05(
	student_id		int	auto_increment, -- null값이어도 자동증가해줌
    student_number	varchar(10) default 'ABC',
    primary key(student_id, student_number) 
);
drop table students05;
desc students05;

insert into students05 values (1, 10), (2,20), (3, 30), (4, 40);
insert into students05(student_id) values (1); 

select * from students05;

-- Q6. 복합키, 자동증가, 기본값으로 지정하고 각 제약조건을 삭제 해보자.
create table students06(
	student_id		int	auto_increment, -- null값이어도 자동증가해줌
    student_number	varchar(10) default 'ABC',
    student_name	varchar(50),
    primary key(student_id, student_number) 
);
desc students06;
insert into students06 (student_name)
	values(1);
    
select * from students06;

-- Q6-1. 기본키 삭제 
alter table students06 modify column student_id int;  -- 자동 증가 속성 해제 = 컬럼 수정(재정의)

alter table students06
drop primary key;

-- Q6-2. default 삭제 -> 컬럼 라벨
alter table students06
alter student_number drop default;

desc students06;
-- Q6-3. 삭제 된 default 를 다시 추가해보자.
alter table students06
alter student_number set default 'ABC';

-- Q7. 제약조건을 생성해보자.
-- CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정 : 중복데이터 X + Null허용
-- CREATE TABLE에서 검사 (CHECK) 제약 조건 지정 : 범위 지정

create table students07(
	student_id		int, -- null값이어도 자동증가해줌
    student_number	varchar(10),
    birthday 		date,
    unique key(student_id),
    check (birthday >= '2001-01-01')
);

desc students07;

insert into students07(student_id) values(null);	-- unique key null값 확인
insert into students07(student_id, birthday) values(1, now());
insert into students07(student_id, birthday) values(2, now()); 
insert into students07(student_id, birthday) values(3, '1999-01-01'); -- students07_chk_1 Error 3819

select *
from students07;

show create table students07;

drop table students071;
create table students071(
	student_id		int, -- null값이어도 자동증가해줌
    student_number	varchar(10),
    birthday 		date,
    unique key(student_id),
    check (birthday >= '2001-01-01'), -- 테이블명_chk_라벨링
    check (student_number >= 10)    
);

-- 체크 제약조건을 확인하자.
 SELECT CONSTRAINT_NAME, CHECK_CLAUSE  
FROM information_schema.CHECK_CONSTRAINTS; 

desc information_schema.CHECK_CONSTRAINTS;

-- Q7-1. 제약조건을 확인 후 체크제약조건을 삭제해보자.
alter table students071
drop check students071_chk_1;

alter table students071
drop check students071_chk_2;

 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
 FROM information_schema.TABLE_CONSTRAINTS;
 
-- Q7-2. 테이블의 제약조건을 확인하고 남아있는 키값을 삭제 하자.
-- unique key 삭제방법 : DROP INDEX
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
FROM information_schema.TABLE_CONSTRAINTS  
WHERE TABLE_NAME = 'students071';

alter table students071 
drop index student_id; -- drop index 컬럼명

show keys from students07; -- 테이블의 키값 확인


-- Q8. 참조형 테이블을 생성해보자.
-- CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정
-- 참조는 여러컬럼 할 수 있음. 다만, 짝이 (개수) 맞아야함
drop table students05;
 create table students05(
	student_id		int	auto_increment,
    student_number	varchar(10) default 'ABC',
    primary key(student_id) 
);

desc students05;

insert into students05 values(1,1);
insert into students05 values(2,2);

select *
from students05;

-- 현재 student_my 테이블의 student_id를 students05의 student_id로 참조시키자.
 create table student_my(
	student_id	int ,
    FOREIGN KEY(student_id) references students05(student_id) 
);

use students;
drop table student_my;
select * from students05;
desc student_my;
show keys from student_my;

-- 키 확인
 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE 
FROM information_schema.TABLE_CONSTRAINTS  
WHERE TABLE_NAME = 'student_my';  -- student_my_ibfk_1

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE, REFERENCED_TABLE_NAME -- 참조형 테이블의 정보 확인
FROM information_schema.REFERENTIAL_CONSTRAINTS  
WHERE TABLE_NAME = 'student_my'; 

-- 데이터 입력
insert into student_my values(1);
insert into student_my values(null);
insert into student_my values(3); -- Error 1452 참조한 테이블에 없는 값을 넣었기 때문에
insert into student_my values(2);
-- 데이터 확인
select * from student_my;