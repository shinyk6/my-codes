//Q1. 현재 날짜 저장하기
// db.collection.insertOne({
//     name: "홍길동",
//     createdAt : new Date() //현재 시간을 삽입
// })


//Q2. 날짜에서 연,월,일 추출해보자.
db.collection.aggregate([
    {$project: {_id:0, 연:{$year:"$createdAt"}, 월:{$month:"$createdAt"}, 일:{$dayOfMonth:"$createdAt"}}}
]).forEach(printjson);


//Q3. 이름과 년도만 출력해보자.
db.collection.aggregate([
    {$project: {_id:0, 이름: "$name", 연:{$year:"$createdAt"}}}
]).forEach(printjson);

//현재 날짜에서 30일 이후의 데이터 expireAt를 세종대왕 이름으로 삽입해보자.
var today = new Date();
var res = new Date(today.setDate(today.getDate()+30));

var res = db.collections.insertOne({
    name: "세종대왕",
    expireAt: res
});
printjson(res)

////  aggregate로 할 수 있다.
db.collection.aggregate([
    { $project: {
        name: { $literal: "세종대왕" }, //$literal : 일반 값
        expireAt: {
          $add: [ "$$NOW", 1000 * 60 * 60 * 24 * 30 ]  //30일을 밀리초 단위로 계산
    } } }
]).forEach(printjson);

/*
ex) 사용처
게시판 : 최신 게시글 + 작성자별 글수 동시에 출력하고 싶다.
쇼핑몰 : 최근 주문 목록 + 카테고리별 판매량
통계 대시보드 등
*/ 

//$facet을 활용한 다중 분석 : 서로 다른 여러개의 파이프라인을 병렬 실행 하는 연산자.
// 하나의 입력된 데이터로 여러개의 결과를 동시에 리턴한다.
//결과는 각각의 이름으로 된 배열 형태의 필드에 들어감.
db.orders.aggregate([  { 
    $facet: { 
      recentOrders: [   // [1] 최근 주문 5개를 리턴
        { $sort: { orderDate: -1 } }, 
        { $limit: 5 } 
      ], 
      summaryByStatus: [ // [2] 상태별 주문 건수
        { $group: { _id: "$status", total: { $sum: 1 } } } 
      ] 
    } 
  }  //배열 형태로 여러 결과를 리턴받을 수 있음
])