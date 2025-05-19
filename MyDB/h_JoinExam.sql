USE world;


select * from city;

select * from country; -- pk

select * from countrylanguage; -- 참조

-- Q1. 모든 도시(city)의 이름과 해당 국가(country)의 이름을 출력하되, 각각 City와 Country라는 별칭으로 표시하자.
-- ANSI
select city.name as City, country.name as Country 
from city
join country on (city.CountryCode = country.Code);
-- MYSQL
select city.name as City, country.name as Country 
from city, country
where city.CountryCode = country.Code;

-- Q2. 인구 수가 100만 이상인 도시 이름, 인구, 해당 국가 이름을 출력하되, 도시의 인구가 기준이다.
-- ANSI

select city.name, city.population, country.name
from city join country on (city.CountryCode = country.Code and city.population>=1000000);


-- MYSQL
select city.name, city.population, country.name
from city,country
where (city.CountryCode = country.Code and city.population>=1000000);


-- Q3. 도시 이름, 국가 코드, 해당 도시가 속한 국가에서 사용되는 언어를 출력하자.
-- ANSI

select city.name, city.CountryCode, language
from city join country on (city.CountryCode = country.Code)
		 join countrylanguage using(CountryCode);
-- MYSQL
select city.name, country.code, language
from city, country, countrylanguage
where city.CountryCode = country.Code and countrylanguage.CountryCode=city.CountryCode;

-- Q4. 공용 언어(IsOfficial='T')만 골라 언어 이름과 해당 국가 이름을 출력하자.
-- ANSI
select language, country.name, countrylanguage.isOfficial
from countrylanguage join country on (countrylanguage.countryCode = country.code and countrylanguage.isOfficial='T');

-- MYSQL
select language, country.name, countrylanguage.isOfficial
from countrylanguage,country
where (countrylanguage.countryCode = country.code and countrylanguage.isOfficial='T');

-- Q5. 아시아 대륙에 속한 국가에 있는 도시의 이름과 인구를 출력하자.
-- ANSI
select city.name, city.population, continent
from city join country on (city.CountryCode = country.Code and continent='Asia');

-- MYSQL
select city.name, city.population, continent
from city,country
where (city.CountryCode = country.Code and continent='Asia');

-- Q6. 기대 수명(LifeExpectancy)이 80 이상인 국가의 이름과 대륙을 출력하자.
-- ANSI
select country.name, continent
from country
where lifeExpectancy>=80;

-- MYSQL
select country.name, continent, lifeExpectancy
from country
where lifeExpectancy>=80;
-- Q7. 공용어가 영어인 국가의 이름만 출력하자.
-- ANSI
select country.name, language
from country join countrylanguage on (countrylanguage.countryCode = country.code and language='English');

-- MYSQL
select country.name, language
from country,countrylanguage
where (countrylanguage.countryCode = country.code and language='English');

-- Q8. 모든 국가의 이름과 수도 도시의 이름을 각각 Country, Capital로 별칭을 주어 출력하자.
-- ANSI

-- MYSQL

-- Q9. 도시 이름, 도시 인구, 해당 국가의 지역(region)을 출력하자.
-- ANSI
select city.name, city.population, country.region
from city join country on city.CountryCode = country.Code;

-- MYSQL
select city.name, city.population, country.region
from city,country
where city.CountryCode = country.Code;

-- Q10. 인구가 500만 이상인 국가에서 사용되는 언어를 해당 국가 이름과 함께 출력하자.
-- ANSI
select language, country.name, country.population
from country join countrylanguage on countrylanguage.countryCode = country.code and country.population>=5000000;

-- MYSQL
select language, country.name, country.population
from country, countrylanguage
where countrylanguage.countryCode = country.code and country.population>=5000000;

-- Q11. 도시 이름과 해당 국가의 정부 형태(GovernmentForm)를 출력하자.
-- ANSI
select city.name, GovernmentForm
from city join country on city.CountryCode = country.Code;

-- MYSQL
select city.name, GovernmentForm
from city, country
where city.CountryCode = country.Code;

-- Q12. 공용어가 영어인 국가에 속한 도시 이름을 중복 없이 출력하자.
-- ANSI


-- MYSQL

-- Q13. 국가 이름과 그 국가에서 사용되는 언어 이름을 출력하자.
-- ANSI
-- MYSQL

-- Q14. 모든 국가의 이름과 수도 도시의 인구를 출력하자.
-- ANSI
-- MYSQL

-- Q15. 도시 이름과 해당 국가의 독립 연도(IndepYear)를 출력하자.
-- ANSI
-- MYSQL

-- Q16. 사용 언어 수가 5개 이상인 국가의 이름을 출력하자.  **
-- ANSI
-- MYSQL

-- Q17. 도시 이름과 그 도시가 속한 국가의 국토 면적(SurfaceArea)을 출력하자.
-- ANSI
-- MYSQL

-- Q18. 아프리카 대륙에 속한 국가의 이름과 수도 도시 이름을 출력하자.
-- ANSI
-- MYSQL

-- Q19. 전 세계에서 인구가 가장 많은 도시의 이름과 그 도시가 속한 국가 이름을 출력하자.
-- ANSI
-- MYSQL

-- Q20. 도시 인구의 평균이 100만 이상인 국가의 이름을 출력하자.
-- ANSI
-- MYSQL

-- Q21. 도시 정보가 없는 국가를 출력하자 -> 나라에는 등록되어 있지만
