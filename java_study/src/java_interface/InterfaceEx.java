package java_interface;

interface Controller {
	void powerOn();
	void powerOff();
	//java 9버전 이상부터 일반 메소드 가능. default 붙이면 됨
	//외부패키지에서 접근 가능한가...? 
	default void display() {
		System.out.println("display on");
	}
}

class TV implements Controller{

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("TV power ON");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("TV power OFF");
	}
	
}

class Computer implements Controller{

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Computer power ON");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("Computer power OFF");
	}
	
}

public class InterfaceEx {
	
	public static void main(String[] arg) {
		TV tv = new TV();
		Computer computer = new Computer();
		
		tv.powerOn();
		tv.powerOff();
		computer.powerOn();
		computer.powerOff();
	}

}
