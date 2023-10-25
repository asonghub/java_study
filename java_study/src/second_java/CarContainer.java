package second_java;

public class CarContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Car bmw = new Car(10);
	Car kia = new Car(20);
	
	//잘못된 접근방법
//	bmw.speed =120;
//	kia.speed = 80;
	
	
	bmw.start();
	kia.start();
	
	//잘못된 값에 대해 객체를보호 (setter의 유효성검사)
//	bmw.setSpeed(-120);
//	kia.setSpeed(-90);
	
	
//	bmw.setSpeed(120);
//	kia.setSpeed(90);
	
	int bmwSpeed = bmw.getSpeed();
	bmwSpeed = bmwSpeed +100;
	bmw.setSpeed(bmwSpeed);
	
	int kiaSpeed = kia.getSpeed();
	kiaSpeed = kiaSpeed + 80;
	kia.setSpeed(kiaSpeed);
	
	kia.increaseSpeed(100);
	
	
	System.out.println("bmw: " + bmw.getSpeed());
	System.out.println("kia: "+ kia.getSpeed());
	
	
	}
	
		
}
