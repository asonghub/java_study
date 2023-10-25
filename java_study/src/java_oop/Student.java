package java_oop;

public class Student extends Person{
	
	private String major;
	
	public Student(String name, int age, String major) {
		//super : 하위클래스에서 상위클래스 생성자를 호출하는데 사용
		//super 키워드는 상위 클래스의 오버라이드된 메서드를 호출하는데 사용
		super(name, age);
		setAge(age); //접근가능하다~ super.setAge 안해도 되는 이유는 오버라이드됨을 명시적으로 알려주기 위해서 사용함 여기선 그냥 쓴거라..
		this.major = major;
		
	}
	 
	@Override
	public String toString() {
		return "Student / " + super.toString() +", 전공: "+ major;
	}

}
