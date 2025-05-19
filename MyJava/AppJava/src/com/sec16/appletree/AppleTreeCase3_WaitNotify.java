package com.sec16.appletree;

//case 2 : Object클래스가 가지고 있는 메소드 wait() / notifyAll() 사용 -> synchronized 블록 안에서만 호출 가능
// ThreadPool을 자체적으로 만들어서 대기했다가 다시 실행하도록 함.
// this 도 wait()과 notify()사용 가능->this가 Object의 자식이기에
/*
 * 			synchronized(obj){
 * 				while(!조건){
 * 					obj.wait(); //스레드 일시 정지 +  락 반환
 * 				}
 * 				// 조건이 만족된 후 수행 할 작업 내용
 * 			}
 * 		
 * 
 */
public class AppleTreeCase3_WaitNotify extends AppleTreeCompetition {
    private final Object lock = new Object(); //Object객체 생성

    protected boolean pickApple(String who) {
        synchronized (lock) {
            while (apples <= 0) { //사과가 있는지 확인
                try {
                    lock.wait(); //1,2,3,4가 접속했을 때 1번이 먼저 작업하면 2,3,4번은 스레드풀에 대기하게 됨, 배열처럼 index를 가짐
                    			//대기풀에서 대기번호들고 기다려
                    return false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            apples--;
            if (who.equals("Cat")) catCount++;
            else dogCount++;
            System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            lock.notifyAll(); //All이면 나머지 스레드들이 다 풀림
            				  //대기풀에서 번호 받은 스레드는 다 복귀해
            
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}