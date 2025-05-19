package workshop.work04;

public class Test02 {

	public static void main(String[] args) {
	/*
		int total = 0;
		
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; 
		
		for(int i=0; i<arr.length; i++) {
		
			if(i%2 !=0) {
				total += arr[i];
			}
		}
		
		System.out.println("sum = "+ total);

	}
*/
	
		int total = 0;
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; 
		for(int i=1; i<arr.length; i+=2) {
			total += arr[i];
		}
		System.out.println("sum = " +total);
		
	
	}

}
