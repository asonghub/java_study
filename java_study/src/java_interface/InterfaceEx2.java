package java_interface;

interface Move{
	void moveFoward();
	void moveBackward();
}

interface Power{
	void powerOn();
	void powerOff();
}

//인터페이스는 다중상속 가능.
interface Car extends Move, Power {
	void changeGear(int gear);
	
}

class Suv implements Car{

	@Override
	public void moveFoward() {
		// TODO Auto-generated method stub
		System.out.println("앞으로 이동");
	}

	@Override
	public void moveBackward() {
		// TODO Auto-generated method stub
		System.out.println("뒤로 이동");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("시동 ON");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("시동 OFF");
	}

	@Override
	public void changeGear(int gear) {
		// TODO Auto-generated method stub
		System.out.println("기어변경: " + gear);
	}
	
}
public class InterfaceEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Suv mySuv = new Suv();
		mySuv.powerOn();
		mySuv.changeGear(5);
		mySuv.moveFoward();
		mySuv.powerOff();
		
	}

}
