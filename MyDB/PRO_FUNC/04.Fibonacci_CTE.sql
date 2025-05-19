CREATE DEFINER=`uk60`@`%` PROCEDURE `04_Fibonacci_CTE`(IN p_limit int)
BEGIN
	WITH RECURSIVE Fibonacci_CTE AS (
	-- [1] 초기값 (N=0, FIB=0, PREV_FIB=1)
		select 0 as n, 0 as fib, 1 as prev_fib
		union all
	-- [2] 재귀적으로 피보나치 수열 계산
		select n + 1, prev_fib as fib, fib + prev_fib as prev_fib
		from Fibonacci_CTE
		where n + 1 < p_limit
	)
	select n as "항 번호", fib as "피보나치 수열 "
	from Fibonacci_CTE;
END