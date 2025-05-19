CREATE DEFINER=`uk60`@`%` PROCEDURE `02_GuGuDan`()
BEGIN
	WITH RECURSIVE GuGuDan AS (
		-- [1]. 초기값 지정 3 * 1
		select 3 as dan, 1 as num, 3*1 as result
		
		UNION ALL
		-- [2]. 재귀적으로 NUM을 1씩 증가시키면서 9까지 반복한다.
		select dan, num+1, dan*(num+1)
		from GuGuDan
		where num<9
	)
	-- [3]. 전체 출력
	select concat(dan, " * ", num, " = ", result) as GuGuDan_PRN
	from GuGuDan;
END