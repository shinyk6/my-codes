package com.sec16;

public class AppleTreeCompetition {
	  private static int apples = 100;
	    private static int catCount = 0;
	    private static int dogCount = 0;

	    public static void main(String[] args) throws InterruptedException {
	        Runnable catTask = () -> {
	            while (true) {
	                if (!pickApple("🐱 야옹이")) break;
	            }
	        };

	        Runnable dogTask = () -> {
	            while (true) {
	                if (!pickApple("🐶 멍멍이")) break;
	            }
	        };

	        Thread t1 = new Thread(catTask);   // 🐱 야옹이 스레드 시작 catTask
	        Thread t2 = new Thread(dogTask);   // 🐶 멍멍이 스레드 시작 dogTask

	        t1.start();
	        t2.start();

	        t1.join();  // 스레드 종료 대기 join
	        t2.join(); 	

	        System.out.println("🍎 수확 종료!");
	        System.out.println("🐱 야옹이: " + catCount + "개"); 
	        System.out.println("🐶 멍멍이: " + dogCount + "개");
	    }

	    private static synchronized boolean pickApple(String who) {
	        if (apples <= 0) return false;

	        apples--;
	        if (who.contains("야옹이")) catCount++;
	        else dogCount++;

	        System.out.println(who + " 가 사과를 땄습니다! 🍎 남은 사과: " + apples);
	        try {
	            Thread.sleep((int)(Math.random() * 50));
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        return true;
	    }
}
