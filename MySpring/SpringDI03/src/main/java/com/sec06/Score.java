package com.sec06;

import org.springframework.stereotype.Component;

@Component("score")      //getBean에 score를 자동으로 등록  //나 score라는 Bean이야
public class Score {
	public void printScore() {
		System.out.println("Score component!!!!");
	}
}
