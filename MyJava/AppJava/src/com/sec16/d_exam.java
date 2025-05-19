package com.sec16;

public class d_exam {

	public static void main(String[] args) {
		
		System.out.println("Thread started. State: " + Thread.currentThread().getState()); //현재 main Thread 상태 : Runnable상태 
		System.out.println(Thread.currentThread().getId()); //스레드 id
		System.out.println(Thread.currentThread().getName()); //스레드명
		System.out.println(Thread.currentThread().getPriority()); //스레드 우선순위
		System.out.println(Thread.currentThread().isDaemon()); //데몬스레드인지 아닌지
	}

}
