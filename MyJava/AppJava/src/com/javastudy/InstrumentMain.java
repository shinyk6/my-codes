package com.javastudy;

public class InstrumentMain {

	public static void main(String[] args) {

		Instrument instrument1 = new Guitar("기타", 200000, 6);
		Instrument instrument2 = new Piano("피아노", 1000000, 88);
		instrument1.play();
		instrument2.play();
		

	}

}
