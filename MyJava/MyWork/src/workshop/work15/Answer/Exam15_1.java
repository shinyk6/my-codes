package workshop.work15.Answer;

//case01 : Thread상속하는 방법 -> 스레드 클래스의 멤버를 상속 시 자유롭게 호출
//번외편 1. 스레드의 이름을 리턴받자
// 	   2. Thread(String name)를 활용해서 스레드 이름을 명시하자.
//	   3. 람다로 생성자에게 이름 주자.
//     4. 생성 후 setName()을 사용해보자.
//     5. 가상 스레드를 생성해서 이름을 지정해보자.
// 결과 순서를 맞추고 싶으면 - join 사용
//
class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name); //Thread(String name) 전달 됨
	}
	
    public void run() {
        System.out.println("스레드 실행 중");
    }
}

public class Exam15_1 {
	
	
	// 3. 람다로 스레드 생성하면서 이름을 전달해보자.


    public static void main(String[] args) {
    	
    	Thread t = new Thread(()->{
			System.out.println("hello thread " + Thread.currentThread().getName()); 
		},"my-work01" //스레드 이름   //Thread(Runnable task, String name) 생성자를 사용한 것임
		);

    	t.start();
    	
    	//4. 생성 후 setName()을 사용해보자.
    	Thread t4 = new Thread(()->{
			System.out.println("hello thread " + Thread.currentThread().getName()); 
		});
    	t4.setName("Thread 04"); // 스레드 이름
    	t4.start();
    	

    	
		/*
		 * OfVirtual java.lang.Thread.Builder.OfVirtual.name ( String prefix, long start ) 접두어, 넘버링
		 */ //Thread.builder.Ofvirtual  -> https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html#method-summary api참고!!!!!!
    	//5. 가상 스레드를 생성해서 이름을 지정해보자. 
    	Thread t05 = Thread.ofVirtual().name("vt-", 1).unstarted(()->{  // 변수타입은 마지막에 리턴하는 타입을 주어야함.
    		System.out.println("hello thread05 " + Thread.currentThread().getName()); 
    	} );  //runnable객체를 매개인자로 받음 - runnable을 재정의
    	t05.start();
    	
    	// 생성 후 실행 (생성 후 원할 때 start) B15_1.java
    	Thread t06 = Thread.ofPlatform().name("os-", 1).unstarted(()->{  // 변수타입은 마지막에 리턴하는 타입을 주어야함.
    		System.out.println("hello thread06 " + Thread.currentThread().getName()); 
    	} );  //runnable객체를 매개인자로 받음 - runnable을 재정의
    	t06.start();  	
    	
    	// 즉시 실행
    	Thread t07 = Thread.ofPlatform().name("os-", 1).start(()->{  // 변수타입은 마지막에 리턴하는 타입을 주어야함.
    		System.out.println("hello thread06 " + Thread.currentThread().getName()); 
    	} );  //runnable객체를 매개인자로 받음 - runnable을 재정의
    	
    	
    	//case 01
        MyThread t1 = new MyThread("멍멍이");
        MyThread t2 = new MyThread("야옹이");
        t1.start();
        t2.start();
        try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(t1.getName()+":"+t2.getName()); //번외 1 : 스레드의 이름 리턴
        System.out.println("main 종료");
    }
}