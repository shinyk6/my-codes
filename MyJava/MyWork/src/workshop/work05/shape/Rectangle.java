package workshop.work05.shape;


public class Rectangle extends Shape implements Resize {
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height, String color) {
		super(width, height, color);
	}

	@Override
	public void setResize(int size) {
		this.setWidth(this.getWidth()+size);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.getWidth()*this.getHeight();
	}

}
