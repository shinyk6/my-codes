package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
// 2가지 builder 테스트를 해보자. 스레드 생성 -> 실행 -> 종료 / 조인 구현 / 실행시간 체크
// 실행시간 체크 -> 0.초 동안 sleep을 두고 작업 시뮬레이션을 해보자.
public class g_VirtualThread3 {
    public static void main(String[] args) throws InterruptedException {
    	
    	testBuilder(Thread.ofVirtual().name("vt-", 1)); 
    	testBuilder(Thread.ofPlatform().name("pf-", 1));   	
    }
    	
    public static void testBuilder (Thread.Builder builder) {
    	System.out.println("\n [test] 실행 대상 " + builder.getClass().getSimpleName()); // 해당 객체값이 들어감
    	long start = System.currentTimeMillis(); //실행 시간 체크
    	
    	switch(builder){
    	case Thread.Builder.OfVirtual v -> { // jdk21부터는 preview 기능 없이 작업 가능하다
				System.out.println("가상 스레드 생성했다.");
				Thread thread = v.start(()->{ //run()메소드를 start
					System.out.println("실행중 (Virtual) " + Thread.currentThread()); 
					try {
							Thread.sleep(500);
					}catch(InterruptedException i){
						i.printStackTrace();
					}
					
				}); 
				myjoin(thread);
    				
    	}
    	case Thread.Builder.OfPlatform p -> {
				System.out.println("플랫폼 스레드 생성했다.");
				Thread thread =p.start(()->{ //run()메소드를 start
					System.out.println("실행중 (Platform) " + Thread.currentThread());
					try {
							Thread.sleep(500);
					}catch(InterruptedException i){
						i.printStackTrace();
					}
		
				}); 
				myjoin(thread);
    	}
    	}
    	long duration = System.currentTimeMillis() -start; //시간 계산
    	System.out.println("실행 시간" + duration + "ms");
    	
    }


	private static void myjoin(Thread thread) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
    	

}
