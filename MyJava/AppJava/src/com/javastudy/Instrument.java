package com.javastudy;

public class Instrument {
	
	String name;
	int price;
	
	
	
	
	public Instrument(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	void play() {
		System.out.println(name+"을(를) 연주합니다.");
	}
}


class Guitar extends Instrument{
	
	
	public Guitar(String name, int price, int numStrings) {
		super(name, price);
		this.numStrings = numStrings;
	}

	int numStrings;
	
	@Override
	void play() {
		System.out.println(name+"을(를) 연주합니다.");
	}
	
	int getNumStrings() {
		return numStrings;
	}
}


class Piano extends Instrument{
	int numkeys;
	
	
	public Piano(String name, int price, int numkeys) {
		super(name, price);
		this.numkeys = numkeys;
	}

	@Override
	void play() {
		System.out.println(name+"을(를) 연주합니다.");
	}

	int getNumkeys() {
		return numkeys;
	}
	
}

