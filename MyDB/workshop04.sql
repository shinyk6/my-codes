use mywork;

select * from book;
select * from board;
select * from code;
select * from member;
select * from rent_book;

-- 1. 2023년 6월 18일에 대출된 도서의 제목을 조회합니다. 
select title
from book b
where b.bk_idx = (select bk_idx from rent_book where reg_date='2023/06/18');


-- 2. 2023년 6월 30일에 반납된 도서의 작가를 조회합니다. 
select author
from book b
where b.bk_idx = (select bk_idx from rent_book where return_date='2023/6/30');

-- 3. 2023년 6월 28일에 대출되고 RENT_CNT가 1보다 큰 도서의 제목을 조회합니다. 
select title
from book b
where b.bk_idx in (select bk_idx from rent_book where reg_date='2023/06/28') and b.rent_cnt>1;

-- 4. 연체상태(RE01)인 대출도서의 카테고리를 조회합니다. 
select distinct category 
from book b
where b.bk_idx in(select bk_idx from rent_book where state='RE01');

select bk_idx from rent_book where state='RE01';
 
 -- 5. 대출일과 반납일이 동일한 도서의 제목을 조회합니다.  ***
 select title
 from book
 where b.bk_idx in(select bk_idx from rent_book where return_date=reg_date);
 
-- 6. 2023년 6월 7일에 대출되고 6월 11일에 반납된 도서의 작가를 조회합니다. 
select author
from book b
where b.bk_idx in(select bk_idx from rent_book where reg_date='2023/6/7' and return_date='2023/6/11');
 
-- 7. 2023년 6월 15일에 대출된 도서의 제목을 조회합니다. 
select title
from book b
where b.bk_idx in(select bk_idx from rent_book where reg_date='2023/6/15');
 
 -- 8. 2023년 6월 30일에 대출된 도서들 중 누적 대출 횟수가 가장 적은 책 제목을를 조회합니다.
 select title
 from book b
 where b.bk_idx in(select bk_idx from rent_book where return_date='2023/6/30')
 and rent_cnt=(select min(b.rent_cnt) from book);
 
 -- 9. 2023년 6월에 대출되고 누적 대출 횟수가 평균보다 작은 도서의 제목과 대출 횟수를 조회합니다. ***
select title, rent_cnt
from book b
where rent_cnt < (select avg(rent_cnt) from book) and 
	b.bk_idx in(select bk_idx from rent_book where reg_date between '2023/06/01' and '2023/06/31');

select * from book;
 
 
 -- 10. 연체 상태인 대출도서의 식별자와 상태를 조회합니다.
select distinct bk_idx, state
from rent_book
where state = 'RE02';


-- 11. 사용자가 작성한 게시글 중에서 가장 긴 글의 제목과 글자 수를 조회합니다. ***
select title, length(content) as content_length
from board 
where length(content) = (select max(length(content)) from board);


select * from rent_book;
 select * from board;
 
-- 12. 게시글을 가장 많이 작성한 사용자의 이름과 작성된 게시글 수를 조회합니다. 
 select user_id, count(content)
 from board
 where user_id in (select max(user_id) from board);
 
 
 -- 13. 가장 최근에 작성된 게시글의 제목과 작성일을 조회합니다.  ***
 select title, reg_date
 from board
 where reg_date > (select reg_date 
				from board
				order by reg_date desc);

use mywork;
 
-- 14. 가장 오래된 사용자의 이름과 등록일을 조회합니다. 
select user_id, reg_date
from member_info
where reg_date < any (select reg_date from board order by reg_date);

select * from member_info;


select reg_date from board order by reg_date;


-- 15. 평균 게시글 길이가 가장 긴 사용자의 이름과 평균 게시글 길이 조회합니다.  
select user_id, length(content)
from board
where length(content) > (select user_id from board where max(length(content)));




