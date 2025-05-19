package workshop.work15;


class SleepThread extends Thread{

	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("출력 : " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}


public class SleepTest {

	public static void main(String[] args) {
		
		SleepThread st = new SleepThread();
		st.start();

	}

}
