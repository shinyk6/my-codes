package com.sec16;

//Theard 클래스를 이용해서 야옹이, 멍멍이 2개의 스레드를 생성해서 실행해보자!!!
public class a_exam02 extends Thread {
	
	public a_exam02(String thread_name) {
		super (thread_name); //Thread(String name)
	}

	
	@Override
	public void run() {
		for (int i=1; i<=50; i++) {
			System.out.println("나 스레드야!!! 💖 => : " + getName() + i); 
		}
	}
	
	public static void main(String[] args) { //메인스레드  Main Thread (jvm은 일반 스레드가 완료될 때 까지 종료하지 않는다.)
		//new Thread(new a_exam()).start(); //start()를 실행하면 run()이 호출됨
		
		a_exam02 t1 = new a_exam02("야옹이"); // 데몬 스레드 Deamon Thread
		a_exam02 t2 = new a_exam02("멍멍이");
		t1.setPriority(9); //야옹이에게 우선순위를 제일 높게 설정한다고 하더라도 항상 먼저 실행됨을 보장할 수 없음 //우선순위 정하기
		System.out.println(t1.getPriority()); //우선순위 불러오기
		System.out.println(t2.getPriority());		
		
		t1.start();
		t2.start();
	}



}
