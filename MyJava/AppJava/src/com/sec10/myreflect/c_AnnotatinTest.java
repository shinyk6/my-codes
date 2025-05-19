package com.sec10.myreflect;
//@Override  // 메서드 재정의 명시 [검색 결과 없음]
//@Deprecated  // 사용 중지 경고
//@SuppressWarnings("unchecked")  // 컴파일러 경고 무시

public class c_AnnotatinTest {

	@Override
	public String toString() {
		return "This method overrides Object.toString()";
	}

	@Deprecated
	public void oldMethod() {
		System.out.println("This method is deprecated");
	}

	@SuppressWarnings("unchecked") //타입 체크 하지말고 경고 내지 말아줘
	public <T> T unsafeOperation(Object ...obj) { //T -> 가변 매개인자 @ScafeVarags ->static 메소드, final에만 사용한다.
		return (T) obj; //값에 의해 타입을 결정하겠다.       ...(1more)
	}
}
