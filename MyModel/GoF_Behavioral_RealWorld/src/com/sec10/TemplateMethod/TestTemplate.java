package com.sec10.TemplateMethod;

// 정의는 선조가 구현은 후손이 한다. spring jdbcTemplate  (자바코어, 서블릿은 만들어야하지만 스프링은 만들어져있음)

abstract class Meal {
	
	//템플릿 메소드 : 고정된 순서로 알고리듬을 실행하도록 선언
    public final void prepareMeal() {
        prepareIngredients();
        cook();
        serve();
    }
    abstract void prepareIngredients();
    abstract void cook();
    void serve() { System.out.println("Serving meal"); }
}

class Pasta extends Meal {
    void prepareIngredients() { System.out.println("Preparing pasta ingredients"); }
    void cook() { System.out.println("Cooking pasta"); }
}

public class TestTemplate {
    public static void main(String[] args) {
        Meal meal = new Pasta();
        meal.prepareMeal();
    }
}
