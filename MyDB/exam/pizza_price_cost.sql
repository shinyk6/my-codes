CREATE TABLE pizza_price_cost (id INTEGER PRIMARY KEY, name TEXT, price INTEGER, cost INTEGER);
INSERT INTO pizza_price_cost VALUES (1, 'Potato Bacon Pizza', 22000, 14000);
INSERT INTO pizza_price_cost VALUES (2, 'Sweet Potato Pizza', 24000, 14000);
INSERT INTO pizza_price_cost VALUES (3, 'Combination Pizza', 25000, 13000);
INSERT INTO pizza_price_cost VALUES (4, 'Bacon Cheddar Pizza', 32000, 20000);
INSERT INTO pizza_price_cost VALUES (5, 'Pineapple Pizza', 25000, 22000);
INSERT INTO pizza_price_cost VALUES (6, 'Garlic Shrimp Pizza', 26000, 19000);
INSERT INTO pizza_price_cost VALUES (7, 'Cheeze Pizza', 23000, 17000);
INSERT INTO pizza_price_cost VALUES (8, 'Pepperoni Pizza', 24000, 13000);

/*
1.피자 이름(name) 컬럼

2.가격(price) 컬럼

3.효율성 컬럼-원가 대비 가격(price를 cost로 나눈 값)을 구해 주세요.-별칭은 efficiency로 설정해 주세요.
효율성 기준 카테고리 구분 컬럼
efficiency 값에 따라 아래와 같이 구분된 값을 넣어 주세요.
   1 이상 1.5 미만: 저효율 메뉴1.5 이상 1.7 미만: 중효율 메뉴1.7 이상: 고효율 메뉴
별칭은 efficiency_category로 설정해 주세요.
이때 전체 로우를 efficiency 컬럼 기준, 그 다음 price 컬럼 순서대로 오름차순 정렬해 주세요. 여기서 위에서 5번째 로우까지만 출력합니다.

*/
select *
from pizza_price_cost;

select name
from pizza_price_cost;

select price
from pizza_price_cost;

select name, price, price/cost as efficiency,
	case 
		when price/cost >=1 and price/cost<5 then '저효율 메뉴'
		when price/cost >=1.5 and price/cost<1.7 then '중효율 메뉴'
        else '고효율 메뉴'
    end as efficiency_category
from pizza_price_cost
order by 3, 2
limit 5;









