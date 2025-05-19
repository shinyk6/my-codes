// 1. 문자열 → 객체 (읽기 / 파싱)

const jsonString = '{"name": "길동", "age": 28}'; // ' '로 묶어야 함. ' '이 없으면 그냥 객체(Obejct타입)
const user = JSON.parse(jsonString); //json타입으로 파싱
console.log(user.name); 
console.log(user.age);

//2. 객체 → 문자열 (쓰기 / 저장)
const newUser = { name: "홍길동", age: 26 };
const jsonOutput = JSON.stringify(newUser);
console.log(jsonOutput); 

console.log(typeof jsonOutput);
console.log(typeof user.name);