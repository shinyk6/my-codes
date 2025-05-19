package workshop.work06;
//workshop6-3

/*eclipse에서 argument로 1~5까지의 정수형 데이터 하나를 입력 받아 입력 받은 수부터 10까지 합을 구
한다. 
단, 3의 배수와 5의 배수는 합에서 제외 한다. 
5 입력
결과>>
7 + 8
결과 : 15*/


public class Test03 {

	public static void main(String[] args) {
		
		//값 하나만 입력
		if(args.length==0||args[0].isEmpty()||args.length>=2) {
			System.out.println("값을 다시 입력해주세요");
			return;
		}
		
		int data = Integer.parseInt(args[0]);
		
		int total = 0;
		for(int i=data; i<=10; i++) {
			if(i%3!=0 && i%5!=0) {
				total += i;
				System.out.print(i+"+");
			}
		}
		System.out.println("결과: "+total);
	}

}
