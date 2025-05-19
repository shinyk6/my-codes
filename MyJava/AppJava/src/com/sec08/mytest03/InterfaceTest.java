package com.sec08.mytest03;

import java.util.List;

interface IShape {
	static final String COLOR = "red"; // final 명시적 선언

	void draw();
}

class Circle implements IShape {
	private final String type;

	public Circle(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		System.out.println(COLOR + "의 " + type + "을 그립니다.");
	}
}

class Rect implements IShape {
	private final String type;

	public Rect(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		System.out.println(COLOR + "의 " + type + "을 그립니다.");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		IShape[] is = new IShape[2]; //생성자를 호출한게 아니라 배열의 주소번지 받을 방 2개를 자유영역공간에 할당 한 것 그리고 초기값을 null로 채움
		is[0] = new Circle("원");
		is[1] = new Rect("사각형");

		for (IShape r : is) {
			r.draw();
		}
	}
}
