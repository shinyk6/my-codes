package workshop.work11;

public class Car extends Vehicle {

	private double restOil;
	private int curWeight;
	
	
	public Car() {
		super();
	}
	public Car(int maxWeight, double oilTanckSize, double efficiency) {
		super(maxWeight, oilTanckSize, efficiency);
	}
	
	
	void addOil(int oil){ //현재 오일량에 추가한다. 단, 오일탱크 크기를 넘어서면 안됨
		if((restOil+=oil)<curWeight) {
			restOil+=oil;
		}else {
			System.out.println("오일탱크크기 초과!!!");
		}
	}
	
	void moving(int distance) { //소모되는 오일량 = 주행거리/연비
		this.restOil -= (distance/super.getEfficiency());
	}
	
	void addWeight(int weight) { //현재 적재량에 물건을 추가한다. 단, 최대적재중량을 넘어서면 안된다. 
		if((this.curWeight += weight)<super.getMaxWeight()){
			this.curWeight += weight;
		}else {
			System.out.println("최대적재중량 초과!!");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%f, %d", restOil, curWeight);
	}
	public double getRestOil() {
		return restOil;
	}
	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}
	public int getCurWeight() {
		return curWeight;
	}
	public void setCurWeight(int curWeight) {
		this.curWeight = curWeight;
	}
	
	
	
	
}
