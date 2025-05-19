package workshop.work15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualTest {

	public static void main(String[] args) {
	
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		for (int i = 0; i < 5; i++) {
			int taskId = i;
			executor.submit(() -> {
			try {
						Thread.sleep(500);
						System.out.println("가상 스레드" + taskId + "번 실행중");
			} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
			}
	});
	}
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 종료");
		
	}

}
