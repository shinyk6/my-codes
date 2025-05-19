package com.sec16.appletree;

// case 1 : synchronized 를 사용해 임계영역(Critical Section) 지정해서  lock을 걸음
// 임계 영역 : 두 개 이상의 스레드가 동시에 접근하면 안되는 코드 블록
public class AppleTreeCase2 extends AppleTreeCompetition {
    protected synchronized boolean pickApple(String who) {
        if (apples <= 0) return false;
        apples--;
        if (who.equals("Cat")) catCount++;
        else dogCount++;
        System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}