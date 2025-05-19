package workshop.work07.test01;

public class ArrayTest {

	public static void main(String[] args) {
		int [][] array = {
				{12, 41, 36, 56, 21},
				{82, 10, 12, 61, 45},
				{14, 16, 18, 78, 65},
				{45, 26, 72, 23, 34}
			};
			
			int row = array.length;
			int column = array[0].length;
			int arrayLength = row * column;
			int total = 0;
			
			// 2차원 배열 순회
			for (int[] rows : array) {
				for (int element : rows) {
					total += element;
				} 
			}
			
			
			double avg = (double)total / arrayLength;
			

			System.out.println("합계 : " + (double)total);
			System.out.println("평균 : " + avg);

	}

}
