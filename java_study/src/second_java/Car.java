package second_java;

public class Car {
	
	//접근제어자
	//public: 같은 클래스ㅇ, 같은 패키지ㅇ, 자식클래스ㅇ, 전체ㅇ
	//protected: 같은 클래스ㅇ, 같은 패키지ㅇ, 자식클래스ㅇ, 전체x
	//defualt: 같은 클래스ㅇ, 같은 패키지ㅇ
	//private: 같은 클래스ㅇ
	
	//멤버 변수 (직접 접근하지 못하도록 getter, setter 설정함 => 캡슐화)
	private int speed;
	//초기값은 0, null, false 
	
	
	//생성자(선택사항) : 클래스명과 동일해야함 (초기값 넣어주기 위해서 사용)
	public Car(int speed) {
		this.speed = speed;
	}
	
	public void start() {
		System.out.println("Car start");
//		System.out.println(speed);
	}
	
	public void increaseSpeed(int speed) {
//		this.speed = this.speed +speed;
		this.speed += speed ;
	}

	//자동으로 만들기 
	//우클릭 -> source -> generate getters and setters
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		//유효성 검사
		if(speed >0 ) {
			this.speed = speed;			
		}
		
	}


	
	
	

}
