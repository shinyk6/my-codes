package workshop.work05.shape;

public abstract class Shape {
	private int width; //가로길이
	private int height; //세로길이
	String colors; //색상
	
	
	public Shape() {
		super();
	}


	public Shape(int width, int height, String colors) {
		super();
		this.width = width;
		this.height = height;
		this.colors = colors;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getColors() {
		return colors;
	}


	public void setColors(String colors) {
		this.colors = colors;
	}
	
	public abstract double getArea();
	
	
	
}
