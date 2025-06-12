
/*

1) new Date(): 현재 시간을 반환.
2) ISODate(): MongoDB에서 ISO 형식의 날짜로 데이터를 관리.
3) 날짜 범위 쿼리: $gte, $lte로 시작/종료 날짜 필터링.
4)Aggregation: $year, $month, $dayOfMonth로 날짜의 특정 부분 추출.

$dateAdd -> 데이터 타입 BJON으로 확인, js 객체로 확인 / 필드 확인
$dateToString -> 포맷서식 / 필드 확인

포맷에 해당하는 연산자들은 필드가 없음 -> 표현식만 있음
{ $year : <dateExpression> } , { $month : <dateExpression> }
{ $year : new Date("2016-01-01") }
*/


// emp 컬렉션 활용 MongoDB 날짜 처리
print("\n-- Q1. 사원의 입사년도(hiredate 기준)를 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사년도: { $year: "$hiredate" } } }
]).forEach(printjson);

print("\n-- Q2. 1981년에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사년도: { $year: "$hiredate" } } }, //[1] addFields: {새필드명: 값 or 계산식}   새 필드 추가, 기존필드 가공
  { $match: { 입사년도: 1981 } }, // [2] 조건 (필드추가 한것을 매치) 
  { $project: { _id: 0, ename: 1, hiredate: 1 } } // [3] 
]).forEach(printjson);


print("\n-- Q2-1. 10월에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사년도: { $month: "$hiredate" } } }, //addFields - 필드 추가
  { $match: { 입사월: 10 } }, //조건 (필드추가 한것을 매치) 
  { $project: { _id: 0, ename: 1, hiredate: 1 } } 
]).forEach(printjson);

//$expr :  find() 쿼리에서 연산자나 계산식을 사용할 수 있게 해주는 기능 비교 연산 할 때
//find()는 원래 필드와 고정값만 비교 -> {필드 비교} 또는 {날짜에서 월을 추출해서 비교}는 불가능 -> $expr쓰면 가능 
db.emp.find({
  $expr: {$eq: [{ $month: "$hiredate" }, 10]}  
},
 {
  _id: 0, ename: 1, hiredate: 1
 }
)

//ex) 급여가 커미션 보다 큰 사원을 추출하자.  -> 필드비교 (필드끼리 비교)
db.emp.find({ $expr: {$gt : ["$sal", "$comm"]}})

//ex) 급여 + 커미션이 5000이 넘는 사원을 찾아서 출력해보자. find() / $expr / $add / $gt 사용
db.emp.find({
  $expr: { $gt: [{$add: ["$sal", "$comm"]}, 5000]}
})

db.emp.find({
  $expr: {
    $gt : [{$add: ["$sal", { $ifNull: ["$comm", 0]}]}, 5000]
  }
})



print("\n-- Q3. 사원의 입사 요일(숫자 1~7, 일요일~토요일)을 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사요일: { $dayOfWeek: "$hiredate" } } }
]).forEach(printjson);

print("\n-- Q4. 월별 입사자 수를 출력하자. --");
db.emp.aggregate([
  { $group: { _id: { month: { $month: "$hiredate" } }, 입사자수: { $sum: 1 } } },
  { $sort: { "_id.month": 1 } }, //월별로 정렬
  { $project: { _id: 0, 입사월: "$_id.month", 입사자수: 1 } }
]).forEach(printjson);

print("\n-- Q5. 입사일을 yyyy-mm-dd 문자열 형식으로 변환하여 출력하자. --");
db.emp.aggregate([
  { $project: { _id: 0, ename: 1, 입사일포맷: { $dateToString: { format: "%Y-%m-%d", date: "$hiredate" } } } }
]).forEach(printjson);

print("\n-- Q6. 입사한지 40년 이상 된 사원을 출력하자. --");
// $$NOW 시스템 변수 (mong에 존재하는 전역변수) : 현재 시간으로 비교하는 변수, $$ROOT : 현재 문서 전체, $$CURRENT : 현재 문서(document), $$REMOVE : $unset 등의 필드를 제거할 때
db.emp.aggregate([
  { $addFields: { 재직일수: { $dateDiff: { startDate: "$hiredate", endDate: "$$NOW", unit: "year" } } } }, //$dateDiff 계산
  { $match: { 재직일수: { $gte: 40 } } },
  { $project: { _id: 0, ename: 1, hiredate: 1, 재직년수: "$재직일수" } }
]).forEach(printjson);

print("\n-- Q7. 6월에 입사한 사원의 이름과 입사일을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사월: { $month: "$hiredate" } } },
  { $match: { 입사월: 6 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);

print("\n-- Q8. 사원의 입사일 기준 연도별 인원수를 출력하자. --");
db.emp.aggregate([
  { $group: { _id: { year: { $year: "$hiredate" } }, 인원수: { $sum: 1 } } },
  { $project: { _id: 0, 입사년도: "$_id.year", 인원수: 1 } },
  { $sort: { 입사년도: 1 } }
]).forEach(printjson);

print("\n-- Q9. 입사일로부터 현재까지의 정확한 개월 수를 계산하자. --");
db.emp.aggregate([
  { $addFields: { 재직개월수: { $dateDiff: { startDate: "$hiredate", endDate: "$$NOW", unit: "month" } } } },
  { $project: { _id: 0, ename: 1, hiredate: 1, 재직개월수: 1 } }
]).forEach(printjson);

print("\n-- Q10. 11월(입사월=11)에 입사한 사원의 목록을 출력하자. --");
db.emp.aggregate([
  { $addFields: { 입사월: { $month: "$hiredate" } } },
  { $match: { 입사월: 11 } },
  { $project: { _id: 0, ename: 1, hiredate: 1 } }
]).forEach(printjson);