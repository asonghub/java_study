package second_java;

public class Rectangle {
	
	private int width;
	private int height;
	
	private static int COUNT =0;
	
	//static 메소드
	public static int getCount() {
		return COUNT;
	}
	
	public Rectangle(int width) {
		if(width >0 ) {
		this.width = width;
		COUNT++;
		}
	}
	
	public int area() {
		return width * height;
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
	
	

}
