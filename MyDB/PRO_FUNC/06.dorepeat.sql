CREATE DEFINER=`uk60`@`%` PROCEDURE `dorepeat`(IN P1 INT)
BEGIN

	-- 임시 테이블 생성 해서 INT 값 하나를 넣은 컬럼을 생성한다.
    DROP TEMPORARY TABLE IF EXISTS MY_TEMP;
	CREATE TEMPORARY TABLE MY_TEMP(NUM INT);
	-- 1~10까지 INSERT한다.
	-- 결과 출력을 SELECT로 해보자.
		SET @x = 0;
			 REPEAT
			   SET @x = @x + 1;
               INSERT INTO MY_TEMP VALUES(@X);
			 UNTIL @x >= p1 END REPEAT;
             SELECT *FROM MY_TEMP;
END