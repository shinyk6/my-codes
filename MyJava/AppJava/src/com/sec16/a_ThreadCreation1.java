package com.sec16;

// [4. 스레드 생성 방법]
// case01: Thread 상속 - run() 오버라이드, start()로 실행

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": " + i); //현재 스레드이름으로 시작 (이름을 따로 지정하지않으면 Thread-0 이런식으로 알아서 생성해줌)
            try {
                Thread.sleep(500); //static method  sleep : 시스템 중단시킴 -> 하나가 출력하는 시간에 또 다른 하나가 행보를 못하도록 막음
            } catch (InterruptedException e) { // InterruptedException : 무언가의 경우에 따라 프로세스가 중단되는 경우
                Thread.currentThread().interrupt(); // static method
            }
        }
    }
}

public class a_ThreadCreation1 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}