package workshop.work07.test05;

import java.util.HashMap;
import java.util.Random;

public class HashMapTest {

	public static void main(String[] args) {
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
		double sum=0.0;
		
		Random rand = new Random();
		
		for (int i = 1; i <= 10; i++) {
			map.put(i, rand.nextInt(100) + 1);		
		}
	
		for (int value : map.values()) {
			System.out.print(value + " ");	
			sum += value;			
		}
		System.out.println();

		

		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum / map.size()));

	}

}
