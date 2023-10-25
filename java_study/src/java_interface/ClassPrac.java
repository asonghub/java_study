package java_interface;

abstract class Vehicle{
	private String name;
	private int maxSpeed;
	
	public Vehicle(String name, int maxSpeed) {
		   setName(name);
		   setMaxSpeed(maxSpeed);
	}
	
	abstract public void move();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}

interface Flyable2{
	void fly();
}

class Car2 extends Vehicle{
	Car2(String n, int s){
		super(n, s);
	}

	@Override
	public void move() {
		System.out.println("도로를 따라 이동 중");	
	}
}

class Airplane2 extends Vehicle implements Flyable2{

	public Airplane2(String n, int s) {
		super(n, s);
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("하늘을 날아가는 중");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("고도 10,000피트에서 비행 중");
	}
	
}
public class ClassPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vehicle[] vehicles = {new Car2("붕붕이",200), new Airplane2("쌩쌩이", 1000)};
		for(Vehicle v: vehicles) {
			System.out.println(v.getName() + "의 속도는 "+ v.getMaxSpeed());
			v.move();
			//instanceof: 객체가 특정 클래스나 인터페이스의 인스턴스인지 확인하는 연산자
			if(v instanceof Flyable2) { //Airplane2도 됨
				((Flyable2) v).fly();
			}
		}
	}

}
