package com.sec10.myreflect;

import java.lang.reflect.Method;


//클래스를 주면 해당 어노테이션이 있는지 확인 후 해당 메소드 실행
public class b_AnnotationInfo {

    public static void main(String[] args) {
        try {
            Class<?> clazz = b_MyClass.class; //.class 실행파일을 clazz가 받음
            for (Method method : clazz.getDeclaredMethods()) { //메소드 확인
                if (method.isAnnotationPresent(b_MyAnnotation.class)) { //해당 메소드에 b_MyAnnotation이 있으면
                    System.out.println("어노테이션이 적용된 메서드: " + method.getName()); //메소드 이름 출력
                    method.invoke(clazz.getDeclaredConstructor().newInstance()); // 그 메서드 실행 
                    															//clazz.getDeclaredConstructor().newInstance()
                    														//해당 클래스의 생성자를 호출해서 메모리할당을 해야 메소드가 실행됨
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
