package workshop.work04;

/*
 * 
 *  다음 배열의 합과 평균을 구하는 프로그램을 작성 하시오. 
	int[] arr = {10, 20, 30, 40, 50}; 
 * 
 */
public class Test01 {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int total = 0;
		int avg = 0;
		
		for(int res:arr) {
			total += res;
		}
		
		avg = total/arr.length;
		
		System.out.println("sum = " + total);
		System.out.println("avg = " + avg);
		

	}

}
