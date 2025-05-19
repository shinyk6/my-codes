package workshop.work04;

public class Test03 {

	public static void main(String[] args) {
		
		int[][] arr2 = { 
				{ 5, 5, 5, 5, 5}, 
				{10,10,10,10,10}, 
				{20,20,20,20,20}, 
				{30,30,30,30,30} }; 
		
		int total = 0; //총합
		int avg = 0; //평균
		
		
		//출력 
		/*
		for(int[] row: arr2) {
			for(int column: row) {
				System.out.printf("%5d", column);
			}
			System.out.println();
		}
		*/
		
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("%5d", arr2[i][j]);
			}
			System.out.println();
		}
		
		
		
		//행 합 
		
		
		

	}

}
