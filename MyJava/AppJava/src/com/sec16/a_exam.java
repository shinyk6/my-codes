package com.sec16;

//Runnable 인터페이스를 이용해서 야옹이, 멍멍이 2개의 스레드를 생성해서 실행해보자!!!
// -Runnable 인터페이스를 구현한 클래스를 Thread로 만들어서 start() 를 해야한다.
public class a_exam implements Runnable {

	
	@Override
	public void run() {
		for( int i=0; i<=10; i++) {
			
			System.out.println("나 스레드야!!! 💖");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("===========main start===========");
		//new Thread(new a_exam()).start(); //start()를 실행하면 run()이 호출됨

		//new a_exam().run(); // runnable인터페이스를 구현한 클래스를
							  //Thread로 만들어서 start() 를 해야한다.->메소드 단위로 실행 (밑 코드처럼)
	
		
		
		Thread t1 = new Thread(new a_exam(), "야옹이");
		Thread t2 = new Thread(new a_exam(), "멍멍이");
		t1.start(); //메소드 단위 실행 = run()
		t2.start();
		
		//System.out.println("===========main end============"); //join을 만나지 않으면 main스레드가 먼저 실행됨
		
		
		try {
			t1.join(); // t1이 종료 될 때까지 main스레드를 대기
			t2.join(); // t2가 종료 될 때까지 main스레드를 대기
		}catch(InterruptedException e) {
			System.out.println(e); //e.getStackTrace();
		}
		
		System.out.println("===========main end============");
	
		
	}



}
