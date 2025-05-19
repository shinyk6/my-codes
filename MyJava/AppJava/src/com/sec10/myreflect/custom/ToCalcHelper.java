package com.sec10.myreflect.custom;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToCalcHelper {

	public static String toString(Object obj) {
		StringBuffer buffer = new StringBuffer(); //문자열 담음
		try {
			Class clazz = obj.getClass(); // Calc.class
			
			//클래스가 선언한 필드의 길이만큼 방 만듦 //int[] num = new int[2];
			int[] num = new int[clazz.getDeclaredFields().length]; 
			int i = 0;
			
			//필드를 get메소드로 만들어서 실행 하겠다 !!
			for (Field field : clazz.getDeclaredFields()){  //필드들을 배열로 리턴
				String fieldName = field.getName().toString(); //필드의 이름 리턴
				//필드를 get으로 만듦 getA
				fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); 
				Method method = clazz.getMethod(fieldName); //getA()
				Object value = method.invoke(obj); //getA() 실행
				num[i] = (int) value;
				i++;
			}
			
			
			//강제 제어 부분
			//해당 어노테이션이 있는 메소드를 찾아서 실행 유무를 판단하는 곳
			for (Method method : clazz.getDeclaredMethods()) {
				NotMyNo nmn = method.getAnnotation(NotMyNo.class); //해당 어노테이션 객체로 리턴 받음
				if (nmn == null) {
					if(method.getName().length() == 6){
						Object value = method.invoke(obj, num[0], num[1]);
						buffer.append(method.getName().substring(3)).append(" = ").append(value).append("\n");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
