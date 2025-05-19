package com.javastudy;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional {

	public static void main(String[] args) {
		
		//문자열을 받아서 정수로 변환 Function
		Function<String, Integer> changeType = str->str.length();
		int length = changeType.apply("Hello");
		
		System.out.println(length);
		
		//숫자가 짝수인지를 판별 Predicate
		Predicate<Integer> predicate = num->num%2==0;
		System.out.println(predicate.test(5)); //5입력
		System.out.println(predicate.test(10)); //2입력

		//콘솔에 메세지를 출력하는 함수 Consumer
		Consumer<String> showMassage = massage->System.out.println("메시지 : " + massage);
		showMassage.accept("메세지 출력하기!!");
		
		//랜덤 숫자를 생성하는 함수
		Supplier<Integer> random = ()->new Random().nextInt(100);
		System.out.println(random.get());  //0~99까지의 랜덤함수 생성
	}

}
