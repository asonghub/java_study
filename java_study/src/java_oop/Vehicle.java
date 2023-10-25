package java_oop;

public class Vehicle {
	private int wheels ;
	private int price;
	private String type;
	
	public Vehicle(int wheels, int price, String type) {
		this.wheels = wheels;
		this.price = price;
		this.type = type;
	}
	
	
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public String introduceVehicle() {
		return type +"은 "+ "바퀴가 " + wheels +"개, 가격은 " + price;
	}
}
