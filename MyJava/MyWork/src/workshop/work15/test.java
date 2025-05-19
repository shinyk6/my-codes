package workshop.work15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class test extends Thread {
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{
			for(int i=0; i<5; i++) {
				System.out.println("스레드연습 :" + i);
			}
		});
		
		t1.start();
	
		
		
	}
	

}
