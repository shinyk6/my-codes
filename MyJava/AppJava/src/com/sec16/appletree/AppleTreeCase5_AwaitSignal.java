package com.sec16.appletree;

import java.util.concurrent.locks.*;

// 비동기화 lock을 명시한 상황
public class AppleTreeCase5_AwaitSignal extends AppleTreeCompetition {
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    protected boolean pickApple(String who) {
        lock.lock();
        try {
            while (apples <= 0) {
                try {
                    notEmpty.await(); //Asynch의 약자 - 비동기 대기
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
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}