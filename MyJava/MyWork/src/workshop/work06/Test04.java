package workshop.work06;
//workshop6-4

/*
1) eclipse Argument 에서 1~5까지의 두 개의 정수형 데이터를 입력 받는다. 
2) 입력 받은 데이터가 2개 미만 또는 2개 초과로 입력 하면 “다시 입력 하세요” 출력 
3) 1~5이외의 숫자가 입력 될 경우 “숫자를 확인 하세요” 출력 
4) 입력 받은 두 개의 정수를 이용하여 2차원 배열을 생성한다. 
5) 2차원 배열에 1~5까지의 랜덤한 숫자(중복허용)를 넣는다. 
6) 배열의 내용을 출력 한다. 
7) 배열의 총합과 평균을 실수형으로 출력 한다. 
2 2 입력
결과>>
2 2  
5 5  
sum=14.0 
avg=3.5 */


import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		//값 두개 입력
		if(args.length==0||args[0].isEmpty()||args.length>2||args.length<2) {
			System.out.println("다시 입력하세요");
			return;
		}

	}

}
