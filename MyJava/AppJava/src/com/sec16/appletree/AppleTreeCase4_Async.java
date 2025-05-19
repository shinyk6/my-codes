package com.sec16.appletree;

import java.util.concurrent.CompletableFuture;


//case 3 : CompletableFuture 사용 -> 비동기 병렬처리용
/*
 *  [Future와 Callable 결과 반환 -> Future, Callable<T>, get() ->리턴값이 있는 비동기] 의 개선된 확장형
 *		Future의 단점 : 예외처리 어려움 / get() 결과를 기다릴 때 블로킹 / get다음에 후작업을 할 수 없음-> 결과를 불러오면 바로 끝나버림  (웬만하면 잘 사용하지 않음)
 *	
 *	CompletableFuture.supplyAsync().thenApply().thenAccept(System.out::println)
 *						비동기시작	   .    연산    .   출력
 *	동기화 : 작업이 끝날 때 까지 기다렸다가 다음 작업으로 넘어감 -> ex)전화 받을 때까지 전화걸기
 *	비동기화 : 작업을 [요청]한 다음, 결과를 기다리지 않고 바로 다음 작업으로 넘어감 -> ex)문자메세지
 */
public class AppleTreeCase4_Async extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
    	
        CompletableFuture.runAsync(() -> { // runAsync | lock, unlock 제공
            synchronized (this) {
                if (apples <= 0) return;
                apples--;
                if (who.equals("Cat")) catCount++;
                else dogCount++;
                System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            }
        });
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}