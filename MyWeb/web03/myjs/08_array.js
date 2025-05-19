// Array.forEach(callbackFn)
// Array.forEach(callbackFn, thisArg)
// ${} -> 변수, 표현식을 삽입할 때 사용하는 템플릿 리터럴
// ex) `문자열 중앙에 ${값 또는 표현식}`     이름 : ${name}, ${a+b}, ${fn()} 

const a = 10;
const b = 20;
console.log('hap = ${a+b}'); //문자열처럼 나옴
console.log(`hap = ${a+b}`); //결과 나옴

//case 1 : 단순 출력 
const fruits = ["사과", "바나나", "포도"];
fruits.forEach(fruit => {
  console.log(fruit + "<br>"); //브라우저에서 콘솔에 문자열로 <br>을 찍는 것일뿐, HTML에서 줄바꿈의 효과는 없기에 innerHTML같은 기능을 이용해야함.
});


//case 2 : 인덱스 출력 callbackfn: (value: string, index: number, array: string[]) : void
fruits.forEach((fruit, index) => {
    console.log(`인덱스 ${index} : ${fruit}`);
});

//case 3 : 전체 배열까지 출력 (value: string, index: number, array: string[])
fruits.forEach((fruit, index, array) => {
    console.log(`인덱스 ${index} : ${fruit}  전체배열: ${array} `);
});


//case 4 : 배열의 속성으로 출력    / list.속성1 , list.속성2 ..... 
const fruits_list = [
    {name : "사과 ", color : "빨강"},
    {name : "바나나 ", color : "노랑"},
    {name : "수박 ", color : "파랑"},
];
fruits_list.forEach((fruit) => {
    console.log(`${fruit.name}: ${fruit.color}`);
});


//case 5 : 콜백함수 활용
function print(fruit, index){
    console.log(`**${fruit.toUpperCase()}** ${index}`);
}

fruits.forEach(print);
