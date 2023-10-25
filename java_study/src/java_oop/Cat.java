package java_oop;

public class Cat extends Animal{
	public Cat(String name, int age){
		super("cat", name, age);
	}
	
	@Override 
	public String makeSound() {
		return super.makeSound() + " 야옹";
	}
}
