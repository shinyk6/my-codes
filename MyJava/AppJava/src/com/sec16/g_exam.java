package com.sec16;

public class g_exam {

	public static void main(String[] args) throws InterruptedException{
		testBuilder(Thread.ofVirtual().name("my-", 0));
	}
	
		public static void testBuilder (Thread.Builder builder) throws InterruptedException {
		long start = System.currentTimeMillis();
		switch (builder) {
		    case Thread.Builder.OfVirtual v -> {
		        Thread thread = v.start(() -> { 	
		            System.out.println("실행 중: " + Thread.currentThread());
		            try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
		        });
		        thread.sleep(1000);		
		    }
		default -> throw new IllegalArgumentException("Unexpected value: " + builder);
		}
    	long duration = System.currentTimeMillis() -start; //시간 계산
    	System.out.println("실행 시간" + duration + "ms");
	}


}
