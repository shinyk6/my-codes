package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest01 {

    public static void main(String[] args) {
        transformToUpperCase();
        checkIntermediateValues();
        transformFlatMap();
    }

    // 1. 모든 문자열을 대문자로 변환
    private static void transformToUpperCase() {
        Stream.of("Java", "jsp", "spring", "jquery")
              .map(String::toUpperCase) //map으로 변환
              .forEach(System.out::println); //출력
        System.out.println("========================");
    }

    // 2. 중간 연산 체크 + 문자열 변환
    private static void checkIntermediateValues() {
        Stream.of("루리", "루세", "루오", "폴리")
              .peek(t -> System.out.printf("체크값=%s%n", t)) //스트림이 가진 값을 확인할 때 사용
              .map(t -> t + "\n")
              .forEach(System.out::println);
    }

    // 3. flatMap()`을 사용한 문자열 변환 ->중간연산을 복수개 처리
    private static void transformFlatMap() {
        List<String> list = Arrays.asList("사과3팩", "멜론2팩", "딸기3팩", "포도4팩");

        List<String> result = list.stream() //Collection.stream() 
            .flatMap(s -> { 
                String fruit = s.replaceAll("[0-9팩]", "");  // 과일명만 추출
                int count = Character.getNumericValue(s.charAt(2));  // 숫자 부분 추출
                return Stream.generate(() -> fruit).limit(count);  // 스트림 생성
            })
            .collect(Collectors.toList());

        System.out.println(result);
    }
}
