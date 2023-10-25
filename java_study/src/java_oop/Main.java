package java_oop;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Person(슈퍼클래스)
		Person person = new Person("홍길동", 30);
		System.out.println(person.toString());
		
		//Student(하위클래스) 인스턴스 생성 
		Student student = new Student("아송", 20, "전자");
		System.out.println(student.toString());
		
		//하위클래스에 부모클래스의 메서드 사용
//		System.out.println(student.getName());
//		System.out.println(student.getAge());
		
		Cat cat = new Cat("야옹이", 1);
//		System.out.println(cat.);
		System.out.println(cat.makeSound());
		Dog dog = new Dog("멍멍",3);
		System.out.println(dog.makeSound());
		
		Bus bus = new Bus(4,500, "bus");
		System.out.println(bus.getPrice());
		System.out.println(bus.introduceVehicle());
	}

}
