package workshop.work02;


class Tv {
	
	public Tv() {}
	public Tv(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
		
	
	private String name;
	private int price;
	private String description;

	public void setName(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(int price) {
		this.price = price;	
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;	
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return String.format("Tv [getName()=%s, getPrice()=%s, getDescription()=%s]", getName(), getPrice(),
				getDescription());
	}

	
	//출력 메소드
	public void show() {
		System.out.printf("%8s %10d %10s\n", this.name, this.price, this.description);
	}
}



public class TvTest {

	public static void main(String[] args) {
		
		Tv tv= new Tv();

		tv.setName("INFINIA");
		tv.setPrice(15000000);
		tv.setDescription("LED TV");
		tv.show();

		tv.setName("XCANVAS");
		tv.setPrice(1000000);
		tv.setDescription("LCD TV");
		tv.show();	
		
		tv.setName("CINEMA");
		tv.setPrice(2000000);
		tv.setDescription("3D TV");
		tv.show();	
		
	}	
}