package workshop.work06;

//workshop6-2

/*프로그램 실행 시 eclipse argument로 5~10까지의 정수형 데이터를 입력 받는다. 
입력 받은 정수 값을 Calc class의 calculate()함수를 이용하여 1부터 입력 받은 숫자까지 
짝수만 더하는 프로그램을 작성 한다.
입력 값 : 5
결과>> 
짝수 : 2 4
결과 : 6*/


public class Test02 {

	public static void main(String[] args) {
		
		
		//값 하나만 입력
		if(args.length==0||args[0].isEmpty()||args.length>=2) {
			System.out.println("값을 다시 입력해주세요");
			return;
		}else {
			int data = Integer.parseInt(args[0]);
			
			if(data<=10 && data>=5) {
				Calc.calculate(data);		//5~10범위 값이 들어갔을때만 메소드 호출
			}else {
				System.out.println("입력값의 범위는 5~10 입니다.");
			}
		}
	}

}

class Calc{
	
	static int calculate(int data) {
		
		int total = 0;
		
		System.out.print("짝수: ");
		
		for(int i=1; i<=data; i++) {
			if(i%2==0) {
				total += i;
				System.out.print(i+" ");
			}
		}
		
		System.out.println("\n결과: "+total);
		return total;
	}
	
}
