// 클래스기반 배열코드 작성하자.
//선언 - class 클래스명
class FruitManager{
    constructor(){ // 생성자
        this.fruits_list = [
            {name : "사과", color : "빨강"}, //공백 주의!!
            {name : "바나나", color : "노랑"},
            {name : "수박", color : "파랑"},
        ];
    }// 생성자 end

    addFruit(name, color){ // 함수선언 - function사용 안해도 함수로 인지
        this.fruits_list.push({name, color});
    } 

    printFruits(){
        this.fruits_list.forEach((fruit) => {
            console.log(`${fruit.name}: ${fruit.color}`);
        });
    }

    removeFruit(name){
        const index = this.fruits_list.findIndex(f => f.name === name); //findIndex : 원하는 인덱스 리턴
        if(index !== -1){
            this.fruits_list.splice(index, 1);
            console.log(`${name} 삭제됨`);
        }else{
            console.log("과일이 없어!!!");
        }  
    }

    updateFruit(name, newname){
        const fruit_one = this.fruits_list.find(f => f.name === name); //find : 원하는 객체 리턴
        if(fruit_one){
            fruit_one.name = newname;
            console.log(`${name} 의 이름이 ${newname}으로 변경됨`);
        }else{
            console.log("이름 변경 실패");
        }  
    }

}

/// 클래스 호출
const manager = new FruitManager();

manager.printFruits();

//데이터 추가
manager.addFruit("딸기", "빨강이2");
manager.printFruits();

//데이터 삭제
manager.removeFruit("딸기");
manager.printFruits();

//업데이트
manager.updateFruit("바나나", "오렌지"); //바나나->오렌지로 업데이트
manager.printFruits();