package com.sec09.Strategy;

// 전략 패턴 : 알고리즘을 캡슐화 _ 정렬 알고리즘, 압출 알고리즘, 결제방식(카드, 계좌이체...)등
// redirect:https://myhost.com/some/arbitrary/path        redirect - ViewResolver객체
interface Strategy {
    int operate(int a, int b);
}

class AddStrategy implements Strategy {
    public int operate(int a, int b) { return a + b; }
}

// web으로 spring mvc로 가면 캡슐화가 돼서 .xml 파일로 설정된다. 
class Context {
    private Strategy strategy;
    public Context(Strategy strategy) { this.strategy = strategy; }
    public int execute(int a, int b) { return strategy.operate(a, b); }
}

public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("Result: " + context.execute(3, 4));
    }
}
