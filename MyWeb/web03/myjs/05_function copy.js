// case 1 : 다형성 처리를 구현하는 arguments.length 처리  -> ...args : 모든 매개인자를 배열로 받겠다.

const test = (...args) => {
  switch(args.length){
    case 0: return 100;       //매개인자 없음
    case 1: return args[0];   //매개인자 1
    case 2: return args[0] + args[1];
    default : return NaN;
  }
};

console.log(test());
console.log(test(100));
console.log(test(100,200));
console.log(test(1,2,3));

//case 2 : typeof를 이용한 분기 방법 (typeof -> 타입을 리턴해줌)
const test03 = (a,b) => { 
  if(typeof a==undefined && typeof b==undefined) return 100;
  if(typeof b==undefined) return a;
  return a+b;
}; 

console.log(test03()); 
console.log(test03(100)); 
console.log(test03(100,200)); 


//함수 선언 시 블록스코프, typeof확인
//globalThis : 현재 실행환경(자바스크립트)에서 전역 객체
//  "foo" in globalThis -> foo가 전역변수로 등록 되었는지 유무 확인 ture->글로벌 선언, false->글로벌 선언 안함

console.log(
  `'foo' name ${
    "foo" in globalThis ? "is" : "is not"
  } global. typeof foo is ${typeof foo}`,
);
if (false) {
  function foo() {
    return 1;
  }
}

function myfun(){}
console.log("myfun" in globalThis);