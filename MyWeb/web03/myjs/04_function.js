
function test(){
  return 100;
}

function test(a){
  return a;
}

function test(a,b){
  return a+b;
}

console.log(test()); //NaN
console.log(test(100)); //NaN
console.log(test(100,200)); //300

//  JS 함수는 오버로딩이 없다!! -> 동일한 이름의 함수는 나중에 선언된 함수로 덮어쓰기 된다.

console.log("=============================");

// if를 이용해 조건을 주어서 오버로딩처럼 사용함
function test02(a,b){
  if(a==undefined && b==undefined) return 100;
  if(b==undefined) return a;
  return a+b;
 }

console.log(test02()); 
console.log(test02(100)); 
console.log(test02(100,200)); 

console.log("==========람다식으로 변경=============");

 //람다로 구현
const test03 = (a,b) => {
  if(a==undefined && b==undefined) return 100;
  if(b==undefined) return a;
  return a+b;
}; 

console.log(test03()); 
console.log(test03(100)); 
console.log(test03(100,200)); 


console.log("=============한줄로 변경===============");

 //삼항연산자를 이용
const test04 = (a,b) => a==undefined ? 100 : b==undefined ?  a: a+b; 

console.log(test04()); 
console.log(test04(100)); 
console.log(test04(100,200)); 

// 람다형식
// const func = (parmas) => expression 
// 조건문 여러 개일 경우 - (params) => {expression}




