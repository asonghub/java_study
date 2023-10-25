package java_oop;

public class Animal {
	private String type;
	private String name;
	private int age;
	
	public Animal(String type, String name, int age) {
		this.type = type;
		this.name = name;
		this.age = age;
		}
	public String makeSound() {
		return age+ "살 " + type + name + "동물은 소리를 낸다";
	}
	

}
