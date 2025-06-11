
print("===================그룹화 및 집계=======================");
print("--Q1. 부서별 평균 월급을 구하자. -");

db.emp.aggregate([
    {$group : {_id:"$deptno", 평균월급:{$avg:"$sal"} } },
    {$project:{_id:0, 부서번호:"$_id", 평균월급:1}}

]).forEach(printjson);   //json타입으로 출력


print("Q2. 직업별 평균 월급을 구하자.");


db.emp.aggregate([
    {$group : {_id:"$job", 평균월급:{$avg:"$sal"} } },
    {$project:{_id:0, 직업:"$_id", 평균월급:1}}

]).forEach(printjson);   //json타입으로 출력


print("Q3.  부서별 평균 월급을 구하되 10번 부서의 평균 월급만 출력하자.");

db.emp.aggregate([
    {$match: {deptno:10}},
    {$group : {_id:"$deptno", 평균월급:{$avg:"$sal"} } },
    {$project:{_id:0, 부서번호:"$_id", 평균월급:1}}

]).forEach(printjson);   

print("Q4. 직업별 월급의 합을 구하자");

db.emp.aggregate([
    {$group : {_id:"$job", 총월급:{$sum:"$sal"} } },
    {$project:{_id:0, 직업:"$_id", 총월급:1}}
]).forEach(printjson); 

print("Q5.직업이 SALESMAN인 사원의 월급의 합을 구하라.");

db.emp.aggregate([
   {  $match : { job : "SALESMAN" }},
   {  $group : {  _id:"$job", 총월급: {$avg: "$sal" }}},
   {  $project : { _id:0, 직업:"$_id", 총월급 : 1 } } 
]).forEach(printjson);


print("Q6. 사원 테이블에서 사원의 최대 월급을 출력하자.");

db.emp.aggregate([
    {$group: {_id:null, 최대월급: {$max:"$sal"}}},
    {$project: {_id:0, 최대월급:1}}
]).forEach(printjson)

print("Q7. 사원테이블에서 사원 최소 월급을 출력하자.");

db.emp.aggregate([
    {$group: {_id:null, 최소월급: {$min:"$sal"}}},
    {$project: {_id:0, 최소월급:1}}
]).forEach(printjson)

print("Q8. 각 부서별 최대 월급을 출력하자.");

db.emp.aggregate([
    {$group: {_id:"$deptno", 최대월급: {$max:"$sal"}}},
    {$project: {_id:0, 부서번호:"$_id", 최대월급:1}}
]).forEach(printjson);

print("Q9. 사원 테이블에서 커미션이 책정되어 있는 사원의 이름과 커미션을 출력하라");

db.emp.find(
    {comm : {$ne:"", $ne: null}},
    {_id:0, ename:1, comm:1}
).forEach(printjson);



print("Q10. 사원 테이블에서 커미션이 책정되지 않은 사원의 이름과 커미션을 출력하라.");
db.emp.find(
    {$or:[{comm:""}, {comm:null}]},
    {_id:0, ename:1, comm:1}
).forEach(printjson);


print("Q11. 사원 테이블에서 커미션이 책정되지 않은 사원의 인원수를 출력하라");
db.emp.aggregate([
    {$match: {$or: [{comm:""}, {comm:null}]}},
    {$group:{_id:"커미션 없음", 인원수:{$sum:1}}},
    {$project:{_id:0, 조건:"$_id", 인원수:1}}
]).forEach(printjson);


print("-- Q12: 월급이 5000 이상인 사원의 직업별 월급 합계를 출력해보자  ---"); 
db.emp.aggregate([
    {$match:{sal:{$gte:5000}}},
    {$group:{_id:"$job", 월급합:{$sum:"$sal"}}},
    {$project:{_id:0, 직업:"$_id", 월급합:1}}
]).forEach(printjson);


print("-- Q13.  직업별 월급의 합을 구하고, 월급의 합이 3000 이하인 사원만 출력해보자.  ");
db.emp.aggregate([
    {$group:{_id:"$job", 월급합:{$sum:"$sal"}}},
    {$match:{월급합:{$lte:3000}}},
    {$project:{_id:0, 직업:"_id", 월급합:1}}
]).forEach(printjson);





print("-- Q15.  직업별 사원의 이름과  월급의 합, 전체 총합 및 세부내역을 출력 해보자.  ");