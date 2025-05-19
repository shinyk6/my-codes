package com.javastudy;

public class ThreadTest02 {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread("Thread 1");
		MyThread t2 = new MyThread("Thread 2");
		
		t1.start();
		t2.start();
	}
	
	

}

class MyThread extends Thread{
	String message;
	public MyThread(String message) {
		this.message = message;
	}

	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName());
	
	}
		
}

