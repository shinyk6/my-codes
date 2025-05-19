package workshop.work15;


class Counter{

	private int value;
	
	void increment() {
		
	}
	
	public synchronized int getCount() {
		return value; 
	}

}

public class SyncTest {

	public static void main(String[] args) {
		  Counter counter = new Counter();  
		  
	        Runnable task = () -> { 
	            for (int i = 0; i < 500; i++) { 
	                 counter.increment(); 

	            } 
	        };
	        Thread t1 = new Thread(task); 
	        Thread t2 = new Thread(task);
	        
	        t1.start(); 
	        t2.start(); 
	        try {
				t1.join();
				t2.join(); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        System.out.println("최종 카운터 값 : " + counter.getCount());
	       

	}

}
