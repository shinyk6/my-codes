CREATE DEFINER=`uk60`@`%` PROCEDURE `GetEmp_Res`()
BEGIN
WITH RECURSIVE emp_res as (
	 -- [1] 최상위 정보를 출력 해보자.
		select empno, ename, mgr, 1 as level -- 재귀적 계층구조의 시작점을 1로 설정. level=1
		from emp
		where mgr is null
		
		UNION ALL
	 
	 -- [2] 각 사원의 (부하직원)을 재귀적으로 출력하자.
		select e.empno, e.ename, e.mgr, et.level+1
		from emp e
			join emp_res et on e.mgr = et.empno
	)select empno, ename, mgr, level
	from emp_res
	order by level, mgr, empno;
END