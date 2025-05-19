package workshop.work15;

public class RunnableTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable 실행 중");
	}
	
}
