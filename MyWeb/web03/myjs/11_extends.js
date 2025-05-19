import { PI as p_PI ,  add ,  Person } from './10_class.js';

console.log(test("길동이란다."));

class Employee extends Person{
    constructor(tname, taddress, phone, position){
        super(tname, taddress, phone); //부모 생성자 호출
        this.position = position; //새로운 필드 추가
    }

    // 새로운 메소드 추가
    printJob(){
        console.log(`${this.tname}의 직책은 ${this.position}입니다.`); //자바스크립트에서는 선조를 부르는것이 아니라 상속 받은 자신(this)을 부름
    }
    // toString() 오버라이딩
    toString(){
        return super.toString() + `/ 직책: ${this.position}`;
    }
}

const emp = new Employee("홍길동", "서울시 강남구", "010-1234-5678", "매니저");

emp.printInfo();
emp.printJob();

console.log(emp.toString());