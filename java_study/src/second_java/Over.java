package second_java;

public class Over {

	
	//자바스크립트
	//function a( a, b, c = 0) {}
	//a(1,2) 가능
	
	//메소드 오버로딩 
	// 정수 두개를 더하는 메소드
	public int add( int a, int b) {
		return a + b;
	}
	 
	//실수 두개를 더하는 메소
	public double  add (double a, double b) {
		return a + b ;
	}
	
	public double add (int a, int b, double c) {
		return a + b + c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Over calc = new Over();
		
		System.out.println(calc.add(1,2));
		System.out.println(calc.add(1.15,2.3));
		System.out.println(calc.add(1,2,1));

	}

}
