//export : 하나의 모듈에 하나의 기본값으로 지정 ->  class, const, function앞에 명시 가능



/* 
function greet(name){
    return `Hello, ${name}`;
}
    
export default greet; //빨간줄 떠도 선언 가능
*/






export const PI=3.14;
export function add(a,b) {return a+b;}

export class Person{
    constructor(tname, taddress, phone){
        this.tname = tname;
        this.taddress = taddress;
        this.phone = phone;
    }

    printInfo(){
        console.log(`${this.tname} ${this.taddress} ${this.phone}`);
    }

    toString(){ // toString 오버라이드
        return `${this.tname} ${this.taddress} ${this.phone}`;
    }

}

const p1 = new Person('111', '111', '1111');
p1.printInfo();
console.log(p1); // X
console.log(p1 + " "); // 문자열 연산 형식으로  " "를 붙여서 출력 - 자동으로 재정의 toString 호출

const p_list = [new Person('111', '111', '1111'), new Person('222', '222', '2222'), new Person('333', '333', '3333')]; //배열로 선언
p_list.forEach((p, index)=>{

    console.log(`${index + 1} ${p.toString()} `);
}
);