package java_oop;

abstract class Student2 {
	
	private String name, school;
	private int age, studentId;
	
	public Student2(String name, String school, int age, int studentId) {
		this.name = name;
		this.school = school;
		this.age = age;
		this.studentId = studentId;
	}
	
	abstract public void todo();
}

class Kim extends Student2{
	public Kim (String name, String school, int age, int studentId){
		super(name, school, age, studentId);
	}
	
	@Override
	public void todo() {
		System.out.println("점심은 김가네 김밥");
	}
}

class Baek extends Student2{
	public Baek (String name, String school, int age, int studentId){
		super(name, school, age, studentId);
	}
	
	@Override
	public void todo() {
		System.out.println("점심은 백종원 피자");
	}	
}



public class AbstractPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Kim k = new Kim("kim", "코딩온", 20, 23);
		k.todo();
		Baek b = new Baek("종원", "kdt", 10, 21);
		b.todo();
	}

}
