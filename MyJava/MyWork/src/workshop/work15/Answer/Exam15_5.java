package workshop.work15.Answer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam15_5 {
	public static void main(String[] args) throws InterruptedException {
		// ① Virtual Thread용 Executor 생성
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

		// ② 5개의 Virtual Thread 제출
		for (int i = 1; i <= 5; i++) {
			int num = i;
			executor.submit(() -> { //Runnable task
				try {
					// ③ 스레드 시작 전 0.5초 대기
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				// ④ 대기 후 메시지 출력
				System.out.println("가상 스레드 " + num + "번 실행 중");
			});
		}

		// ⑤ Executor 종료 요청
		executor.shutdown();

		// ⑥ 모든 작업이 종료될 때까지 대기   isTerminated() -> ExecutorService 스레드풀에 전체 작업이 종료 되었는지 확인하는 메소드
		while (!executor.isTerminated()) { 
			Thread.sleep(100);
		}
		
		/*
		 * shutdown() : 새로운 스레드 상관없이 기존 작업을 마무리 Executor 종료요청
		 * shutdownNow() : 지금 모든 작업을 중단하라는 뜻
		 * awaitTermination(long timeout, TimeUnit unit) : 일정 시간 대기하면서 종료를 기다림
		 * isTerminated() : 위 두개 메소드가 호출되면 모든 작업이 끝났는지 true로 확인
		 * 
		 * 
		 *  !!shutdown() 호출한다고 해서 작업이 끝난것은 아님. -> 그렇기에 isTerminated()를 호출하여 확인해야함.
		 */

		// ⑦ 모든 가상 스레드 종료 후 메시지 출력
		System.out.println("main 종료");

	}

}
