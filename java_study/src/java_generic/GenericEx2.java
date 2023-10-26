package java_generic;

class Box<T extends Number>{
	private T item;
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return item;
	}
}

interface Movable{
	void move();
}

class Car implements Movable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("자동차 출발");
	}
}

//제네릭 클래스
//인터페이스를 제한으로 두어서 movable를 상속받은클래스만 올수 있음 
class Container<T extends Movable> {
	private T item;
	
	public Container(T item) {
		this.item = item;
	}
	
	public void makeItMove(){
		item.move();
	}
}

public class GenericEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Box<String> stringBox = new Box<>();
//		stringBox.setItem("Hello World");
//		String value = stringBox.getItem();
//		System.out.println(value);
		
		Box<Double> doubleBox = new Box<>();
		doubleBox.setItem(3.3);
		System.out.println(doubleBox.getItem());
		
		Car a = new Car();
		
		Container<Car> container = new Container<>(a);
		
	}

}
