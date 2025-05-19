package com.sec16;

public class d_ThreadState {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> { //functional interface run메소드
			System.out.println("Thread started. State: " + Thread.currentThread().getState());
			try {
				Thread.sleep(1000); // TIMED_WAITING 상태 -> 지정된 스레드 시간동안 대기하는 스레드
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		System.out.println("Before start: " + t.getState()); // NEW
		t.setName("DemoThread");
		t.start();

		// 실행 중 상태 확인
		while (t.isAlive()) {
			System.out.println(t.getName() + " is alive. State: " + t.getState());
			Thread.sleep(200);
		}

		System.out.println("After finish: 스레드 실행 완료 " + t.getState()); // TERMINATED
		System.out.println("Main Thread: " + Thread.currentThread().getName());
	}

}
