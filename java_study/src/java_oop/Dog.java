package java_oop;

public class Dog extends Animal{
	public Dog(String name, int age){
		super("dog", name, age);
	}
	
	@Override 
	public String makeSound() {
		return super.makeSound() + " 멍멍";
	}
}
