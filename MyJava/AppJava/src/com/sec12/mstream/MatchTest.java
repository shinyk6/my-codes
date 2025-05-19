package com.sec12.mstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MatchTest {
	//요소의 조건에 맞게 판별하는 메소드와 집계연산을 구현하는 메소드
	public static void main(String[] args) {	
		
		List<String> str = Arrays.asList("딸기", "바나", "멜론", "수박");

		System.out.println(str.stream().anyMatch(s -> s.equals("멜론")));
		System.out.println(str.stream().noneMatch(s -> s.equals("스낵")));
		System.out.println(str.stream().allMatch(s -> s.length() == 3));
      
		IntStream i = IntStream.of(1, 2, 3, 4, 5);
		int[] v = i.toArray(); //toArray -> 기본타입의 배열로 바꾸어줌 
		for (int n : v) {
			System.out.printf("%3d",n);
		}
		System.out.println("\ncount : " + IntStream.of(1, 2, 3, 4, 5).count());
		System.out.println("sum :" + IntStream.of(1, 2, 3, 4, 5).sum());
		System.out.println("avg : " + IntStream.of(1, 2, 3, 4, 5).average());
		
		System.out.println("=======test========");
		Exam();
 
	}
	
	public static void Exam() {
		
		 
		System.out.println("Q1: allMatch() 메서드를 사용하여 리스트의 모든 요소가 \"나\"를 포함하는지 확인.");
		List<String> fruits = Arrays.asList("바나나", "파인애플", "망고", "체리");			
		System.out.println(fruits.stream().allMatch(f->f.equals("나")));
		
		System.out.println("Q2: IntStream.rangeClosed(1, 10)으로 1부터 10까지 생성 후 짝수만 필터링(filter())하여 출력, 합계를 구함.");
		System.out.println(IntStream.range(1, 10).filter(v->v%2==0).sum());
		
		
		System.out.println("Q3: IntStream.of(1,2,3,4,5).average()의 결과를 orElse(0.0)을 사용하여 OptionalDouble의 값을 3.0으로 출력.");
		System.out.println(IntStream.of(1,2,3,4,5).average().orElse(0.0)); //값이 있으면 값을 리턴, 없으면 0.0리턴
		
		System.out.println("Q4: sorted()를 사용하여 문자열 리스트를 정렬 후 출력.");
		
		
		 List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "박영수");
		names.stream().sorted().forEach(System.out::println);
		
		System.out.println();
		names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
