package com.sec05.Mediator;

// 중재 클래스
class Mediator {
    public void notify(String msg) {
        System.out.println("Mediator relays: " + msg);
    }
}

// 액션 클래스
class Component {
    private Mediator mediator;
    public Component(Mediator mediator) { this.mediator = mediator; }
    public void action() { mediator.notify("Action triggered"); } // 중재자에게만 메세지를 전달하겠다.
}

public class TestMediator {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Component comp = new Component(mediator);
        comp.action();
    }
}

