package com.structural;


// Adapter : 기존 시스템을 현재 시스템 객체로 만들어서 사용하겠다!! = 인터페이스 호환성
class OldScoreSystem {
	public int getSum() { return 270; }
	public double getAvg() { return 90.0;}
}


//Adapter
class ScoreAdapter extends Score{
	private OldScoreSystem oldSystem;
	
	public ScoreAdapter(OldScoreSystem oldSystem) {
		super(0, 0, 0);
	}

	@Override
	public int getTotal() {

		return oldSystem.getSum();
	}

	@Override
	public double getAverage() {

		return oldSystem.getAvg();
	}
	
	 
	
}
