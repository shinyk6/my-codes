// Create a global property with `var`
var x = 10;

function createFunction1() {
  const x = 20;
  return new Function("return x;"); // this `x` refers to global `x` 
  //new function - 문자열을 받아서 새로운 함수 객체 생성
}

/* 
function createFunction2() { //function 안에 function은 외부에서 바로 호출 못함
  const x = 20;
  function f() {
    return x; // this `x` refers to the local `x` above
  }
  return f;
}
*/

const f1 = createFunction1();
console.log(f1()); // 10
const f2 = createFunction2();
console.log(f2()); // 20