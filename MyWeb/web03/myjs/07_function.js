// Hoisting : 코드가 실행되기 전에 변수 선언과 함수선언을 스코프 최상단으로 끌어올리는 작업
console.log(x);
var x=5;
console.log(x);

/*
var x;              -> 위 코드를 이런식으로 해석함.
console.log(x);
var x=5;
console.log(x);
*/

//function은 호이스팅 가능
prn();
function prn(){
    console.log("=======prn======");
}

//함수 표현식( & 람다식)은 호이스팅이 안됨 ->익명이기에
sayHello();
var sayHello = function(){
    console.log("=====sayHello=======");
};

