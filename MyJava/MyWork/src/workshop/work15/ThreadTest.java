package workshop.work15;


class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("스레드 실행중");
		
	}
}


public class ThreadTest {

	public static void main(String[] args) {
		
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 종료");
	}

}


