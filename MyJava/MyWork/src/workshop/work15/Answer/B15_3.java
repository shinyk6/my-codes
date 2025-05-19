package workshop.work15.Answer;

import java.util.concurrent.locks.*;



class BoundedBuffer {
	
	   private final Lock lock = new ReentrantLock();
	   private final Condition notFull  = lock.newCondition(); 
	   private final Condition notEmpty = lock.newCondition(); 

	   private final Object[] items = new Object[100];
	   private int putptr, takeptr, count;

	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length) {		//put() -> await()는 버퍼가 가득 찼을 때 대기 (조건이 만족했을 때 대기)
	    	 System.out.println("버퍼 가득 참 - 생산자 대기");
	         notFull.await();
	       }
	       items[putptr] = x;
	       putptr = (putptr +1 ) % items.length;
	       count++;
	       System.out.printf("생산 -> [%s] (버퍼 : %d/%d) \n", x, count, items.length);
	       

	       notEmpty.signal(); // 상대 조건이 만족했으니 깨우기 (대기 해제)
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {										
	       while (count == 0) {						//take() -> await()는 버퍼가 비어있을 때 대기
	    	   System.out.println("버퍼 비어 있음 - 소비자 대기");
	         notEmpty.await();
	       }
	       Object x = items[takeptr]; 
	       takeptr = (takeptr +1 )%items.length;
	       count--;
	       System.out.printf("소비 <- [%s] (버퍼 : %d/%d) \n", x, count, items.length);
	      
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   }
	 }
	 


public class B15_3 {

	public static void main(String[] args) {
		
		BoundedBuffer buffer = new BoundedBuffer();
		//생산자 스레드
		Thread producer = new Thread(()->{ 
			int item = 1;
			try {
				while(true) {
					buffer.put(item++);
					Thread.sleep(500);
				}
			}catch(InterruptedException ie) {
				Thread.currentThread().interrupt();
				System.out.println("생산자 인터럽트 종료");
			}
		}, "producer");
		
		
		//소비자 스레드
		Thread consumer = new Thread(()->{ 
			try {
				while(true) {
					buffer.take();
					Thread.sleep(1000);
				}
			}catch(InterruptedException ie) {
				Thread.currentThread().interrupt();
				System.out.println("소비자 인터럽트 종료");
			}
		}, "consumer");
		producer.start();
		consumer.start();
		
	}

}
