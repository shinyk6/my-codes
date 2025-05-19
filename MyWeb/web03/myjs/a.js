//익명함수를 defualt export로 선언한다. //모듈 당 하나만 선언
//선언 된 함수를 default export하는 경우 확인 (함수 이름은 외부에서 import되지 않음/사용되지 않음)
//react 컴포넌트 파일을 만들 때, 해당 컴포넌트를 export default 사용
//유틸리티 함수 모듈 _ 날짜 포매팅, 문자열 처리
// 해당 모듈이 주로 사용하는 하나의 클래스를 export하는 경우 
export default function(name){
    return `Hello default, ${name}`;
}