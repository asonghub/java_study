package java_oop;

//추상클래스 
abstract class Animals{
	
	//추상메서드 : 자식클래스가 상속받아서 정의해줘야함. 
	abstract public void sound();
	//일반메서드 : 자식클래스에서 상속받지 않아도 사용가능. 
	public void sleep() {
		System.out.println("zzz...");
	}
}

//추상클래스 Animals를 상속받는 Chicken 클래스
class Chicken extends Animals{
	@Override
	public void sound() {
		System.out.println("꼬꼬댁");
	}
}

public class AbstractEx {
	//추상클래스는 인스턴스화 할 수 없음 
	//Animals animal = new Animals();
	
	public static void main(String[] args) {
		Chicken c = new Chicken();
		c.sound();
		c.sleep();
	}

}
