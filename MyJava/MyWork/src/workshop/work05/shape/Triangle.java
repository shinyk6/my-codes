package workshop.work05.shape;

public class Triangle extends Shape implements Resize {

	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Triangle(int width, int height, String color) {
		super(width, height, color);
		
	}
	
	
	
	@Override
	public void setResize(int size) {
 		this.setHeight(this.getHeight()+size);
	}
	
	@Override
	public double getArea() {
		
		return (this.getWidth()*this.getHeight()) / 2.0;
	}




	
	
	

}
