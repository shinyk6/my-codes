package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest02 {
	// reduce를 사용하여 문제를 풀어 보자. 데이터를 Arrays.asList()로 나열한다.
	public static void main(String[] args) {
		System.out.println("Q1️. {3, 7, 2, 9, 5, 8}에서 reduce()를 사용하여 최댓값을 구해보자");

		List<Integer> numbers1 = Arrays.asList(3, 7, 2, 9, 5, 8);
		Optional<Integer> max = numbers1.stream().reduce(Integer::max); //reduce를 사용하기 위해 stream으로 먼저 생성
		max.ifPresent(m -> System.out.println("최대값: " + m));

		System.out.println("Q2. {\"Java\", \"Stream\", \"Reduce\", \"Example\"}에서 reduce()를 사용하여 문자열을 하나로 연결하자");
		List<String> words = Arrays.asList("Java", "Stream", "Reduce", "Example");
		Optional<String> res = words.stream().reduce((a, b) -> a + " " + b); 
		res.ifPresent(System.out::println); //이렇게 해도 되고, reduce.해서 출력해도 됨

		System.out.println("Q3. {2, 3, 4, 5}에서 reduce()를 사용하여 모든 값을 곱한 결과를 구하자");
		List<Integer> numbers3 = Arrays.asList(2, 3, 4, 5);
		int res02 = numbers3.stream().reduce(1, (a,b)->a*b); //곱하기니까 초기값 1을 줌
		System.out.println(res02);

		System.out.println("Q4. {1, 2, 3, 4, 5}에서 reduce()를 사용하여 모든 숫자의 {제곱으로 변환 한다음에 합}을 구하자"); //map을 이용하여 제곱으로 변환하고 합 구하기
		List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
		int res03 = numbers4.stream().map(e->e*e).reduce(0, Integer::sum); //곱하기니까 초기값 1을 줌
		System.out.println(res02);

		System.out.println("Q5. {\"hello\", \"world\", \"java\", \"stream\"}에서 reduce()를 사용하여 모든 단어의 길이의 합을 구하자");
		List<String> words5 = Arrays.asList("hello", "world", "java", "stream");
		int res04 = words5.stream().map(String::length).reduce(0, Integer::sum);
		
		System.out.println("문자열 길이 합 : " + res04);
		

		System.out.println("Q6. {\"apple\", \"banana\", \"cherry\", \"date\"}에서 reduce()를 사용하여 가장 긴 문자열을 찾자");
		List<String> words6 = Arrays.asList("apple", "banana", "cherry", "date");
		Optional<String> res05 = words6.stream().reduce((a,b)->a.length()>=b.length()? a:b);
		res05.ifPresent(e->System.out.println("가장 긴 단어 :" + e));
	}
}
