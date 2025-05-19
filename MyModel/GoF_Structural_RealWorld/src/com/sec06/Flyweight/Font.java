package com.sec06.Flyweight
;
//유사한 객체를 효율적으로 관리하자.

public class Font {
	private final String fontData; //또 다른 이너 객체가 숨어있다.

	public Font(String fontData) {
		this.fontData = fontData;
	}

	public void use() {
		System.out.println("Using font: " + fontData);
	}
}
