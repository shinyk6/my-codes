package com.sec02.Command;

// 커맨드 패턴 : 실행요청을 캡슐화 한다 -> 결합도가 낮아진다. receiver와 invoker 분리
interface Command {
    void execute(); //실행 요청을 추상화
}

// 실행 기능을 수행하는 객체 -> 명령이 전달되면 turnOn() 실행함
class Light { 
    void turnOn() { System.out.println("Light On"); }
}

// Command 구현체
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); } // 명령 객체가 리시버의 메소드를 위임 실행
}

public class TestCommand {
    public static void main(String[] args) {
    	//리시버 객체를 직접 실행하지 않고 구현체를 통해 실행한다.
        Light light = new Light();
        Command cmd = new LightOnCommand(light);
        cmd.execute();
    }
}
