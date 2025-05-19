var name01 = "홍길동";
let age = 30;
const PI = 3.1415;
//document.write("이름: " + name + "<br>나이: " + age + "<br>원주율: " + PI); //웹 브라우저로 출력
console.log("이름 : ", name01);
console.log("나이 : ", age);
console.log("원주율 : ", PI);

a = 100;
b = 200;

hap = a+b;
console.log(a,b,hap);
console.log(typeof 123); // typeof -> type을 리턴
console.log(typeof 90.9);
console.log(typeof "abc");
console.log(typeof []);
console.log(typeof {});
console.log(typeof true);
console.log(typeof null); // null 값을 평가할 때, 수치 맥락에서는 0으로, 불리언 맥락에서는 false로 동작
console.log(typeof function(){});
console.log(typeof undefined);

console.log([] instanceof Array); //어떤 객체인지, 어떤 생성자로 만들어졌는지
console.log([] instanceof Object);
console.log(new Date() instanceof Date);

//정확한 타입을 확인하고 싶다. (정확한 객체 리턴)
console.log(Object.prototype.toString.call(null)); //prototype - 생성자가 생성되면 사용할 수 있는 속성
console.log(Object.prototype.toString.call([]));
console.log(Object.prototype.toString.call(new Date()));
console.log(Object.prototype.toString.call("abc"));
console.log(Object.prototype.toString.call('abc')); //String -> char index() -> byte

const sym1 = Symbol();
const sym2 = Symbol("foo");
const sym3 = Symbol("foo");

console.log(sym1, sym2, sym3);