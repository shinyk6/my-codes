package com.sec16;

// [추가 예제] ThreadGroup 사용 예제 _계층 구조
public class g_ThreadGroupDemo {
    public static void main(String[] args) {
        // 1. 스레드 그룹 생성	_ 부모 스레드 그룹 생성
        ThreadGroup parent_group = new ThreadGroup("ParentGroup");
        
        //자식 스레드
        ThreadGroup child_group = new ThreadGroup("ChildGroup");

        // 2. Runnable 정의
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            ThreadGroup tg = Thread.currentThread().getThreadGroup();
            for (int i = 0; i < 2; i++) {
                System.out.println("[" + tg.getName() + "] " + name + " - " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 3. 그룹에 속한 스레드 생성
        Thread t1 = new Thread(parent_group, task, "ParentGroup-A");
        Thread t2 = new Thread(child_group, task, "ChildGroup-B");

        // 4. 실행
        t1.start();
        t2.start();

        // 5. 그룹 정보 출력
        System.out.println("부모 활성 스레드 수: " + parent_group.activeCount());
        parent_group.list();
        
        //자식 그룹의 부모 그룹도 확인 해보자.
        System.out.println("자식 활성 스레드 수: " + child_group.activeCount() + "---->" + child_group.getParent().getName()); //child_group이 어디 속하는지 확인
        child_group.list();
    }
}