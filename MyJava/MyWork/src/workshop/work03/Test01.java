package workshop.work03;
/*
 * 1부터 20까지의 정수 중에서 2의 배수가 아니고  3의 배수가 아닌 수의 총합을 구하시오. 
 * 실행 결과 : sum = 73 
 */

public class Test01 {
	
	static int sum=0;
	
	public static void main(String[] args) {
	
		for(int i=1; i<=20; i++) {
			if(i%2!=0 && i%3!=0) {
				sum += i;
				
			}
		}
		
		System.out.println("sum =" + sum);
	}

}
