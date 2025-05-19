package workshop.work11;

public class Vehicle {

	private int maxWeight = 1000; //최대 적재량
	private double oilTanckSize = 100;  //오일탱크크기
	private double efficiency = 5; //연비
	
	
	public Vehicle() {
		super();
	}
	public Vehicle(int maxWeight, double oilTanckSize, double efficiency) {
		super();
		this.maxWeight = maxWeight; //최대 적재량
		this.oilTanckSize = oilTanckSize; //오일탱크 크기
		this.efficiency = efficiency; // 연비
	}
	
	
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public double getOilTanckSize() {
		return oilTanckSize;
	}
	public void setOilTanckSize(double oilTanckSize) {
		this.oilTanckSize = oilTanckSize;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	@Override
	public String toString() { //문자열로 리턴
		return String.format("%d, %f", maxWeight, oilTanckSize);
	}
	
	
	
}
