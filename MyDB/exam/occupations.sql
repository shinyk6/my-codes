create table occupations(
	name varchar(20),
    occupation varchar(50)
);


insert into occupations(name, occupation) values ("Samatha", "Doctor"),
												("Julia", "Actor"),
                                                ("Maria", "Singer"),
                                                ("Meera", "Singer"),
                                                ("Ashely","Professor"),
                                                ("Ketty", "Professor"),
                                                ("Christeen","Professor"),
												("Jane", "Actor"),
                                                ("Jenny","Doctor"),
                                                ("Priya","Singer");
                                                
                                                
select * from occupations;
				
 -- ROW_NUMBER()로 각 직업별로 번호 매기기 - 정렬 기준 반드시 명시 (ORDER BY NAME)
 -- with문 가독성과 재사용성을 위한 서브 쿼리
 -- Left Join : 줄 번호 기준으로 각 직업 테이블 병합 (left join은 한쪽 테이블에 값이 없어도 계속 보여줄 수 있다.)
 
 -- CTE (Common Table Excpressions) : 임시 결과 테이블
 /*
	- SQL 8.0.1부터 도입
	- with문으로 시작 (with을 사용해서 여러개의 CTE 정의 가능)
    - 기본 쿼리보다 먼저 생성
    - 서브 쿼리랑 비슷하지만 재사용성이 높음
    - view와 다르게 권한이 필요없으며 쿼리문이 끝날 때까지만 지속되는 일회성 테이블
    
    재귀적 CTE랑 다른점?
    -> 용도와 동작 방식
    -> 재귀적 CTE는 주로 트리구조, 계층구조, 연결된 관계를 순차적으로 탐색 할 때 사용됨
 */
 
   SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Doctor';
 -- 1. 각 직업별로 줄 번호(rn)를 붙이는 CTE 생성
WITH Doctor AS (
  SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Doctor'
),
Professor AS (
  SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Professor'
),
Singer AS (
  SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Singer'
),
Actor AS (
  SELECT Name, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Actor'
),
-- 2. 모든 줄 번호(rn)를 모은 테이블 만들기
-- union : 모든 줄 번호를 모은다. (중복 제거)
AllNumber AS (
  SELECT rn FROM Doctor
  UNION
  SELECT rn FROM Professor
  UNION
  SELECT rn FROM Singer
  UNION
  SELECT rn FROM Actor
)
-- 3. 줄 번호(AllNumber)를 기준으로 각 직업 테이블을 붙이기
SELECT 
  d.Name AS Doctor,
  p.Name AS Professor,
  s.Name AS Singer,
  a.Name AS Actor
FROM AllNumber r
LEFT JOIN Doctor d ON r.rn = d.rn
LEFT JOIN Professor p ON r.rn = p.rn
LEFT JOIN Singer s ON r.rn = s.rn
LEFT JOIN Actor a ON r.rn = a.rn
ORDER BY r.rn;
 
  SELECT Name, Occupation, ROW_NUMBER() OVER (ORDER BY Name) AS rn
  FROM OCCUPATIONS
  WHERE Occupation = 'Doctor';
 
 select * from occupations;
 
