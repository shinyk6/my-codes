package com.exam;

// 의존성 주입이 안된 상태
// 강한 결합도 _ has a 관계에서 행동패턴을 기준으로 객체를 직접 구현한 상태
// 의존성이 높음 _ ComputerMain이 has ~ a 관계의 클래스들을 관리
class Keyboard {
    public void type() {
        System.out.println("키보드를 입력합니다.");
    }
}

class Monitor {
    public void display() {
        System.out.println("화면에 표시합니다.");
    }
}

public class ComputerMain { //has a 관계
    private Keyboard keyboard;
    private Monitor monitor;

    public ComputerMain() {
        // ComputerMain 클래스 내부에서 직접 Keyboard와 Monitor 객체를 생성 (결합도 높음 = 강한결합)
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
    }

    public void start() {
        keyboard.type();
        monitor.display();
        System.out.println("컴퓨터가 시작되었습니다.");
    }

    public static void main(String[] args) {
        ComputerMain computer = new ComputerMain();
        computer.start();
    }
}